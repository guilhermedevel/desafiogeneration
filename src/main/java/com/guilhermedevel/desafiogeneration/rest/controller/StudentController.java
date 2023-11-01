package com.guilhermedevel.desafiogeneration.rest.controller;

import com.guilhermedevel.desafiogeneration.domain.model.Student;
import com.guilhermedevel.desafiogeneration.domain.vo.StudentRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "Students", description = "Make Student operations")
public interface StudentController {

    @Operation(description = "Register a student")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Return a student recently registered"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "415", description = "Unsupported Media Type"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error"),
    })
    @PostMapping
    ResponseEntity<Student> register(@Valid @RequestBody StudentRequest studentRequest);

    @Operation(description = "List all students")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Return student's list"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "415", description = "Unsupported Media Type"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error"),
    })
    @GetMapping
    ResponseEntity<List<Student>> findStudents();

    @Operation(description = "Get a student")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Return student's list"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "415", description = "Unsupported Media Type"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error"),
    })
    @GetMapping(value = "/{id}")
    ResponseEntity<Student> findById(@PathVariable Integer id);
}
