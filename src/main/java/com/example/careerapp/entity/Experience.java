package com.example.careerapp.entity;

import com.example.careerapp.entity.enums.Hours;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "experience")
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Employee employee;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String organisationName;
    private LocalDate startDate;
    private LocalDate completionDate;
    @Enumerated(EnumType.STRING)
    private Hours contractHours;
    @Column(nullable = false)
    private String description;
    private String refereeName;
    private String refereeEmail;
    private String refereePhone;

    public Experience(Employee employee, String title, String organisationName, LocalDate startDate, LocalDate completionDate, Hours contractHours, String description, String refereeName, String refereeEmail, String refereePhone) {
        this.employee = employee;
        this.title = title;
        this.organisationName = organisationName;
        this.startDate = startDate;
        this.completionDate = completionDate;
        this.contractHours = contractHours;
        this.description = description;
        this.refereeName = refereeName;
        this.refereeEmail = refereeEmail;
        this.refereePhone = refereePhone;
    }
}
