package com.tiagoramirez_portfolio.portfolio.service;

import java.util.List;

import com.tiagoramirez_portfolio.portfolio.model.UserSocialMedia;

public interface IUserSocialMediaService {
    public List<UserSocialMedia> getByUserId(Integer userId);

    public UserSocialMedia getById(Integer id);

    public UserSocialMedia addNew(UserSocialMedia usm);

    public UserSocialMedia edit(UserSocialMedia usm);

    public void delete(Integer id);
}