package com.tiagoramirez_portfolio.portfolio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiagoramirez_portfolio.portfolio.model.Education;
import com.tiagoramirez_portfolio.portfolio.repository.EducationRepository;

@Service
public class EducationService {

    @Autowired
    private EducationRepository educationRepository;

    public List<Education> getByUsername(String username) {
        return educationRepository.findByUserUsername(username);
    }

    public Education getById(Integer id) {
        return educationRepository.findById(id).orElse(null);
    }

    public Integer addNew(Education education) {
        return educationRepository.save(education).getId();
    }

    public void edit(Education education) {
        educationRepository.save(education);
    }

    public void delete(Integer educationId) {
        educationRepository.deleteById(educationId);
    }
}
