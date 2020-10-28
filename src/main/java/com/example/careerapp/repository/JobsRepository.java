package com.example.careerapp.repository;

import com.example.careerapp.entity.Employee;
import com.example.careerapp.entity.Jobs;
import com.example.careerapp.entity.Organisation;
import com.example.careerapp.entity.enums.Contract;
import com.example.careerapp.entity.enums.Hours;
import com.example.careerapp.entity.enums.StudyMode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface JobsRepository extends JpaRepository<Jobs, Integer> {
    Page<Jobs> findAllByJobTitleContainingIgnoreCaseOrContractHoursAndContractType(
            String title, Hours hours, Contract contract, Pageable pageable);

    @Query("select count(Jobs) from Jobs where organisation=?1 and valid=true")
    Integer getCurrentJobs(Organisation organisation);

    List<Jobs> findByBookmarkedEmployee(Employee employee);


}
