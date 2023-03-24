package com.tawfekh.apiRestMongoDb.repository;

import com.tawfekh.apiRestMongoDb.model.StudentDto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends ReactiveMongoRepository<StudentDto, String> {
    Optional<StudentDto> findStudentByEmail(String email);
    @Query("{'firstName' :?0}")    //SQL Equivalent : SELECT * FROM Student WHERE ID=?
    Optional<StudentDto> getBookByFirstName(String firstName);
}
