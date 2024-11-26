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

    private String school12thName;
    private Double school12thPercentage;
    private String school10thName;
    private Double school10thPercentage;
    private String btechCollegeName;
    private Double btechCollegeCgpa;
}
