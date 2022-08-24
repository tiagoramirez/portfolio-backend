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
import com.tiagoramirez_portfolio.portfolio.model.AboutMe;
import com.tiagoramirez_portfolio.portfolio.service.AboutMeService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/about-me")
public class AboutMeController {

    @Autowired
    private AboutMeService aboutMeService;

    @GetMapping("/{profileId}")
    public ResponseEntity<?> getByProfileId(@PathVariable Integer profileId) {
        AboutMe response = aboutMeService.getByProfileId(profileId);
        if (response != null) {
            return new ResponseEntity<AboutMe>(response, HttpStatus.OK);
        }
        return new ResponseEntity<ResponseMessage>(new ResponseMessage("Profile id do not have about me"),
                HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseMessage> addNew(@RequestBody AboutMe aboutMe) {
        try {
            aboutMeService.addNew(aboutMe);
            return new ResponseEntity<ResponseMessage>(new ResponseMessage("New about me added"), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<ResponseMessage>(new ResponseMessage("Error adding about me. Try again"),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/edit")
    public ResponseEntity<ResponseMessage> edit(@RequestBody AboutMe aboutMe) {
        try {
            aboutMeService.addNew(aboutMe);
            return new ResponseEntity<ResponseMessage>(new ResponseMessage("About me edited"), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<ResponseMessage>(new ResponseMessage("Error editing about me. Try again"),
                    HttpStatus.BAD_REQUEST);
        }
    }
}
