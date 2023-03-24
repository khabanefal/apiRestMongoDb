package com.tawfekh.apiRestMongoDb.service;

import com.tawfekh.apiRestMongoDb.mapper.StudentMapper;
import com.tawfekh.apiRestMongoDb.model.StudentDto;
import com.tawfekh.apiRestMongoDb.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.tawfekh.mongodbservice.models.api.resource.Student;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface StudentService {

    Mono<Student> save(Student student);

    Mono<Student> delete(String id);

    Mono<Student> update(String id, Student studentDto);

    List<Student> findAll();

    Mono<Student> findById(String id);
}
