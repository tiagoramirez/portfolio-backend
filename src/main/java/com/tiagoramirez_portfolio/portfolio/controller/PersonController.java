package com.tiagoramirez_portfolio.portfolio.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.tiagoramirez_portfolio.portfolio.model.Person;
import com.tiagoramirez_portfolio.portfolio.service.IPersonService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class PersonController {
    @Autowired
    private IPersonService personService;

    @GetMapping("/personas/{id}")
    public Person getById(@PathVariable Integer id) {
        return personService.getById(id);
    }

    @PostMapping("/personas/crear")
    public ResponseEntity<Person> addNew(@RequestBody Person person) {
        personService.addNew(person);
        return ResponseEntity.status(HttpStatus.OK).body(person);
    }

    @PutMapping("/personas/editar")
    public Person edit(@RequestBody Person person) {
        return personService.edit(person);
    }

    @DeleteMapping("/personas/borrar/{id}")
    public void delete(@PathVariable Integer id) {
        personService.delete(id);
    }

}
