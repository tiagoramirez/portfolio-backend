package com.tiagoramirez_portfolio.portfolio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tiagoramirez_portfolio.portfolio.model.UserTechnologies;

@Repository
public interface UserTechnologiesRepository extends JpaRepository<UserTechnologies, Integer> {
    public List<UserTechnologies> findByUserUsername(String username);
}
