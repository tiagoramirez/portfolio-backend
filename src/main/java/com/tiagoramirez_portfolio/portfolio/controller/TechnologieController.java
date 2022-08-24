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

import com.tiagoramirez_portfolio.portfolio.model.Technologie;
import com.tiagoramirez_portfolio.portfolio.model.UserTechnologies;
import com.tiagoramirez_portfolio.portfolio.service.TechnologieService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/technologie")
public class TechnologieController {
    @Autowired
    private TechnologieService technologieService;

    @GetMapping("/all")
    public List<Technologie> getAll() {
        return technologieService.getAll();
    }

    @GetMapping("/{username}")
    public List<UserTechnologies> getAllByUserId(@PathVariable String username) {
        return technologieService.getByUsername(username);
    }

    @GetMapping("")
    public UserTechnologies getById(@RequestParam Integer userTechId) {
        return technologieService.getById(userTechId);
    }

    @PostMapping("/add")
    public UserTechnologies addNew(@RequestBody UserTechnologies userTech) {
        return technologieService.addNew(userTech);
    }

    @PutMapping("/edit")
    public UserTechnologies edit(@RequestBody UserTechnologies userTech) {
        return technologieService.edit(userTech);
    }

    @DeleteMapping("/delete/{userTechId}")
    public void delete(@PathVariable Integer userTechId) {
        technologieService.delete(userTechId);
    }
}
