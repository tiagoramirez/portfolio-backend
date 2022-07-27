package com.tiagoramirez_portfolio.portfolio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiagoramirez_portfolio.portfolio.dto.SocialMediaRepository;
import com.tiagoramirez_portfolio.portfolio.model.SocialMedia;

@Service
public class SocialMediaService implements ISocialMediaService {

    @Autowired
    private SocialMediaRepository socialMediaRepository;

    @Override
    public List<SocialMedia> getAll() {
        return socialMediaRepository.findAll();
    }
}
