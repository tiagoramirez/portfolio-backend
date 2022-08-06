package com.tiagoramirez_portfolio.portfolio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tiagoramirez_portfolio.portfolio.model.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {
    public List<Profile> findByUserUsername(String username);
}
