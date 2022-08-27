package com.tiagoramirez_portfolio.portfolio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tiagoramirez_portfolio.portfolio.model.UserSkills;

@Repository
public interface UserSkillsRepository extends JpaRepository<UserSkills, Integer> {
    public List<UserSkills> findByUserUsername(String username);
}
