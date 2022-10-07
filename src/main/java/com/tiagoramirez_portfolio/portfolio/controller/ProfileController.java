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
import com.tiagoramirez_portfolio.portfolio.model.Profile;
import com.tiagoramirez_portfolio.portfolio.service.ProfileService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    private ProfileService profileService;

    @GetMapping("/get/{username}")
    public ResponseEntity<?> getByUsername(@PathVariable String username) {
        List<Profile> response = profileService.getByUsername(username);
        if (response != null) {
            return new ResponseEntity<List<Profile>>(response, HttpStatus.OK);
        }
        return new ResponseEntity<ResponseMessage>(new ResponseMessage("Username do not have profile loaded"),
                HttpStatus.BAD_REQUEST);
    }

    @GetMapping("")
    public ResponseEntity<?> getById(@RequestParam Integer id) {
        Profile response = profileService.getById(id);
        if (response != null) {
            return new ResponseEntity<Profile>(response, HttpStatus.OK);
        }
        return new ResponseEntity<ResponseMessage>(new ResponseMessage("Profile does not exist"),
                HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseMessage> addNew(@RequestBody Profile profile) {

        try {
            profileService.addNew(profile);
            return new ResponseEntity<ResponseMessage>(new ResponseMessage("Added new profile"), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<ResponseMessage>(new ResponseMessage("Error adding profile. Try again."),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/edit")
    public ResponseEntity<ResponseMessage> edit(@RequestBody Profile profile) {
        try {
            profileService.edit(profile);
            return new ResponseEntity<ResponseMessage>(new ResponseMessage("Edited profile"), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<ResponseMessage>(new ResponseMessage("Error editing profile. Try again."),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseMessage> delete(@PathVariable Integer id) {
        try {
            profileService.delete(id);
            return new ResponseEntity<ResponseMessage>(new ResponseMessage("Deleted profile"), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<ResponseMessage>(new ResponseMessage("Error deleting profile. Try again."),
                    HttpStatus.BAD_REQUEST);
        }
    }
}
