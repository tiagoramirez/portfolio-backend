package com.tiagoramirez_portfolio.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tiagoramirez_portfolio.portfolio.model.Technologie;

@Repository
public interface TechnologieRepository extends JpaRepository<Technologie, Integer> {

}
