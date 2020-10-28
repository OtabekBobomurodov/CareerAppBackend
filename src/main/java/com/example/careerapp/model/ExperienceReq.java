package com.example.careerapp.model;

import com.example.careerapp.entity.enums.Hours;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExperienceReq {
    private String title, organisationName, description, refereeName, refereeEmail, refereePhone;
    private LocalDate startDate, completionDate;
    private Hours contractHours;
}
