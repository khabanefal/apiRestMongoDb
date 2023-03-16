package com.tawfekh.apiRestMongoDb.controller;

import com.tawfekh.apiRestMongoDb.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tawfekh.mongodbservice.api.ApiApi;
import org.tawfekh.mongodbservice.models.api.resource.Address;
import org.tawfekh.mongodbservice.models.api.resource.Student;

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
public class StudentController implements ApiApi {

    private final StudentService studentService;

    @Override
    public ResponseEntity<List<Student>> fetchAllStudents() {
        List<com.tawfekh.apiRestMongoDb.model.Student> stu = studentService.getAllStudents();
        Student student = new Student();
        Address address = new Address();
        List<Student> students = new ArrayList<>();
        address.setCity(stu.get(0).getAddress().getCity());
        address.setCountry(stu.get(0).getAddress().getCountry());
        address.setZipCode(stu.get(0).getAddress().getZipCode());
        student.setEmail(stu.get(0).getEmail());
        student.setId(stu.get(0).getId());
        student.setFirstName(stu.get(0).getFirstName());
        student.setLastName(stu.get(0).getLastName());
        OffsetDateTime created = stu.get(0).getCreated().atZone(ZoneId.of("America/Montreal")).toOffsetDateTime();
        student.setCreated(created);
        student.setGenderEnum(org.tawfekh.mongodbservice.models.api.resource.Student.GenderEnumEnum.valueOf(stu.get(0).getGenderEnum().toString()));
        student.setTotalSpentInBooks(stu.get(0).getTotalSpentInBooks());
        student.setFavouriteSubjects(stu.get(0).getFavouriteSubjects());
        student.setAddress(address);
        students.add(student);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

 /*   @GetMapping
    public ResponseEntity<List<Student>> fetchAllStudents(){
        return  new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }*/
}
