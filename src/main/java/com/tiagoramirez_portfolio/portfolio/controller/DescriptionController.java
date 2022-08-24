package com.tiagoramirez_portfolio.portfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiagoramirez_portfolio.portfolio.dto.ResponseMessage;
import com.tiagoramirez_portfolio.portfolio.model.Description;
import com.tiagoramirez_portfolio.portfolio.service.DescriptionService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/description")
public class DescriptionController {

    @Autowired
    private DescriptionService descriptionService;

    @GetMapping("/experience/{profileId}/{experienceId}")
    public ResponseEntity<?> getByProfileAndExperienceId(@PathVariable Integer profileId,
            @PathVariable Integer experienceId) {
        Description response = descriptionService.getByProfileIdAndExperienceId(profileId, experienceId);
        if (response != null) {
            return new ResponseEntity<Description>(response, HttpStatus.OK);
        }
        return new ResponseEntity<ResponseMessage>(
                new ResponseMessage(
                        "Profile " + profileId + " and experience " + experienceId + "do not have description loaded"),
                HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/education/{profileId}/{educationId}")
    public ResponseEntity<?> getByProfileAndEducationId(@PathVariable Integer profileId,
            @PathVariable Integer educationId) {
        Description response = descriptionService.getByProfileIdAndEducationId(profileId, educationId);
        if (response != null) {
            return new ResponseEntity<Description>(response, HttpStatus.OK);
        }
        return new ResponseEntity<ResponseMessage>(
                new ResponseMessage(
                        "Profile " + profileId + " and experience " + educationId + "do not have description loaded"),
                HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/project/{profileId}/{projectId}")
    public ResponseEntity<?> getByProfileAndProjectId(@PathVariable Integer profileId,
            @PathVariable Integer projectId) {
        Description response = descriptionService.getByProfileIdAndProjectId(profileId, projectId);
        if (response != null) {
            return new ResponseEntity<Description>(response, HttpStatus.OK);
        }
        return new ResponseEntity<ResponseMessage>(
                new ResponseMessage(
                        "Profile " + profileId + " and experience " + projectId + "do not have description loaded"),
                HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseMessage> addNew(@RequestBody Description description) {
        try {
            descriptionService.addNew(description);
            return new ResponseEntity<ResponseMessage>(new ResponseMessage("New description added."),
                    HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<ResponseMessage>(new ResponseMessage("Error adding description. Try again."),
                    HttpStatus.BAD_REQUEST);
        }

    }

    @PutMapping("/edit")
    public ResponseEntity<ResponseMessage> editDescription(@RequestBody Description description) {
        try {
            descriptionService.addNew(description);
            return new ResponseEntity<ResponseMessage>(new ResponseMessage("Description edited."),
                    HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<ResponseMessage>(new ResponseMessage("Error editing description. Try again."),
                    HttpStatus.BAD_REQUEST);
        }
    }
}
