package com.tiagoramirez_portfolio.portfolio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiagoramirez_portfolio.portfolio.model.Description;
import com.tiagoramirez_portfolio.portfolio.repository.DescriptionRepository;

@Service
public class DescriptionService {
    
    @Autowired
    private DescriptionRepository descriptionRepository;

    public Description getByProfileIdAndEducationId(Integer profileId, Integer educationId) {
        return descriptionRepository.findByProfileIdAndEducationId(profileId, educationId);
    }
    
    public Description getByProfileIdAndProjectId(Integer profileId, Integer projectId) {
        return descriptionRepository.findByProfileIdAndProjectId(profileId, projectId);
    }
    
    public Description getByProfileIdAndExperienceId(Integer profileId, Integer experienceId) {
        return descriptionRepository.findByProfileIdAndExperienceId(profileId, experienceId);
    }

    public void addNew(Description description) {
        descriptionRepository.save(description);
    }

    public void edit(Description description) {
        descriptionRepository.save(description);
    }
}
