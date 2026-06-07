package com.anshuit.rekroot.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Entity
@Table(name = "contacts")
@Getter
@Setter
@NoArgsConstructor
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String userType;

    @Column(nullable = false)
    private String subject;

    @Column(nullable = false)
    private String message;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private String createdBy;

    @Column(nullable = false)
    private Instant createdAt;

    private String updatedBy;

    private Instant updatedAt;
}
