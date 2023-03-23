package com.tawfekh.apiRestMongoDb.mapper;

import com.tawfekh.apiRestMongoDb.model.StudentDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.tawfekh.mongodbservice.models.api.resource.Student;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;

@Mapper
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);
    StudentDto mapStudentToStudentDto(Student student);
    List<Student> mapListStudentDtoToStudent(List<StudentDto> studentsDto);
    Student mapStudentDtoToStudent(StudentDto studentsDto);
    default OffsetDateTime mapLocalDateTimeToOffsetDateTime(LocalDateTime localDateTime) {
        System.out.println("LocalDateTime " + LocalDateTime.now());
        System.out.println("OffsetDateTime " +LocalDateTime.now().atOffset(OffsetDateTime.now().getOffset()));
        return localDateTime.atOffset(OffsetDateTime.now().getOffset());
    }
    default LocalDateTime mapLocalDateTimeToOffsetDateTime(OffsetDateTime offsetDateTime) {
        offsetDateTime = OffsetDateTime.now();
        System.out.println(offsetDateTime);
        LocalDateTime localDateTime = offsetDateTime.toLocalDateTime();
        System.out.println("localDateTime = " + localDateTime);
        return  localDateTime;
    }
}
