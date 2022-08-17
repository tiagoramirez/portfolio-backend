package com.tiagoramirez_portfolio.portfolio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tiagoramirez_portfolio.portfolio.model.Education;

@Repository
public interface EducationRepository extends JpaRepository<Education,Integer>{
    public List<Education> findByUserUsername(String username);
}
