package com.tawfekh.apiRestMongoDb;

import com.tawfekh.apiRestMongoDb.model.Address;
import com.tawfekh.apiRestMongoDb.model.GenderEnum;
import com.tawfekh.apiRestMongoDb.model.Student;
import com.tawfekh.apiRestMongoDb.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

@SpringBootApplication
public class ApiRestMongoDbApplication {

    public static void main(String[] args) {

        SpringApplication.run(ApiRestMongoDbApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(StudentRepository studentRepository) {
        return args -> {
            Address address = new Address(
                    "Senegal",
                    "99000",
                    "Diourbel");
            Student student = new Student(
                    "Khabane",
                    "Fall",
                    "khabane@gmail.com",
                    GenderEnum.MALE,
                    address,
                    List.of("Computer Science"),
                    BigDecimal.TEN,
					LocalDateTime.now()
            );
			studentRepository.insert(student);
        };
    }
}