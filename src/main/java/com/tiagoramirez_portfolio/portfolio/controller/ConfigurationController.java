package com.tiagoramirez_portfolio.portfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tiagoramirez_portfolio.portfolio.model.Configuration;
import com.tiagoramirez_portfolio.portfolio.service.IConfigurationService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ConfigurationController {

    @Autowired
    private IConfigurationService configurationService;

    @GetMapping("/configuracion/{profileId}")
    public Configuration getByProfileId(@PathVariable Integer profileId) {
        return configurationService.getByProfileId(profileId);
    }

    @PostMapping("/configuracion/crear")
    public Configuration addNew(@RequestBody Configuration configuration) {
        return configurationService.addNew(configuration);
    }

    @PutMapping("/configuracion/editar")
    public Configuration edit(@RequestBody Configuration configuration) {
        return configurationService.edit(configuration);
    }
}
