package com.anshuit.rekroot.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CompanyDto {
    private int companyId;

    private String name;

    private String logo;

    private String industry;

    private String size;

    private double rating;

    private String locations;

    private int founded;

    private String description;

    private int employees;

    private String website;

    private String createdBy;

    private LocalDateTime createdAt;

    private String updatedBy;

    private LocalDateTime updatedAt;
}
