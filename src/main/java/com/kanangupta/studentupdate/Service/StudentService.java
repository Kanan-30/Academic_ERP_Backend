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
//    public Students getStudentById(Long id) {
//        return studentRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Student not found"));
//    }

    public Students getStudentById(Long id) {
        Students student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        return student; // Includes education details due to relationship
    }

    public void deleteStudentById(Long id) {
        Students students = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        studentRepository.delete(students);
    }




}


//package com.kanangupta.studentupdate.Service;
//
//import com.kanangupta.studentupdate.Entity.Domains;
//import com.kanangupta.studentupdate.Entity.Specialisation;
//import com.kanangupta.studentupdate.Entity.Students;
//import com.kanangupta.studentupdate.Repo.DomainRepo;
//import com.kanangupta.studentupdate.Repo.SpecialisationRepo;
//import com.kanangupta.studentupdate.Repo.StudentRepo;
//import com.kanangupta.studentupdate.dto.StudentRequest;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.File;
//import java.io.IOException;
//import java.math.BigDecimal;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.Optional;
//
//@Service
//public class StudentService {
//
//    @Autowired
//    private StudentRepo studentRepository;
//
//    @Autowired
//    private DomainRepo domainRepository;
//
//    @Autowired
//    private SpecialisationRepo specialisationRepository;
//
//    private final String photoDirectory = "/home/ESD_miniProject/StudentUpdate/uploads/photos/";
//
//    public void updateStudentById(Long id, StudentRequest request) {
//        Students students = studentRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Student not found"));
//
//        if (request.getFirstName() != null) students.setFirstName(request.getFirstName());
//        if (request.getLastName() != null) students.setLastName(request.getLastName());
//        if (request.getCgpa() != null) {
//            students.setCgpa(BigDecimal.valueOf(request.getCgpa()));
//        }
//
//        if (request.getTotalCredits() != null) students.setTotalCredits(request.getTotalCredits());
//        if (request.getGraduationYear() != null) students.setGraduationYear(request.getGraduationYear());
//        if (request.getPhotographPath() != null) students.setPhotographPath(request.getPhotographPath());
//
//        if (request.getDomainId() != null) {
//            Domains Domains = domainRepository.findById(request.getDomainId())
//                    .orElseThrow(() -> new RuntimeException("Domain not found"));
//            students.setDomains(Domains);
//        }
//
//        if (request.getSpecialisationId() != null) {
//            Specialisation specialisation = specialisationRepository.findById(request.getSpecialisationId())
//                    .orElseThrow(() -> new RuntimeException("Specialisation not found"));
//            students.setSpecialisation(specialisation);
//        }
//
//        studentRepository.save(students);
//    }
//
//    public Students getStudentById(Long id) {
//        return studentRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Student not found"));
//    }
//
//    public void deleteStudentById(Long id) {
//        Students students = studentRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Student not found"));
//        studentRepository.delete(students);
//    }
//
//    public Students addPhoto(Long studentId, MultipartFile file) throws IOException {
//        Optional<Students> studentOptional = studentRepository.findById(studentId);
//        if (studentOptional.isPresent()) {
//            Students student = studentOptional.get();
//
//            Path path = Paths.get(photoDirectory);
//
//            if (!Files.exists(path)) {
//                Files.createDirectories(path); // Create the directory if it doesn't exist
//            }
//
//            // Generate the file path
//            String fileName = studentId + "_" + file.getOriginalFilename();
//            String filePath = photoDirectory + fileName;
//
//            // Destination file
//            File dest = new File(filePath);
//
//            // Transfer file to the destination directory
//            file.transferTo(dest);
//
//            student.setPhotographPath(filePath);
//            return studentRepository.save(student);
//        }
//        return null;
//    }
//}
