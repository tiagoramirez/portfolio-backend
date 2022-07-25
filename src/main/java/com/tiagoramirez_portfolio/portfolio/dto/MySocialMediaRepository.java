package com.tiagoramirez_portfolio.portfolio.dto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tiagoramirez_portfolio.portfolio.model.MySocialMedia;

@Repository
public interface MySocialMediaRepository extends JpaRepository<MySocialMedia, Integer> {

}
