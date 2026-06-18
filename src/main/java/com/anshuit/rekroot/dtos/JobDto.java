package com.anshuit.rekroot.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class JobDto extends BaseEntityDto {
    private int jobId;

    private String title;

    private String location;

    private String workType;

    private String jobType;

    private String category;

    private String experienceLevel;

    private double salaryMin;

    private double salaryMax;

    private String salaryCurrency;

    private String salaryPeriod;

    private String description;

    private String requirements;

    private String benefits;

    private LocalDateTime postedDate;

    private LocalDateTime applicationDeadline;

    private int applicationsCount;

    private boolean featured;

    private boolean urgent;

    private boolean remote;

    private String status;

    private CompanyDto company;
}

