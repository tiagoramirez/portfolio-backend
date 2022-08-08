package com.tiagoramirez_portfolio.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tiagoramirez_portfolio.portfolio.model.Photo;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, Integer> {
    public Photo findByUserUsername(String username);
}
