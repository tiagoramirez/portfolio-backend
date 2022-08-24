package com.tiagoramirez_portfolio.portfolio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiagoramirez_portfolio.portfolio.model.Project;
import com.tiagoramirez_portfolio.portfolio.service.ProjectService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/project")
public class ProjectController {
    
    @Autowired
    private ProjectService projectService;

    @GetMapping("/{username}")
    public List<Project> getByUsername(@PathVariable String username) {
        return projectService.getByUsername(username);
    }

    @PostMapping("/add")
    public Project addNew(@RequestBody Project project) {
        return projectService.addNew(project);
    }

    @PutMapping("/edit")
    public void edit(@RequestBody Project project) {
        projectService.addNew(project);
    }

    @DeleteMapping("/delete/{projectId}")
    public void delete(@PathVariable Integer projectId) {
        projectService.delete(projectId);
    }
}
