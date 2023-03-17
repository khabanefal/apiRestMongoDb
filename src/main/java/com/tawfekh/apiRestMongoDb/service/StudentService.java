package com.tawfekh.apiRestMongoDb.service;

import com.tawfekh.apiRestMongoDb.mapper.StudentMapper;
import com.tawfekh.apiRestMongoDb.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.tawfekh.mongodbservice.models.api.resource.Address;
import org.tawfekh.mongodbservice.models.api.resource.Student;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {

    private  final StudentRepository studentRepository;
    //private final StudentMapper studentMapper;
    public List<Student> getAllStudents() {
        List<com.tawfekh.apiRestMongoDb.model.Student> students = studentRepository.findAll();
        return StudentMapper.INSTANCE.convert(students);
    }
}
