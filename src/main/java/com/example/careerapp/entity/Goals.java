package com.example.careerapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "goals")
public class Goals {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String goal;
    @OneToOne(fetch = FetchType.LAZY)
    private Employee employee;

    public Goals(String goal, Employee employee) {
        this.goal = goal;
        this.employee = employee;
    }
}
