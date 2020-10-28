package com.example.careerapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "contact")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY)
    private Employee employee;

    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String phone;
    private String mobile;

    public Contact(Employee employee, String email, String phone, String mobile) {
        this.employee = employee;
        this.email = email;
        this.phone = phone;
        this.mobile = mobile;
    }
}
