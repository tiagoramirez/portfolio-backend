package com.tiagoramirez_portfolio.portfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tiagoramirez_portfolio.portfolio.model.Profile;
import com.tiagoramirez_portfolio.portfolio.service.IProfileService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ProfileController {
    @Autowired
    private IProfileService profileService;

    @GetMapping("/perfil/{id}")
    public Profile getById(@PathVariable Integer id) {
        return profileService.getById(id);
    }

    @PostMapping("/perfil/crear")
    public Profile addNew(@RequestBody Profile profile) {
        return profileService.addNew(profile);
    }

    @PutMapping("/perfil/editar")
    public Profile edit(@RequestBody Profile profile) {
        return profileService.edit(profile);
    }

    @DeleteMapping("/perfil/borrar/{id}")
    public void delete(@PathVariable Integer id) {
        profileService.delete(id);
    }
}
