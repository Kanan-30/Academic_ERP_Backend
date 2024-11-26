package com.kanangupta.studentupdate.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Domains")
@Getter
@Setter
public class Domains {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "domain_id")
    private Integer domainId;

    @Column(name = "program", nullable = false)
    private String program;

    @Column(name = "batch", nullable = false)
    private String batch;

    @Column(name = "capacity", nullable = false)
    private Integer capacity;

    @Column(name = "qualification", nullable = false)
    private String qualification;
}
