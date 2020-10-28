package com.example.careerapp.repository;

import com.example.careerapp.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
    Contact findByEmployeeUsername(String username);
}
