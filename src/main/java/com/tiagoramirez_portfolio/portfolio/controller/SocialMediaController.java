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
import com.tiagoramirez_portfolio.portfolio.model.SocialMedia;
import com.tiagoramirez_portfolio.portfolio.model.UserSocialMedia;
import com.tiagoramirez_portfolio.portfolio.service.SocialMediaService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/social-media")
public class SocialMediaController {
    @Autowired
    private SocialMediaService socialMediaService;

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        List<SocialMedia> response = socialMediaService.getAll();
        if (response != null) {
            return new ResponseEntity<List<SocialMedia>>(response, HttpStatus.OK);
        }
        return new ResponseEntity<ResponseMessage>(new ResponseMessage("No social media loaded"),
                HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{username}")
    public ResponseEntity<?> getAllByUserId(@PathVariable String username) {
        List<UserSocialMedia> response = socialMediaService.getByUsername(username);
        if (response != null) {
            return new ResponseEntity<List<UserSocialMedia>>(response, HttpStatus.OK);
        }
        return new ResponseEntity<ResponseMessage>(new ResponseMessage("Username do not have social media loaded"),
                HttpStatus.BAD_REQUEST);
    }

    @GetMapping("")
    public ResponseEntity<?> getById(@RequestParam Integer usmId) {
        UserSocialMedia response = socialMediaService.getById(usmId);
        if (response != null) {
            return new ResponseEntity<UserSocialMedia>(response, HttpStatus.OK);
        }
        return new ResponseEntity<ResponseMessage>(new ResponseMessage("Social media does not exist"),
                HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseMessage> addNew(@RequestBody UserSocialMedia usm) {
        try{
            socialMediaService.addNew(usm);
            return new ResponseEntity<ResponseMessage>(new ResponseMessage("Added social media"),HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<ResponseMessage>(new ResponseMessage("Error adding social media. Try again."),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/edit")
    public ResponseEntity<ResponseMessage> edit(@RequestBody UserSocialMedia usm) {
        try{
            socialMediaService.edit(usm);
            return new ResponseEntity<ResponseMessage>(new ResponseMessage("Edited social media"),HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<ResponseMessage>(new ResponseMessage("Error editing social media. Try again."),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{usmId}")
    public ResponseEntity<ResponseMessage> delete(@PathVariable Integer usmId) {
        try{
            socialMediaService.delete(usmId);
            return new ResponseEntity<ResponseMessage>(new ResponseMessage("Deleted social media"),HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<ResponseMessage>(new ResponseMessage("Error deleting social media. Try again."),
                    HttpStatus.BAD_REQUEST);
        }
    }
}
