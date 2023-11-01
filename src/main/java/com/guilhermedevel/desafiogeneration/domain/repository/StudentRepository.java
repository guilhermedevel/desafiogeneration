package com.guilhermedevel.desafiogeneration.domain.repository;

import com.guilhermedevel.desafiogeneration.domain.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
