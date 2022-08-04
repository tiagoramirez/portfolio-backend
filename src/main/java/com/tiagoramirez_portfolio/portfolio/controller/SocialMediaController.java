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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public List<SocialMedia> getAll() {
        return socialMediaService.getAll();
    }

    @GetMapping("/{userId}")
    public List<UserSocialMedia> getAllByUserId(@PathVariable Integer userId) {
        return socialMediaService.getByUserId(userId);
    }

    @GetMapping("")
    public UserSocialMedia getById(@RequestParam Integer usmId) {
        return socialMediaService.getById(usmId);
    }

    @PostMapping("/add")
    public UserSocialMedia addNew(@RequestBody UserSocialMedia usm) {
        return socialMediaService.addNew(usm);
    }

    @PutMapping("/edit")
    public UserSocialMedia edit(@RequestBody UserSocialMedia usm) {
        return socialMediaService.edit(usm);
    }

    @DeleteMapping("/delete/{usmId}")
    public void delete(@PathVariable Integer usmId) {
        socialMediaService.delete(usmId);
    }
}
