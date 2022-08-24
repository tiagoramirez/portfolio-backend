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
import org.springframework.web.bind.annotation.RestController;

import com.tiagoramirez_portfolio.portfolio.dto.ResponseMessage;
import com.tiagoramirez_portfolio.portfolio.model.Education;
import com.tiagoramirez_portfolio.portfolio.service.EducationService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/education")
public class EducationController {
    @Autowired
    private EducationService educationService;

    @GetMapping("/{username}")
    public ResponseEntity<?> getByUsername(@PathVariable String username) {
        List<Education> response = educationService.getByUsername(username);
        if (response != null) {
            return new ResponseEntity<List<Education>>(response, HttpStatus.OK);
        }
        return new ResponseEntity<ResponseMessage>(new ResponseMessage("Username do not have education loaded"),
                HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseMessage> addNew(@RequestBody Education education) {
        try {
            educationService.addNew(education);
            return new ResponseEntity<ResponseMessage>(new ResponseMessage("New education added."),
                    HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<ResponseMessage>(new ResponseMessage("Error adding education. Try again."),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/edit")
    public ResponseEntity<ResponseMessage> edit(@RequestBody Education education) {
        try {
            educationService.addNew(education);
            return new ResponseEntity<ResponseMessage>(new ResponseMessage("Education edited."),
                    HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<ResponseMessage>(new ResponseMessage("Error editing education. Try again."),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{educationId}")
    public ResponseEntity<ResponseMessage> delete(@PathVariable Integer educationId) {
        try {
            educationService.delete(educationId);
            return new ResponseEntity<ResponseMessage>(new ResponseMessage("Education deleted."),
                    HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<ResponseMessage>(new ResponseMessage("Error deleting education. Try again."),
                    HttpStatus.BAD_REQUEST);
        }
    }
}
