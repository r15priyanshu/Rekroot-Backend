package com.anshuit.rekroot.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDateTime;

@Entity
@Table(name = "jobs")
@Getter
@Setter
@NoArgsConstructor
public class Job extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "company_id")
    private Company company;
}
