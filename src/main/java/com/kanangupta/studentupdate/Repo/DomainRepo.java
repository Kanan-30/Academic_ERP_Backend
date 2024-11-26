package com.kanangupta.studentupdate.Repo;
import com.kanangupta.studentupdate.Entity.Domains;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DomainRepo extends JpaRepository<Domains, Long> {
}