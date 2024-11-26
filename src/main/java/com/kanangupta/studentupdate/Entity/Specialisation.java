package com.kanangupta.studentupdate.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Specialisation")
@Getter
@Setter
public class Specialisation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "specialisation_id")
    private Integer specialisationId;

    @Column(name = "code", nullable = false, unique = true)
    private String code;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "year", nullable = false)
    private Integer year;

    @Column(name = "credits_required", nullable = false)
    private Integer creditsRequired;
}
