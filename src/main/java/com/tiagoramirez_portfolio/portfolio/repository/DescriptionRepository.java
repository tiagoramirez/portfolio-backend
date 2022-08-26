package com.tiagoramirez_portfolio.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tiagoramirez_portfolio.portfolio.model.Description;

@Repository
public interface DescriptionRepository extends JpaRepository<Description,Integer>{
    public Description findByProfileIdAndEducationId(Integer profileId, Integer educationId);
    public Description findByProfileIdAndProjectId(Integer profileId, Integer projectId);
    public Description findByProfileIdAndExperienceId(Integer profileId, Integer experienceId);
    public Description findByExperienceId( Integer experienceId);
}
