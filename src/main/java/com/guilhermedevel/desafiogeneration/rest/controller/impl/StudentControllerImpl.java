package com.guilhermedevel.desafiogeneration.rest.controller.impl;

import com.guilhermedevel.desafiogeneration.domain.model.Student;
import com.guilhermedevel.desafiogeneration.domain.vo.StudentRequest;
import com.guilhermedevel.desafiogeneration.rest.controller.StudentController;
import com.guilhermedevel.desafiogeneration.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/student")
public class StudentControllerImpl implements StudentController {

    private final StudentService studentService;

    public StudentControllerImpl(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public ResponseEntity<Student> register(StudentRequest studentRequest) {

        var student = studentService.register(studentRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }

    @Override
    public ResponseEntity<List<Student>> findStudents() {
        var studentsList = this.studentService.findStudents();

        return ResponseEntity.ok(studentsList);
    }

    @Override
    public ResponseEntity<Student> findById(Integer id) {
        var student = this.studentService.findById(id);

        return ResponseEntity.ok(student);
    }
}
