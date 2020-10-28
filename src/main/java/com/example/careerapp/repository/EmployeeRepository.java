package com.example.careerapp.repository;

import com.example.careerapp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Employee findByUsername(String username);

    @Query("from Employee where username=?1")
    List<Employee> findByUsernameOk(String username);
}
