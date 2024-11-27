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

    @DeleteMapping("/students/{id}")
    public ResponseEntity<String> deleteStudent(@RequestHeader("Authorization") String authHeader,
                                                @PathVariable Long id) {
        adminService.validateAdmin(authHeader); // Validate admin
        studentService.deleteStudentById(id); // Delete student
        return ResponseEntity.ok("Student deleted successfully");
    }
    @GetMapping("/students/{id}")
    public ResponseEntity<Students> getStudent(@RequestHeader("Authorization") String authHeader,
                                               @PathVariable Long id) {
        adminService.validateAdmin(authHeader);
        Students student = studentService.getStudentById(id);
        return ResponseEntity.ok(student); // Includes education details
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<String> updateStudent(@RequestHeader("Authorization") String authHeader,
                                                @PathVariable Long id,
                                                @RequestBody StudentRequest request) {
        adminService.validateAdmin(authHeader);
        studentService.updateStudentById(id, request);
        return ResponseEntity.ok("Student details updated successfully");
    }
}
