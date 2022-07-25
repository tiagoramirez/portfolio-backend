package com.tiagoramirez_portfolio.portfolio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tiagoramirez_portfolio.portfolio.model.Person;
import com.tiagoramirez_portfolio.portfolio.service.IPersonService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class PersonController {
    @Autowired
    private IPersonService personService;

    @GetMapping("/personas")
    public List<Person> getAll() {
        return personService.getAll();
    }

    @PostMapping("/personas/crear")
    public ResponseEntity<Person> addNew(@RequestBody Person person) {
        personService.addNew(person);
        return ResponseEntity.status(HttpStatus.OK).body(person);
    }

}
