package com.tawfekh.apiRestMongoDb.repository;

import com.tawfekh.apiRestMongoDb.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {
}
