package com.tiagoramirez_portfolio.portfolio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiagoramirez_portfolio.portfolio.dto.UserSocialMediaRepository;
import com.tiagoramirez_portfolio.portfolio.model.UserSocialMedia;

@Service
public class UserSocialMediaService implements IUserSocialMediaService {

    @Autowired
    private UserSocialMediaRepository userSocialMediaRepository;

    @Override
    public List<UserSocialMedia> getByUserId(Integer userId) {
        return userSocialMediaRepository.findByUserIdLike(userId);
    }

    @Override
    public UserSocialMedia getById(Integer id) {
        return userSocialMediaRepository.findById(id).orElse(null);
    }

    @Override
    public UserSocialMedia addNew(UserSocialMedia usm) {
        return userSocialMediaRepository.save(usm);
    }

    @Override
    public UserSocialMedia edit(UserSocialMedia usm) {
        return userSocialMediaRepository.save(usm);
    }

    @Override
    public void delete(Integer id) {
        userSocialMediaRepository.deleteById(id);
    }

}
