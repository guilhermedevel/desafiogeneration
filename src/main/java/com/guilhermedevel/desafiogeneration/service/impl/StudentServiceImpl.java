package com.guilhermedevel.desafiogeneration.service.impl;

import com.guilhermedevel.desafiogeneration.domain.exceptions.Issue;
import com.guilhermedevel.desafiogeneration.domain.exceptions.IssueEnum;
import com.guilhermedevel.desafiogeneration.domain.exceptions.ObjectNotFoundException;
import com.guilhermedevel.desafiogeneration.domain.model.Student;
import com.guilhermedevel.desafiogeneration.domain.repository.StudentRepository;
import com.guilhermedevel.desafiogeneration.domain.vo.StudentRequest;
import com.guilhermedevel.desafiogeneration.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student register(StudentRequest studentRequest) {

        var student = Student
                .builder()
                .withName(studentRequest.getName())
                .withAge(studentRequest.getAge())
                .withNote1(studentRequest.getNote1())
                .withNote2(studentRequest.getNote2())
                .withProfessorName(studentRequest.getProfessorName())
                .withClassId(studentRequest.getClassId())
                .build();

        return studentRepository.save(student);
    }

    @Override
    public List<Student> findStudents() {
        return this.studentRepository.findAll();
    }

    @Override
    public Student findById(Integer id) {
        return this.studentRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(
                        new Issue(IssueEnum.OBJECT_NOT_FOUND, String.format("Aluno com id '%s' não encontrado.", id))
                ));
    }

    @Override
    public Student update(StudentRequest studentRequest, Integer id) {
        return null;
    }
}
