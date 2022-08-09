package com.tiagoramirez_portfolio.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tiagoramirez_portfolio.portfolio.model.AboutMe;

@Repository
public interface AboutMeRepository extends JpaRepository<AboutMe, Integer> {
    public AboutMe findByProfileId(Integer profileId);
}
