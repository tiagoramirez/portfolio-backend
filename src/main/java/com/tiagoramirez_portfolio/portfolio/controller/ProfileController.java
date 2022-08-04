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
import org.springframework.web.bind.annotation.RestController;

import com.tiagoramirez_portfolio.portfolio.model.Profile;
import com.tiagoramirez_portfolio.portfolio.service.ProfileService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    private ProfileService profileService;

    @GetMapping("/{userId}")
    public List<Profile> getById(@PathVariable Integer userId) {
        return profileService.getByUserId(userId);
    }

    @PostMapping("/add")
    public void addNew(@RequestBody Profile profile) {
        profileService.addNew(profile);
    }

    @PutMapping("/edit")
    public void edit(@RequestBody Profile profile) {
        profileService.edit(profile);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        profileService.delete(id);
    }
}
