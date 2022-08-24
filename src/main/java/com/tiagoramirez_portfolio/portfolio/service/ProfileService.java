package com.tiagoramirez_portfolio.portfolio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiagoramirez_portfolio.portfolio.model.Profile;
import com.tiagoramirez_portfolio.portfolio.repository.ProfileRepository;

@Service
public class ProfileService {
    @Autowired
    private ProfileRepository profileRepository;

    public List<Profile> getByUsername(String username) {
        return profileRepository.findByUserUsername(username);
    }

    public Profile getById(Integer id) {
        return profileRepository.findById(id).orElse(null);
    }

    public Integer addNew(Profile profile) {
        Profile newProfile = profileRepository.save(profile);
        return newProfile.getId();
    }

    public void edit(Profile profile) {
        profileRepository.save(profile);
    }

    public void delete(Integer id) {
        profileRepository.deleteById(id);
    }

}
