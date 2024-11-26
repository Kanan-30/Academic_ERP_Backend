package com.kanangupta.studentupdate.dto;

import lombok.Data;

@Data
public class StudentRequest {

    private String firstName;
    private String lastName;
    private Double cgpa;
    private Integer totalCredits;
    private Integer graduationYear;
    private String photographPath;
    private Long domainId;          // Reference to Domain
    private Long specialisationId;  // Reference to Specialisation
}
