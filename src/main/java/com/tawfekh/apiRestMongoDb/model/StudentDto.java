package com.tawfekh.apiRestMongoDb.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Document(value = "students")
public class StudentDto {
   @Id
    private String id;
    private String firstName;
    private String lastName;
    @Indexed(unique = true) //from MongoDB
    private String email;
    private GenderEnum genderEnum;
    private Address address;
    private List<String> favouriteSubjects;
    private BigDecimal totalSpentInBooks;
    private LocalDateTime created;


    public StudentDto(String firstName,
                      String lastName,
                      String email,
                      GenderEnum genderEnum,
                      Address address,
                      List<String> favouriteSubjects,
                      BigDecimal totalSpentInBooks,
                      LocalDateTime created) {
  this.firstName = firstName;
  this.lastName = lastName;
  this.email = email;
  this.genderEnum = genderEnum;
  this.address = address;
  this.favouriteSubjects = favouriteSubjects;
  this.totalSpentInBooks = totalSpentInBooks;
  this.created = created;
 }
}
