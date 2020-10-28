package com.example.careerapp.repository;

import com.example.careerapp.entity.Occupation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OccupationRepository extends JpaRepository<Occupation, Integer> {
}
