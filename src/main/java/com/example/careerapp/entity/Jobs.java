package com.example.careerapp.entity;

import com.example.careerapp.entity.enums.Contract;
import com.example.careerapp.entity.enums.Currency;
import com.example.careerapp.entity.enums.Hours;
import com.example.careerapp.entity.enums.StudyMode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "jobs")
public class Jobs {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false)
    private String jobTitle;
    @Column(nullable = false)
    private String description;
    private Integer salary;
    @Enumerated(EnumType.STRING)
    private Currency currency;
    @Column(nullable = false)
    private String location;
    @Enumerated(EnumType.STRING)
    private Contract contractType;
    @Enumerated(EnumType.STRING)
    private Hours contractHours;
    private LocalDate deadline;
    @OneToOne(fetch = FetchType.LAZY)
    private Organisation organisation;
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Employee> bookmarkedEmployee;

    public Jobs(String jobTitle, String description, Integer salary, Currency currency, String location, Contract contractType, Hours contractHours, LocalDate deadline, Organisation organisation, List<Employee> bookmarkedEmployee) {
        this.jobTitle = jobTitle;
        this.description = description;
        this.salary = salary;
        this.currency = currency;
        this.location = location;
        this.contractType = contractType;
        this.contractHours = contractHours;
        this.deadline = deadline;
        this.organisation = organisation;
        this.bookmarkedEmployee = bookmarkedEmployee;
    }
}
