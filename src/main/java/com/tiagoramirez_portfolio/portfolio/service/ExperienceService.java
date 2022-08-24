package com.tiagoramirez_portfolio.portfolio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiagoramirez_portfolio.portfolio.model.Experience;
import com.tiagoramirez_portfolio.portfolio.repository.ExperienceRepository;

@Service
public class ExperienceService {

    @Autowired
    private ExperienceRepository experienceRepository;

    public List<Experience> getByUsername(String username) {
        return experienceRepository.findByUserUsername(username);
    }

    public void addNew(Experience experience) {
        experienceRepository.save(experience);
    }

    public void edit(Experience experience) {
        experienceRepository.save(experience);
    }

    public void delete(Integer experienceId) {
        experienceRepository.deleteById(experienceId);
    }
}
