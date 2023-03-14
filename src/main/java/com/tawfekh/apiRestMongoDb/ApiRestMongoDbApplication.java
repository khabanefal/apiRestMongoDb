package com.tawfekh.apiRestMongoDb;

import com.tawfekh.apiRestMongoDb.model.Address;
import com.tawfekh.apiRestMongoDb.model.GenderEnum;
import com.tawfekh.apiRestMongoDb.model.Student;
import com.tawfekh.apiRestMongoDb.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class ApiRestMongoDbApplication {

    public static void main(String[] args) {

        SpringApplication.run(ApiRestMongoDbApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(
            StudentRepository studentRepository, MongoTemplate template) {
        return args -> {
            Address address = new Address(
                    "Senegal",
                    "99000",
                    "Diourbel");
            String email = "mamadou@gmail.com";
            Student student = new Student(
                    "Mamadou",
                    "Fall",
                    email,
                    GenderEnum.MALE,
                    address,
                    List.of("Computer Science"),
                    BigDecimal.TEN,
                    LocalDateTime.now()
            );
            studentRepository.findStudentByEmail(email)
                    .ifPresentOrElse(s -> {
                                System.out.println("student already exist " + student);
                            }, () -> {
                                System.out.println("inserting student " + student);
                                studentRepository.insert(student);
                            }
                    );
            Optional<Student> opt = studentRepository.getBookByFirstName("Mamadou");
            if(opt.isPresent()) {
                System.out.println("student Mamadou is found " +opt.get());
            }
            //usingMongoDbQueryWithTemplate(studentRepository, template, email, student);
        };
    }

    private static void usingMongoDbQueryWithTemplate(StudentRepository studentRepository, MongoTemplate template, String email, Student student) {
        Query query = new Query();
        query.addCriteria(Criteria.where("email").is(email));
        List<Student> students = template.find(query, Student.class);
        if (students.size() > 1) {
            throw new IllegalStateException("foud many students with email " + email);
        }
        if (students.isEmpty()) {
            System.out.println("inserting student " + student);
            studentRepository.insert(student);
        } else {
            System.out.println("student already exist " + student);
        }
    }
}