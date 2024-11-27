package com.kanangupta.studentupdate.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "Students")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Integer studentId;

    @Column(name = "roll_number", nullable = false, unique = true)
    private String rollNumber;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "cgpa", nullable = false)
    private BigDecimal cgpa;

    @Column(name = "total_credits", nullable = false)
    private Integer totalCredits;

    @Column(name = "graduation_year", nullable = false)
    private Integer graduationYear;

    @Column(name = "photograph_path")
    private String photographPath;

    @ManyToOne
    @JoinColumn(name = "domain_id", nullable = false)
    private Domains domains;

    @ManyToOne
    @JoinColumn(name = "specialisation_id", nullable = false)
    private Specialisation specialisation;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    @JsonManagedReference
    private EducationDetails educationDetails;
}
