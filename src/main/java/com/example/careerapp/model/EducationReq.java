package com.example.careerapp.model;

import com.example.careerapp.entity.enums.Status;
import com.example.careerapp.entity.enums.StudyMode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EducationReq {
    private String country, institution, degree, award;
    private LocalDate startDate, completionDate;
    private Status status;
    private StudyMode studyMode;
}
