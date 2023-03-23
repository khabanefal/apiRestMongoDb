package com.tawfekh.apiRestMongoDb.controller;

import com.tawfekh.apiRestMongoDb.model.StudentDto;
import com.tawfekh.apiRestMongoDb.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import org.tawfekh.mongodbservice.api.StudentApi;
import org.tawfekh.mongodbservice.models.api.resource.Student;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@AllArgsConstructor
public class StudentController implements StudentApi{
    private final StudentService studentService;

    @Override
    public ResponseEntity<Student> addStudent(Student student) {
        Student stud = studentService.save(student).block();
        return new ResponseEntity<>(stud, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.findAll();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
}
