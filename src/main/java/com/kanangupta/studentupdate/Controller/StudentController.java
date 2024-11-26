//package com.kanangupta.studentupdate.Controller;
//
//import com.kanangupta.studentupdate.Entity.Student;
//import com.kanangupta.studentupdate.Service.StudentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import java.util.List;
//
//@RestController
//@RequestMapping("/students")
//public class StudentController {
//
//    @Autowired
//    private StudentService studentService;
//
//    @GetMapping
//    public List<Student> getAllStudents() {
//        return studentService.getAllStudents();
//    }
//
//    @GetMapping("/{id}")
//    public Student getStudentById(@PathVariable Long id) {
//        return studentService.getStudentById(id);
//    }
//
////    @PostMapping
////    public Student addStudent(@RequestBody Student student) {
////        return studentService.saveStudent(student);
////    }
//
//    @PutMapping("/{id}")
//    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
//        Student existingStudent = studentService.getStudentById(id);
//        existingStudent.setFirstName(student.getFirstName());
//        existingStudent.setLastName(student.getLastName());
//        existingStudent.setEmail(student.getEmail());
//        existingStudent.setCgpa(student.getCgpa());
//        existingStudent.setTotalCredits(student.getTotalCredits());
//        existingStudent.setGraduationYear(student.getGraduationYear());
//        existingStudent.setPhotographPath(student.getPhotographPath());
//        existingStudent.setDomain(student.getDomain());
//        existingStudent.setSpecialisation(student.getSpecialisation());
//        existingStudent.setPlacement(student.getPlacement());
//
//        return studentService.saveStudent(existingStudent);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteStudent(@PathVariable Long id) {
//        studentService.deleteStudent(id);
//    }
//}
