package com.anshuit.rekroot.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "companies")
@Getter
@Setter
@NoArgsConstructor
public class Company extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int companyId;

    @Column(nullable = false, unique = true)
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
}
