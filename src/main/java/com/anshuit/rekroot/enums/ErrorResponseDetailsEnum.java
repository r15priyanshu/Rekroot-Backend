package com.anshuit.rekroot.enums;

import lombok.Getter;

@Getter
public enum ErrorResponseDetailsEnum {
    // Contact Related Constants
    CONTACT_NOT_FOUND_WITH_ID("2001", "Contact Not Found With Id : %s");

    private final String errorCode;
    private final String errorMessage;

    ErrorResponseDetailsEnum(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
