package com.anshuit.rekroot.exceptions;

import com.anshuit.rekroot.dtos.ErrorResponseDto;
import jakarta.servlet.http.HttpServletRequest;
import org.jspecify.annotations.Nullable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponseDto> handleCustomException(CustomException exception, HttpServletRequest request) {
        ErrorResponseDto errorResponseDto = ErrorResponseDto
                .builder()
                .timestamp(LocalDateTime.now())
                .status(exception.getHttpStatus().value())
                .error(exception.getHttpStatus().getReasonPhrase())
                .trace(null)
                .message(exception.getMessage())
                .path(request.getRequestURI())
                .errorCode(exception.getExceptionDetailsEnum().getErrorCode())
                .validationErrors(null)
                .build();

        return new ResponseEntity<>(errorResponseDto, exception.getHttpStatus());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDto> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception, HttpServletRequest request) {

        HashMap<String, List<String>> validationErrors = new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach(error ->
                validationErrors.computeIfAbsent(((FieldError) error).getField(), k -> new ArrayList<>()).add(error.getDefaultMessage()));

        ErrorResponseDto errorResponseDto = ErrorResponseDto
                .builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .error(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .trace(null)
                .message(exception.getMessage())
                .path(request.getRequestURI())
                .errorCode(null)
                .validationErrors(validationErrors)
                .build();

        return new ResponseEntity<>(errorResponseDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HandlerMethodValidationException.class)
    public ResponseEntity<ErrorResponseDto> handleHandlerMethodValidationException(HandlerMethodValidationException exception, HttpServletRequest request) {

        HashMap<String, List<String>> validationErrors = new HashMap<>();
        exception.getParameterValidationResults().forEach(result ->{
            String paramName = result.getMethodParameter().getParameterName();
            List<@Nullable String> paramErrors = result.getResolvableErrors().stream().map(error -> error.getDefaultMessage()).toList();
            validationErrors.put(paramName, paramErrors);
        });

        ErrorResponseDto errorResponseDto = ErrorResponseDto
                .builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .error(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .trace(null)
                .message(exception.getMessage())
                .path(request.getRequestURI())
                .errorCode(null)
                .validationErrors(validationErrors)
                .build();

        return new ResponseEntity<>(errorResponseDto, HttpStatus.BAD_REQUEST);
    }
}
