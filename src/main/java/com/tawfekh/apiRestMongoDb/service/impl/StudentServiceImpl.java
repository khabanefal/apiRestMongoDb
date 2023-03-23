package com.tawfekh.apiRestMongoDb.service.impl;

import com.tawfekh.apiRestMongoDb.mapper.StudentMapper;
import com.tawfekh.apiRestMongoDb.model.StudentDto;
import com.tawfekh.apiRestMongoDb.repository.StudentRepository;
import com.tawfekh.apiRestMongoDb.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.tawfekh.mongodbservice.models.api.resource.Student;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private  final StudentRepository studentRepository;
    //private final StudentMapper studentMapper;
    @Override
    public Mono<Student> save(Student student) {

        StudentDto studentDto = StudentMapper.INSTANCE.mapStudentToStudentDto(student);
        Mono<StudentDto> studentDtoMono = studentRepository.save(studentDto);
        Student stud = StudentMapper.INSTANCE.mapStudentDtoToStudent(studentDtoMono.block());
        return Mono.just(stud);
    }

    @Override
    public Mono<Student> delete(String id) {
        return null;
    }

    @Override
    public Mono<Student> update(String id, Student student) {
        return null;
    }

    @Override
    public List<Student> findAll() {

        return StudentMapper.INSTANCE.mapListStudentDtoToStudent(studentRepository
                .findAll()
                .collectList()
                .block());
    }

    @Override
    public Mono<Student> findById(String id) {
        return null;
    }
}
