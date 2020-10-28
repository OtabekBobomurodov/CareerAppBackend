package com.example.careerapp.repository;

import com.example.careerapp.entity.Preferences;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PreferencesRepository extends JpaRepository<Preferences, Integer> {
    Preferences findByEmployeeUsername(String username);
}
