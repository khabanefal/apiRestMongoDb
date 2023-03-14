package com.tawfekh.apiRestMongoDb.service;

import com.tawfekh.apiRestMongoDb.model.Student;
import com.tawfekh.apiRestMongoDb.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {

    private  final StudentRepository studentRepository;
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
