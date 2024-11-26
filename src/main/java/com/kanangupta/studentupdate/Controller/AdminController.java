package com.kanangupta.studentupdate.Controller;

import com.kanangupta.studentupdate.Entity.Students;
import com.kanangupta.studentupdate.Service.AdminService;
import com.kanangupta.studentupdate.Service.StudentService;
import com.kanangupta.studentupdate.dto.AdminLoginRequest;
import com.kanangupta.studentupdate.dto.StudentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private StudentService studentService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AdminLoginRequest loginRequest) {
        String token = adminService.login(loginRequest);
        return ResponseEntity.ok(token);
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<String> updateStudent(@RequestHeader("Authorization") String authHeader,
                                                @PathVariable Long id,
                                                @RequestBody StudentRequest request) {
        adminService.validateAdmin(authHeader); // Validate admin
        studentService.updateStudentById(id, request); // Update student
        return ResponseEntity.ok("Student details updated successfully");
    }
    @GetMapping("/students/{id}")
    public ResponseEntity<Students> getStudent(@RequestHeader("Authorization") String authHeader,
                                               @PathVariable Long id) {
        adminService.validateAdmin(authHeader); // Validate admin
        Students student = studentService.getStudentById(id); // Fetch student details
        return ResponseEntity.ok(student); // Return the student details
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<String> deleteStudent(@RequestHeader("Authorization") String authHeader,
                                                @PathVariable Long id) {
        adminService.validateAdmin(authHeader); // Validate admin
        studentService.deleteStudentById(id); // Delete student
        return ResponseEntity.ok("Student deleted successfully");
    }
}


//package com.kanangupta.studentupdate.Controller;
//
//import com.kanangupta.studentupdate.Entity.Students;
//import com.kanangupta.studentupdate.Service.AdminService;
//import com.kanangupta.studentupdate.Service.StudentService;
//import com.kanangupta.studentupdate.dto.AdminLoginRequest;
//import com.kanangupta.studentupdate.dto.StudentRequest;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.util.Base64;
//
//@RestController
//@RequestMapping("/admin")
//public class AdminController {
//
//    @Autowired
//    private AdminService adminService;
//
//    @Autowired
//    private StudentService studentService;
//
//    @PostMapping("/login")
//    public ResponseEntity<String> login(@RequestBody AdminLoginRequest loginRequest) {
//        String token = adminService.login(loginRequest);
//        return ResponseEntity.ok(token);
//    }
//
//    @PutMapping("/students/{id}")
//    public ResponseEntity<String> updateStudent(@RequestHeader("Authorization") String authHeader,
//                                                @PathVariable Long id,
//                                                @RequestBody StudentRequest request) {
//        adminService.validateAdmin(authHeader); // Validate admin
//        studentService.updateStudentById(id, request); // Update student
//        return ResponseEntity.ok("Student details updated successfully");
//    }
//
//    @GetMapping("/students/{id}")
//    public ResponseEntity<Students> getStudent(@RequestHeader("Authorization") String authHeader,
//                                               @PathVariable Long id) {
//        adminService.validateAdmin(authHeader); // Validate admin
//        Students student = studentService.getStudentById(id); // Fetch student details
//
//        // Convert the photograph to Base64 if the path is available
//        if (student.getPhotographPath() != null) {
//            try {
//                File file = new File(student.getPhotographPath());
//                byte[] fileContent = Files.readAllBytes(file.toPath());
//                String base64Image = Base64.getEncoder().encodeToString(fileContent); // Using java.util.Base64
//                student.setPhotographPath(base64Image);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//        return ResponseEntity.ok(student); // Return the student details
//    }
//
//    @DeleteMapping("/students/{id}")
//    public ResponseEntity<String> deleteStudent(@RequestHeader("Authorization") String authHeader,
//                                                @PathVariable Long id) {
//        adminService.validateAdmin(authHeader); // Validate admin
//        studentService.deleteStudentById(id); // Delete student
//        return ResponseEntity.ok("Student deleted successfully");
//    }

//    @PostMapping("/students/{id}/upload-photo")
//    public ResponseEntity<Students> uploadPhoto(@RequestHeader("Authorization") String authHeader,
//                                                @PathVariable Long id,
//                                                @RequestParam("file") MultipartFile file) throws IOException {
//        adminService.validateAdmin(authHeader); // Validate admin
//        Students updatedStudent = studentService.addPhoto(id, file); // Add photo to student
//        return ResponseEntity.ok(updatedStudent);
//    }
//}

