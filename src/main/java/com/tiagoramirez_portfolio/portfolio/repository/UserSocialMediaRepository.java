package com.tiagoramirez_portfolio.portfolio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tiagoramirez_portfolio.portfolio.model.UserSocialMedia;

@Repository
public interface UserSocialMediaRepository extends JpaRepository<UserSocialMedia, Integer> {
    public List<UserSocialMedia> findByUserIdLike(Integer userId);
}
