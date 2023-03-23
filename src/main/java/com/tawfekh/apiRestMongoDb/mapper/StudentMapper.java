package com.tawfekh.apiRestMongoDb.mapper;

import com.tawfekh.apiRestMongoDb.model.StudentDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.tawfekh.mongodbservice.models.api.resource.Student;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Mapper(uses=DateMapper.class)
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);
    StudentDto mapToStudentDto(Student student);
    Student mapToStudent(StudentDto studentsDto);
}
