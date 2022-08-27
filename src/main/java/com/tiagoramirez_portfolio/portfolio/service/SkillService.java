package com.tiagoramirez_portfolio.portfolio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiagoramirez_portfolio.portfolio.model.Skill;
import com.tiagoramirez_portfolio.portfolio.model.UserSkills;
import com.tiagoramirez_portfolio.portfolio.repository.SkillRepository;
import com.tiagoramirez_portfolio.portfolio.repository.UserSkillsRepository;

@Service
public class SkillService {
    @Autowired
    private UserSkillsRepository userSkillsRepository;

    @Autowired
    private SkillRepository skillRepository;

    public List<Skill> getAll() {
        return skillRepository.findAll();
    }

    public List<UserSkills> getByUsername(String username) {
        return userSkillsRepository.findByUserUsername(username);
    }

    public UserSkills getById(Integer userTechId) {
        return userSkillsRepository.findById(userTechId).orElse(null);
    }

    public void addNew(UserSkills userTech) {
        userSkillsRepository.save(userTech);
    }

    public void edit(UserSkills userTech) {
        userSkillsRepository.save(userTech);
    }

    public void delete(Integer userTechId) {
        userSkillsRepository.deleteById(userTechId);
    }
}
