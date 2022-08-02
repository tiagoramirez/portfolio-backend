package com.tiagoramirez_portfolio.portfolio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiagoramirez_portfolio.portfolio.model.Profile;
import com.tiagoramirez_portfolio.portfolio.repository.ProfileRepository;

@Service
public class ProfileService {
    @Autowired
    private ProfileRepository profileRepository;

    public Profile getById(Integer id) {
        return profileRepository.findById(id).orElse(null);
    }

    public Profile addNew(Profile profile) {
        return profileRepository.save(profile);
    }

    public Profile edit(Profile profile) {
        return profileRepository.save(profile);
    }

    public void delete(Integer id) {
        profileRepository.deleteById(id);
    }

}
