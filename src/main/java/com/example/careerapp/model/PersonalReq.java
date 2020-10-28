package com.example.careerapp.model;

import com.example.careerapp.entity.enums.Title;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonalReq {
    private Title title;
    private String firstName, lastName, address, country, city;
    private Integer postalCode;
    private LocalDate dob;
}
