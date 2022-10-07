package com.tiagoramirez_portfolio.portfolio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tiagoramirez_portfolio.portfolio.dto.ResponseMessage;
import com.tiagoramirez_portfolio.portfolio.model.Experience;
import com.tiagoramirez_portfolio.portfolio.service.ExperienceService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/experience")
public class ExperienceController {

    @Autowired
    private ExperienceService experienceService;

    @GetMapping("/get/{username}")
    public ResponseEntity<?> getByUsername(@PathVariable String username) {
        List<Experience> response = experienceService.getByUsername(username);
        if (response != null) {
            return new ResponseEntity<List<Experience>>(response, HttpStatus.OK);
        }
        return new ResponseEntity<ResponseMessage>(new ResponseMessage("Username do not have experience loaded"),
                HttpStatus.BAD_REQUEST);
    }

    @GetMapping("")
    public ResponseEntity<?> getById(@RequestParam Integer id) {
        Experience response = experienceService.getById(id);
        if (response != null) {
            return new ResponseEntity<Experience>(response, HttpStatus.OK);
        }
        return new ResponseEntity<ResponseMessage>(new ResponseMessage("Experience does not exist"),
                HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseMessage> addNew(@RequestBody Experience experience) {
        try {
            Integer id = experienceService.addNew(experience);
            return new ResponseEntity<ResponseMessage>(new ResponseMessage("New experience added.", id),
                    HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<ResponseMessage>(new ResponseMessage("Error adding experience. Try again."),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/edit")
    public ResponseEntity<ResponseMessage> edit(@RequestBody Experience experience) {
        try {
            experienceService.addNew(experience);
            return new ResponseEntity<ResponseMessage>(new ResponseMessage("Experience edited."),
                    HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<ResponseMessage>(new ResponseMessage("Error editing experience. Try again."),
                    HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("/delete/{experienceId}")
    public ResponseEntity<ResponseMessage> delete(@PathVariable Integer experienceId) {
        try {
            experienceService.delete(experienceId);
            return new ResponseEntity<ResponseMessage>(new ResponseMessage("Experience deleted."),
                    HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<ResponseMessage>(new ResponseMessage("Error deleting experience. Try again."),
                    HttpStatus.BAD_REQUEST);
        }
    }
}
