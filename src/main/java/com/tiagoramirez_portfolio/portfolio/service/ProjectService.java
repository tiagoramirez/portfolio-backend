package com.tiagoramirez_portfolio.portfolio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiagoramirez_portfolio.portfolio.model.Project;
import com.tiagoramirez_portfolio.portfolio.repository.ProjectRepository;

@Service
public class ProjectService {
    
    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> getByUsername(String username) {
        return projectRepository.findByUserUsername(username);
    }

    public Project addNew(Project project) {
        return projectRepository.save(project);
    }

    public void edit(Project project) {
        projectRepository.save(project);
    }

    public void delete(Integer projectId) {
        projectRepository.deleteById(projectId);
    }
}
