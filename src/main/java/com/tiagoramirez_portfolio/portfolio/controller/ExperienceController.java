package com.tiagoramirez_portfolio.portfolio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiagoramirez_portfolio.portfolio.model.Experience;
import com.tiagoramirez_portfolio.portfolio.service.ExperienceService;

@RestController
@RequestMapping("/experience")
public class ExperienceController {

    @Autowired
    private ExperienceService experienceService;

    @GetMapping("/{username}")
    public List<Experience> getByUsername(@PathVariable String username) {
        return experienceService.getByUsername(username);
    }

    @PostMapping("/add")
    public Experience addNew(@RequestBody Experience experience) {
        return experienceService.addNew(experience);
    }

    @PutMapping("/edit")
    public void edit(@RequestBody Experience experience) {
        experienceService.addNew(experience);
    }

    @DeleteMapping("/delete/{experienceId}")
    public void delete(@PathVariable Integer experienceId) {
        experienceService.delete(experienceId);
    }
}
