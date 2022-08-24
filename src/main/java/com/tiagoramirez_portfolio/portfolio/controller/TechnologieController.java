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
    public ResponseEntity<?> getAll() {
        List<Technologie> response = technologieService.getAll();
        if (response != null) {
            return new ResponseEntity<List<Technologie>>(response, HttpStatus.OK);
        }
        return new ResponseEntity<ResponseMessage>(new ResponseMessage("No technologie loaded"),
                HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{username}")
    public ResponseEntity<?> getAllByUserId(@PathVariable String username) {
        List<UserTechnologies> response = technologieService.getByUsername(username);
        if (response != null) {
            return new ResponseEntity<List<UserTechnologies>>(response, HttpStatus.OK);
        }
        return new ResponseEntity<ResponseMessage>(new ResponseMessage("Username do not have technologies loaded"),
                HttpStatus.BAD_REQUEST);
    }

    @GetMapping("")
    public ResponseEntity<?> getById(@RequestParam Integer userTechId) {
        UserTechnologies response = technologieService.getById(userTechId);
        if (response != null) {
            return new ResponseEntity<UserTechnologies>(response, HttpStatus.OK);
        }
        return new ResponseEntity<ResponseMessage>(new ResponseMessage("Technologie does not exist"),
                HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseMessage> addNew(@RequestBody UserTechnologies userTech) {
        try{
            technologieService.addNew(userTech);
            return new ResponseEntity<ResponseMessage>(new ResponseMessage("Added technologie"),HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<ResponseMessage>(new ResponseMessage("Error adding technologie. Try again."),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/edit")
    public ResponseEntity<ResponseMessage> edit(@RequestBody UserTechnologies userTech) {
        try{
            technologieService.edit(userTech);
            return new ResponseEntity<ResponseMessage>(new ResponseMessage("Edited technologie"),HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<ResponseMessage>(new ResponseMessage("Error editing technologie. Try again."),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{userTechId}")
    public ResponseEntity<ResponseMessage> delete(@PathVariable Integer userTechId) {
        try{
            technologieService.delete(userTechId);
            return new ResponseEntity<ResponseMessage>(new ResponseMessage("Deleted technologie"),HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<ResponseMessage>(new ResponseMessage("Error deleting technologie. Try again."),
                    HttpStatus.BAD_REQUEST);
        }
    }
}
