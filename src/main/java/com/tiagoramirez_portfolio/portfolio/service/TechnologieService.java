package com.tiagoramirez_portfolio.portfolio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiagoramirez_portfolio.portfolio.model.Technologie;
import com.tiagoramirez_portfolio.portfolio.model.UserTechnologies;
import com.tiagoramirez_portfolio.portfolio.repository.TechnologieRepository;
import com.tiagoramirez_portfolio.portfolio.repository.UserTechnologiesRepository;

@Service
public class TechnologieService {
    @Autowired
    private UserTechnologiesRepository userTechnologiesRepository;

    @Autowired
    private TechnologieRepository technologieRepository;

    public List<Technologie> getAll() {
        return technologieRepository.findAll();
    }

    public List<UserTechnologies> getByUsername(String username) {
        return userTechnologiesRepository.findByUserUsername(username);
    }

    public UserTechnologies getById(Integer userTechId) {
        return userTechnologiesRepository.findById(userTechId).orElse(null);
    }

    public void addNew(UserTechnologies userTech) {
        userTechnologiesRepository.save(userTech);
    }

    public void edit(UserTechnologies userTech) {
        userTechnologiesRepository.save(userTech);
    }

    public void delete(Integer userTechId) {
        userTechnologiesRepository.deleteById(userTechId);
    }
}
