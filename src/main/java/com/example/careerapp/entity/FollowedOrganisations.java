package com.example.careerapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "followedOrganisations")
public class FollowedOrganisations {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Organisation organisation;
    @ManyToOne(fetch = FetchType.LAZY)
    private Employee employee;

    public FollowedOrganisations(Organisation organisation, Employee employee) {
        this.organisation = organisation;
        this.employee = employee;
    }
}
