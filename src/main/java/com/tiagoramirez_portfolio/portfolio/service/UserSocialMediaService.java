package com.tiagoramirez_portfolio.portfolio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiagoramirez_portfolio.portfolio.model.UserSocialMedia;
import com.tiagoramirez_portfolio.portfolio.repository.UserSocialMediaRepository;

@Service
public class UserSocialMediaService {

    @Autowired
    private UserSocialMediaRepository userSocialMediaRepository;

    public List<UserSocialMedia> getByUserId(Integer userId) {
        return userSocialMediaRepository.findByUserIdLike(userId);
    }

    public UserSocialMedia getById(Integer id) {
        return userSocialMediaRepository.findById(id).orElse(null);
    }

    public UserSocialMedia addNew(UserSocialMedia usm) {
        return userSocialMediaRepository.save(usm);
    }

    public UserSocialMedia edit(UserSocialMedia usm) {
        return userSocialMediaRepository.save(usm);
    }

    public void delete(Integer id) {
        userSocialMediaRepository.deleteById(id);
    }

}
