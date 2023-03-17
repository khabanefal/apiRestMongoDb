package com.tawfekh.apiRestMongoDb.mapper;

import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.tawfekh.mongodbservice.models.api.resource.Student;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.List;

@Mapper
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);
    List<Student> convert(List<com.tawfekh.apiRestMongoDb.model.Student> students);
    default OffsetDateTime map(LocalDateTime localDateTime) {
        System.out.println("LocalDateTime " + LocalDateTime.now());
        System.out.println("OffsetDateTime " +LocalDateTime.now().atOffset(OffsetDateTime.now().getOffset()));
        return localDateTime.atOffset(OffsetDateTime.now().getOffset());
    }
}
