package com.anshuit.rekroot.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class ContactDto {
    private int id;

    private String name;

    private String email;

    private String userType;

    private String subject;

    private String message;

    private String status;

    private String createdBy;

    private Instant createdAt;

    private String updatedBy;

    private Instant updatedAt;
}
