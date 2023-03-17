package com.tawfekh.apiRestMongoDb.controller;

import com.tawfekh.apiRestMongoDb.mapper.StudentMapper;
import com.tawfekh.apiRestMongoDb.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tawfekh.mongodbservice.api.ApiApi;
import org.tawfekh.mongodbservice.models.api.resource.Address;
import org.tawfekh.mongodbservice.models.api.resource.Student;

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
public class StudentController implements ApiApi {
    private final StudentService studentService;

    @Override
    public ResponseEntity<List<Student>> fetchAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
}
