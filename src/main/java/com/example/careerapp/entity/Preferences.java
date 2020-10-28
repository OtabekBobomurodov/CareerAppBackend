package com.example.careerapp.entity;

import com.example.careerapp.entity.enums.Contract;
import com.example.careerapp.entity.enums.Currency;
import com.example.careerapp.entity.enums.Level;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "preferences")
public class Preferences {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @OneToOne(fetch = FetchType.LAZY)
    private Employee employee;
    @Column(nullable = false)
    private String industry;
    @Column(nullable = false)
    private String position;
    @Enumerated(EnumType.STRING)
    private Level level;
    private String workMode;
    private Integer salary;
    @Enumerated(EnumType.STRING)
    private Currency currency;
    @Enumerated(EnumType.STRING)
    private Contract contractType;


    public Preferences(Employee employee, String industry, String position, Level level, String workMode, Integer salary, Currency currency, Contract contractType) {
        this.employee = employee;
        this.industry = industry;
        this.position = position;
        this.level = level;
        this.workMode = workMode;
        this.salary = salary;
        this.currency = currency;
        this.contractType = contractType;
    }
}
