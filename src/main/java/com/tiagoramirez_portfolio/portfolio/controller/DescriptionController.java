package com.tiagoramirez_portfolio.portfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiagoramirez_portfolio.portfolio.model.Description;
import com.tiagoramirez_portfolio.portfolio.service.DescriptionService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/description")
public class DescriptionController {

    @Autowired
    private DescriptionService descriptionService;

    @GetMapping("/experience/{profileId}/{experienceId}")
    public Description getByProfileAndExperienceId(@PathVariable Integer profileId,
            @PathVariable Integer experienceId) {
        return descriptionService.getByProfileIdAndExperienceId(profileId, experienceId);
    }

    @GetMapping("/education/{profileId}/{educationId}")
    public Description getByProfileAndEducationId(@PathVariable Integer profileId,
            @PathVariable Integer educationId) {
        return descriptionService.getByProfileIdAndEducationId(profileId, educationId);
    }

    @GetMapping("/project/{profileId}/{projectId}")
    public Description getByProfileAndProjectId(@PathVariable Integer profileId,
            @PathVariable Integer projectId) {
        return descriptionService.getByProfileIdAndProjectId(profileId, projectId);
    }

    @PostMapping("/add")
    public void addNew(@RequestBody Description description) {
        descriptionService.addNew(description);
    }

    @PutMapping("/edit")
    public void editDescription(@RequestBody Description description) {
        descriptionService.edit(description);
    }
}
