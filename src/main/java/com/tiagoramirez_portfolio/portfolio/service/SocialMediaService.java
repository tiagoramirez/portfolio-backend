package com.tiagoramirez_portfolio.portfolio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiagoramirez_portfolio.portfolio.model.SocialMedia;
import com.tiagoramirez_portfolio.portfolio.repository.SocialMediaRepository;

@Service
public class SocialMediaService {

    @Autowired
    private SocialMediaRepository socialMediaRepository;

    public List<SocialMedia> getAll() {
        return socialMediaRepository.findAll();
    }
}
