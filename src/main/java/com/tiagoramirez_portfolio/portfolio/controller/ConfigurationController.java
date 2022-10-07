package com.tiagoramirez_portfolio.portfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiagoramirez_portfolio.portfolio.dto.ResponseMessage;
import com.tiagoramirez_portfolio.portfolio.model.Configuration;
import com.tiagoramirez_portfolio.portfolio.service.ConfigurationService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/configuration")
public class ConfigurationController {

    @Autowired
    private ConfigurationService configurationService;

    @GetMapping("/get/{profileId}")
    public ResponseEntity<?> getByProfileId(@PathVariable Integer profileId) {
        Configuration response = configurationService.getByProfileId(profileId);
        if (response != null) {
            return new ResponseEntity<Configuration>(response, HttpStatus.OK);
        }
        return new ResponseEntity<ResponseMessage>(new ResponseMessage("Profile do not have configuration loaded"),
                HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/edit")
    public ResponseEntity<ResponseMessage> edit(@RequestBody Configuration configuration) {
        try {
            configurationService.addNew(configuration);
            return new ResponseEntity<ResponseMessage>(new ResponseMessage("Configuration edited."),
                    HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<ResponseMessage>(new ResponseMessage("Error editing configuration. Try again."),
                    HttpStatus.BAD_REQUEST);
        }
    }
}
