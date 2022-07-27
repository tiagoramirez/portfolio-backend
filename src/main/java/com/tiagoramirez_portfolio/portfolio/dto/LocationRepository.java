package com.tiagoramirez_portfolio.portfolio.dto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tiagoramirez_portfolio.portfolio.model.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {
    public Location findByPersonIdLike(Integer personId);
}
