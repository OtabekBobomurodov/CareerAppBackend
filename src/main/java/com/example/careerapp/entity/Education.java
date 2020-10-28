package com.example.careerapp.entity;

import com.example.careerapp.entity.enums.Status;
import com.example.careerapp.entity.enums.StudyMode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "education")
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Employee employee;
    @Column(nullable = false)
    private String country;
    @Column(nullable = false)
    private String institution;
    @Column(nullable = false)
    private String degree;
    private String award;
    @Column(nullable = false)
    private LocalDate startDate;
    private LocalDate completionDate;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Enumerated(EnumType.STRING)
    private StudyMode studyMode;

    public Education(Employee employee, String country, String institution, String degree, String award, LocalDate startDate, LocalDate completionDate, Status status, StudyMode studyMode) {
        this.employee = employee;
        this.country = country;
        this.institution = institution;
        this.degree = degree;
        this.award = award;
        this.startDate = startDate;
        this.completionDate = completionDate;
        this.status = status;
        this.studyMode = studyMode;
    }
}
