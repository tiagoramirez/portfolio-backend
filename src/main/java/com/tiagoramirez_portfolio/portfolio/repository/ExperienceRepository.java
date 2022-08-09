package com.tiagoramirez_portfolio.portfolio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tiagoramirez_portfolio.portfolio.model.Experience;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Integer> {
    public List<Experience> findByUserUsername(String username);
}
