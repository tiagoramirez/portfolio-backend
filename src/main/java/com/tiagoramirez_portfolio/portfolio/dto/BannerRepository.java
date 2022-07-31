package com.tiagoramirez_portfolio.portfolio.dto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tiagoramirez_portfolio.portfolio.model.Banner;

@Repository
public interface BannerRepository extends JpaRepository<Banner, Integer> {

}
