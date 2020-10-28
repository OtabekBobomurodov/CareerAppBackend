package com.example.careerapp.entity;

import com.example.careerapp.entity.enums.Role;
import com.example.careerapp.entity.enums.Title;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private String password;
    @Enumerated(EnumType.STRING)
    private Title title;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    private LocalDate dob;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String country;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private Integer postalCode;
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Industry> industries;
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Occupation> occupations;
    @Enumerated(EnumType.STRING)
    private Role role;

    public Employee(String username, String password, Title title, String firstName, String lastName, LocalDate dob, String address, String country, String city, Integer postalCode, List<Industry> industries, List<Occupation> occupations, Role role) {
        this.username = username;
        this.password = password;
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.address = address;
        this.country = country;
        this.city = city;
        this.postalCode = postalCode;
        this.industries = industries;
        this.occupations = occupations;
        this.role = role;
    }
}
