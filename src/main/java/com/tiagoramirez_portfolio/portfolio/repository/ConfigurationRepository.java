package com.tiagoramirez_portfolio.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tiagoramirez_portfolio.portfolio.model.Configuration;

@Repository
public interface ConfigurationRepository extends JpaRepository<Configuration, Integer> {
    public Configuration findByProfileIdLike(Integer profileId);
}
