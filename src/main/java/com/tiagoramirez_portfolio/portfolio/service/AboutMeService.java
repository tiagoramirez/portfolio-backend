package com.tiagoramirez_portfolio.portfolio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiagoramirez_portfolio.portfolio.model.AboutMe;
import com.tiagoramirez_portfolio.portfolio.repository.AboutMeRepository;

@Service
public class AboutMeService {

    @Autowired
    private AboutMeRepository aboutMeRepository;

    public AboutMe getByProfileId(Integer profileId) {
        return aboutMeRepository.findByProfileId(profileId);
    }

    public void addNew(AboutMe aboutMe) {
        aboutMeRepository.save(aboutMe);
    }

    public void edit(AboutMe aboutMe) {
        aboutMeRepository.save(aboutMe);
    }
}
