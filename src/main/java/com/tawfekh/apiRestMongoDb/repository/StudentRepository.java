package com.tawfekh.apiRestMongoDb.repository;

import com.tawfekh.apiRestMongoDb.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {
    Optional<Student> findStudentByEmail(String email);

    @Query("{'firstName' :?0}")    //SQL Equivalent : SELECT * FROM Student WHERE ID=?
    Optional<Student> getBookByFirstName(String firstName);
}
