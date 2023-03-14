package com.tawfekh.apiRestMongoDb.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Address {

    private String country;
    private String zipCode;
    private String city;
}
