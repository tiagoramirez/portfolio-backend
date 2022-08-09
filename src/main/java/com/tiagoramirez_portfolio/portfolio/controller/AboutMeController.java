package com.tiagoramirez_portfolio.portfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiagoramirez_portfolio.portfolio.model.AboutMe;
import com.tiagoramirez_portfolio.portfolio.service.AboutMeService;

@RestController
@RequestMapping("/about-me")
public class AboutMeController {

    @Autowired
    private AboutMeService aboutMeService;

    @GetMapping("/{profileId}")
    public AboutMe getByProfileId(@PathVariable Integer profileId) {
        return aboutMeService.getByProfileId(profileId);
    }

    @PostMapping("/add")
    public void addNew(@RequestBody AboutMe aboutMe) {
        aboutMeService.addNew(aboutMe);
    }

    @PutMapping
    public void edit(@RequestBody AboutMe aboutMe) {
        aboutMeService.edit(aboutMe);
    }
}
