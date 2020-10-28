package com.example.careerapp.model;

import com.example.careerapp.entity.Employee;
import com.example.careerapp.entity.Jobs;
import com.example.careerapp.entity.Organisation;
import com.example.careerapp.entity.enums.Contract;
import com.example.careerapp.entity.enums.Currency;
import com.example.careerapp.entity.enums.Hours;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobsModel {
    private Integer id;
    private String jobTitle;
    private String description;
    private Integer salary;
    private Currency currency;
    private String location;
    private Contract contractType;
    private Hours contractHours;
    private LocalDate deadline;
    private Organisation organisation;
    private Integer isBook;
}
