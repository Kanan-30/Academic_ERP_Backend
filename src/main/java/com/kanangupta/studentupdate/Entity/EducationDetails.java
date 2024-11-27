package com.kanangupta.studentupdate.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "education_details")
@Getter
@Setter
public class EducationDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "education_id")
    private Integer id;

    @OneToOne
    @JsonBackReference
    @JoinColumn(name = "student_id", nullable = false)
    private Students student;

    @Column(name = "school_12th_name")
    private String school12thName;

    @Column(name = "school_12th_percentage")
    private BigDecimal school12thPercentage;

    @Column(name = "school_10th_name")
    private String school10thName;

    @Column(name = "school_10th_percentage")
    private BigDecimal school10thPercentage;

    @Column(name = "btech_college_name")
    private String btechCollegeName;

    @Column(name = "btech_college_cgpa")
    private BigDecimal btechCollegeCgpa;
}