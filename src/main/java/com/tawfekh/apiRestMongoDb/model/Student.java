package com.tawfekh.apiRestMongoDb.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

@Data
@Document
public class Student {
   @Id
    private String id;
    private String fistName;
    private String lastName;
    private String email;
    private GenderEnum genderEnum;
    private Address address;
    private List<String> favouriteSubjects;
    private BigDecimal totalSpentInBooks;
    private LocalDateTime created;


    public Student(String fistName,
                String lastName,
                String email,
                GenderEnum genderEnum,
                Address address,
                List<String> favouriteSubjects,
                BigDecimal totalSpentInBooks,
                LocalDateTime created) {
  this.fistName = fistName;
  this.lastName = lastName;
  this.email = email;
  this.genderEnum = genderEnum;
  this.address = address;
  this.favouriteSubjects = favouriteSubjects;
  this.totalSpentInBooks = totalSpentInBooks;
  this.created = created;
 }
}
