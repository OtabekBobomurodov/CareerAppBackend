package com.example.careerapp.entity;

import com.example.careerapp.entity.enums.Industry;
import com.example.careerapp.entity.enums.Role;
import com.example.careerapp.entity.enums.Scope;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "organisation")
public class Organisation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String location;
    @Enumerated(EnumType.STRING)
    private Industry industry;
    @Enumerated(EnumType.STRING)
    private Scope scope;
    @Column(nullable = false)
    private String phone;
    @Column(nullable = false)
    private String email;
    private String website;
    private Integer postalCode;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Employee> followingEmployee;

    public Organisation(String name, String location, Industry industry, Scope scope, String phone, String email, String website, Integer postalCode, String username, String password, Role role, List<Employee> followingEmployee) {
        this.name = name;
        this.location = location;
        this.industry = industry;
        this.scope = scope;
        this.phone = phone;
        this.email = email;
        this.website = website;
        this.postalCode = postalCode;
        this.username = username;
        this.password = password;
        this.role = role;
        this.followingEmployee = followingEmployee;
    }
}
