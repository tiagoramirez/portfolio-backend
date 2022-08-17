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

import com.tiagoramirez_portfolio.portfolio.model.Description;
import com.tiagoramirez_portfolio.portfolio.model.Education;
import com.tiagoramirez_portfolio.portfolio.service.DescriptionService;
import com.tiagoramirez_portfolio.portfolio.service.EducationService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/education")
public class EducationController {
    @Autowired
    private EducationService educationService;

    @Autowired
    private DescriptionService descriptionService;

    @GetMapping("/{username}")
    public List<Education> getByUsername(@PathVariable String username) {
        return educationService.getByUsername(username);
    }

    @PostMapping("/add")
    public Education addNew(@RequestBody Education education) {
        return educationService.addNew(education);
    }

    @PutMapping("/edit")
    public void edit(@RequestBody Education education) {
        educationService.addNew(education);
    }

    @DeleteMapping("/delete/{educationId}")
    public void delete(@PathVariable Integer educationId) {
        educationService.delete(educationId);
    }

    @GetMapping("/description/{profileId}/{educationId}")
    public Description getByProfileAndEducationId(@PathVariable Integer profileId, @PathVariable Integer educationId){
        return descriptionService.getByProfileIdAndEducationId(profileId, educationId);
    }
}
