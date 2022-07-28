package com.tiagoramirez_portfolio.portfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tiagoramirez_portfolio.portfolio.model.Location;
import com.tiagoramirez_portfolio.portfolio.service.ILocationService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class LocationController {
    @Autowired
    private ILocationService locationService;

    @GetMapping("/direccion/{personId}")
    public Location getByPersonId(@PathVariable Integer personId) {
        return locationService.getByPersonId(personId);
    }

    @PostMapping("/direccion/crear")
    public Location addNew(@RequestBody Location location) {
        return locationService.addNew(location);
    }

    @PutMapping("/direccion/editar")
    public Location edit(@RequestBody Location location) {
        return locationService.edit(location);
    }
}
