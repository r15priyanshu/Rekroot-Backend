package com.anshuit.rekroot.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CompanyDto extends BaseEntityDto {
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

    private List<JobDto> jobs;
}
