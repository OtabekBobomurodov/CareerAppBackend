package com.example.careerapp.repository;

import com.example.careerapp.entity.Employee;
import com.example.careerapp.entity.Organisation;
import com.example.careerapp.entity.enums.Industry;
import com.example.careerapp.entity.enums.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OrganisationRepository extends JpaRepository<Organisation, Integer> {
    Page<Organisation> findAllByNameIgnoreCaseOrIndustryAndScope(
            String name, Industry industry, Scope scope, Pageable pageable
    );

    List<Organisation> findByFollowingEmployee(Employee employee);

    Organisation findByUsername(String username);
}
