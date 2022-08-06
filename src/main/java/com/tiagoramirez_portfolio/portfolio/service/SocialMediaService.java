package com.tiagoramirez_portfolio.portfolio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiagoramirez_portfolio.portfolio.model.SocialMedia;
import com.tiagoramirez_portfolio.portfolio.model.UserSocialMedia;
import com.tiagoramirez_portfolio.portfolio.repository.SocialMediaRepository;
import com.tiagoramirez_portfolio.portfolio.repository.UserSocialMediaRepository;

@Service
public class SocialMediaService {

    @Autowired
    private UserSocialMediaRepository userSocialMediaRepository;

    @Autowired
    private SocialMediaRepository socialMediaRepository;

    public List<SocialMedia> getAll() {
        return socialMediaRepository.findAll();
    }

    public List<UserSocialMedia> getByUsername(String username) {
        return userSocialMediaRepository.findByUserUsername(username);
    }

    public UserSocialMedia getById(Integer usmId) {
        return userSocialMediaRepository.findById(usmId).orElse(null);
    }

    public UserSocialMedia addNew(UserSocialMedia usm) {
        return userSocialMediaRepository.save(usm);
    }

    public UserSocialMedia edit(UserSocialMedia usm) {
        return userSocialMediaRepository.save(usm);
    }

    public void delete(Integer usmId) {
        userSocialMediaRepository.deleteById(usmId);
    }

}
