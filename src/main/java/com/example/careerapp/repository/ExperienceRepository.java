package com.example.careerapp.repository;

import com.example.careerapp.entity.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ExperienceRepository extends JpaRepository<Experience, Integer> {
    List<?> findAllByEmployeeUsername(String username);
}
