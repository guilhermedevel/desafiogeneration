package com.guilhermedevel.desafiogeneration.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "with")
@Entity(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 3, nullable = false)
    private Integer age;

    @Column(length = 2, nullable = false)
    private Float note1;

    @Column(length = 2, nullable = false)
    private Float note2;

    @Column(name = "professor_name", length = 50, nullable = false)
    private String professorName;

    @Column(name = "class_id", length = 10, nullable = false)
    private String classId;

}
