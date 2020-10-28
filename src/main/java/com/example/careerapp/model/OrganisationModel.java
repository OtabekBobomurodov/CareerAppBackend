package com.example.careerapp.model;

import com.example.careerapp.entity.enums.Industry;
import com.example.careerapp.entity.enums.Scope;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganisationModel {
    private Integer id;
    private String name;
    private String location;
    private Industry industry;
    private Scope scope;
    private String phone;
    private String email;
    private String website;
    private Integer postalCode;
    private Integer isBook;
}
