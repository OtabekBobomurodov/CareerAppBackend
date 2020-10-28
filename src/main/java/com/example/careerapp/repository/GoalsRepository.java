package com.example.careerapp.repository;

import com.example.careerapp.entity.Goals;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoalsRepository extends JpaRepository<Goals, Integer> {
}
