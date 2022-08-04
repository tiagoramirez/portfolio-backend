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

import com.tiagoramirez_portfolio.portfolio.model.Configuration;
import com.tiagoramirez_portfolio.portfolio.service.ConfigurationService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/configuration")
public class ConfigurationController {

    @Autowired
    private ConfigurationService configurationService;

    @GetMapping("/{profileId}")
    public Configuration getByProfileId(@PathVariable Integer profileId) {
        return configurationService.getByProfileId(profileId);
    }

    @PostMapping("/create")
    public void addNew(@RequestBody Configuration configuration) {
        configurationService.addNew(configuration);
    }

    @PutMapping("/edit")
    public void edit(@RequestBody Configuration configuration) {
        configurationService.edit(configuration);
    }
}
