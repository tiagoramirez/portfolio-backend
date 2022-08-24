package com.tiagoramirez_portfolio.portfolio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tiagoramirez_portfolio.portfolio.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Integer>{
    public List<Project> findByUserUsername(String username);
}
