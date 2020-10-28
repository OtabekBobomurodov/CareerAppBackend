package com.example.careerapp.repository;

import com.example.careerapp.entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EducationRepository extends JpaRepository<Education, Integer> {
    List<?> findAllByEmployeeUsername(String username);
}
