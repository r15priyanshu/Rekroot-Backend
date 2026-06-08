package com.anshuit.rekroot.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class ErrorResponseDto {
    private LocalDateTime timestamp;

    private int status;

    private String error;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String trace;

    private String message;

    private String path;

    // This Response Structure Mimics Default Spring Boot Error Response Structure.
    // Anything below here are additional fields.

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String errorCode;

    private Object validationErrors;
}