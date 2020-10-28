package com.example.careerapp.repository;

import com.example.careerapp.entity.FollowedOrganisations;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowedOrgRepository extends JpaRepository<FollowedOrganisations, Integer> {
}
