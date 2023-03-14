package com.tawfekh.apiRestMongoDb.controller;

import com.tawfekh.apiRestMongoDb.model.Student;
import com.tawfekh.apiRestMongoDb.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/students")
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> fetchAllStudents(){
        return  new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }
}
