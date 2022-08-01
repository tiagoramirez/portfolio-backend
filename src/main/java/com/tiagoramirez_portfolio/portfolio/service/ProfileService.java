package com.tiagoramirez_portfolio.portfolio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiagoramirez_portfolio.portfolio.dto.ProfileRepository;
import com.tiagoramirez_portfolio.portfolio.model.Profile;

@Service
public class ProfileService implements IProfileService {
    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public Profile getById(Integer id) {
        return profileRepository.findById(id).orElse(null);
    }

    @Override
    public Profile addNew(Profile profile) {
        return profileRepository.save(profile);
    }

    @Override
    public Profile edit(Profile profile) {
        return profileRepository.save(profile);
    }

    @Override
    public void delete(Integer id) {
        profileRepository.deleteById(id);
    }

}
