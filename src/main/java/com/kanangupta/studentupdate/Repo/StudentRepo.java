package com.kanangupta.studentupdate.Repo;

import com.kanangupta.studentupdate.Entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepo extends JpaRepository<Students, Long> {

//    // Query method to find a student by email
//    Optional<Students> findByEmail(String email);
}
