package com.guilhermedevel.desafiogeneration.service;

import com.guilhermedevel.desafiogeneration.domain.model.Student;
import com.guilhermedevel.desafiogeneration.domain.vo.StudentRequest;

import java.util.List;

public interface StudentService {

    Student register(StudentRequest studentRequest);

    List<Student> findStudents();

    Student findById(Integer id);

    Student update(StudentRequest studentRequest, Integer id);
}
