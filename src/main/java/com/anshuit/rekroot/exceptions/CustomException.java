package com.anshuit.rekroot.exceptions;

import com.anshuit.rekroot.enums.ErrorResponseDetailsEnum;
import com.anshuit.rekroot.utils.CustomUtil;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.io.Serial;

@Getter
@Setter
@NoArgsConstructor
public class CustomException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 8626246725048325965L;

    private ErrorResponseDetailsEnum exceptionDetailsEnum;

    private HttpStatus httpStatus;

    public CustomException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public CustomException(HttpStatus httpStatus, ErrorResponseDetailsEnum errorResponseDetailsEnum, Object... args) {
        super(CustomUtil.getFormattedErrorMessage(errorResponseDetailsEnum, args));
        this.exceptionDetailsEnum = errorResponseDetailsEnum;
        this.httpStatus = httpStatus;
    }
}