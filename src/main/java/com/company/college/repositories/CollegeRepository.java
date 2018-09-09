package com.company.college.repositories;

import com.company.college.model.College;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollegeRepository extends JpaRepository<College, Integer>{
}
