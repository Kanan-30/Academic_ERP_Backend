package com.kanangupta.studentupdate.Service;

import com.kanangupta.studentupdate.Entity.Domains;
import com.kanangupta.studentupdate.Entity.EducationDetails;
import com.kanangupta.studentupdate.Entity.Specialisation;
import com.kanangupta.studentupdate.Entity.Students;
import com.kanangupta.studentupdate.Repo.DomainRepo;
import com.kanangupta.studentupdate.Repo.EducationDetailsRepo;
import com.kanangupta.studentupdate.Repo.SpecialisationRepo;
import com.kanangupta.studentupdate.Repo.StudentRepo;
import com.kanangupta.studentupdate.dto.StudentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepository;

    @Autowired
    private DomainRepo domainRepository;

    @Autowired
    private SpecialisationRepo specialisationRepository;

    @Autowired
    private EducationDetailsRepo educationDetailsRepository;

    public void updateStudentById(Long id, StudentRequest request) {
        Students students = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        if (request.getFirstName() != null) students.setFirstName(request.getFirstName());
        if (request.getLastName() != null) students.setLastName(request.getLastName());
        if (request.getCgpa() != null) {
            students.setCgpa(BigDecimal.valueOf(request.getCgpa()));
        }

        if (request.getTotalCredits() != null) students.setTotalCredits(request.getTotalCredits());
        if (request.getGraduationYear() != null) students.setGraduationYear(request.getGraduationYear());
        if (request.getPhotographPath() != null) students.setPhotographPath(request.getPhotographPath());

        if (request.getDomainId() != null) {
            Domains Domains = domainRepository.findById(request.getDomainId())
                    .orElseThrow(() -> new RuntimeException("Domain not found"));
            students.setDomains(Domains);
        }

        if (request.getSpecialisationId() != null) {
            Specialisation specialisation = specialisationRepository.findById(request.getSpecialisationId())
                    .orElseThrow(() -> new RuntimeException("Specialisation not found"));
            students.setSpecialisation(specialisation);
        }
        EducationDetails educationDetails = students.getEducationDetails();
        if (educationDetails == null) {
            educationDetails = new EducationDetails();
            educationDetails.setStudent(students);
        }

        if (request.getSchool12thName() != null) educationDetails.setSchool12thName(request.getSchool12thName());
        if (request.getSchool12thPercentage() != null) {
            educationDetails.setSchool12thPercentage(BigDecimal.valueOf(request.getSchool12thPercentage()));
        }
        if (request.getSchool10thName() != null) educationDetails.setSchool10thName(request.getSchool10thName());
        if (request.getSchool10thPercentage() != null) {
            educationDetails.setSchool10thPercentage(BigDecimal.valueOf(request.getSchool10thPercentage()));
        }
        if (request.getBtechCollegeName() != null) educationDetails.setBtechCollegeName(request.getBtechCollegeName());
        if (request.getBtechCollegeCgpa() != null) {
            educationDetails.setBtechCollegeCgpa(BigDecimal.valueOf(request.getBtechCollegeCgpa()));
        }
        students.setEducationDetails(educationDetails);
        educationDetailsRepository.save(educationDetails);
        studentRepository.save(students);

        studentRepository.save(students);
    }

    public Students getStudentById(Long id) {
        Students student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        return student;
    }




}


