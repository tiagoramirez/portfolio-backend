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
import com.tiagoramirez_portfolio.portfolio.model.Skill;
import com.tiagoramirez_portfolio.portfolio.model.UserSkills;
import com.tiagoramirez_portfolio.portfolio.service.SkillService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/skill")
public class SkillController {
    @Autowired
    private SkillService skillService;

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        List<Skill> response = skillService.getAll();
        if (response != null) {
            return new ResponseEntity<List<Skill>>(response, HttpStatus.OK);
        }
        return new ResponseEntity<ResponseMessage>(new ResponseMessage("No skill loaded"),
                HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{username}")
    public ResponseEntity<?> getAllByUserId(@PathVariable String username) {
        List<UserSkills> response = skillService.getByUsername(username);
        if (response != null) {
            return new ResponseEntity<List<UserSkills>>(response, HttpStatus.OK);
        }
        return new ResponseEntity<ResponseMessage>(new ResponseMessage("Username do not have skills loaded"),
                HttpStatus.BAD_REQUEST);
    }

    @GetMapping("")
    public ResponseEntity<?> getById(@RequestParam Integer userSkillId) {
        UserSkills response = skillService.getById(userSkillId);
        if (response != null) {
            return new ResponseEntity<UserSkills>(response, HttpStatus.OK);
        }
        return new ResponseEntity<ResponseMessage>(new ResponseMessage("skill does not exist"),
                HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseMessage> addNew(@RequestBody UserSkills userSkill) {
        try{
            skillService.addNew(userSkill);
            return new ResponseEntity<ResponseMessage>(new ResponseMessage("Added skill"),HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<ResponseMessage>(new ResponseMessage("Error adding skill. Try again."),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/edit")
    public ResponseEntity<ResponseMessage> edit(@RequestBody UserSkills userSkill) {
        try{
            skillService.edit(userSkill);
            return new ResponseEntity<ResponseMessage>(new ResponseMessage("Edited skill"),HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<ResponseMessage>(new ResponseMessage("Error editing skill. Try again."),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{userSkillId}")
    public ResponseEntity<ResponseMessage> delete(@PathVariable Integer userSkillId) {
        try{
            skillService.delete(userSkillId);
            return new ResponseEntity<ResponseMessage>(new ResponseMessage("Deleted skill"),HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<ResponseMessage>(new ResponseMessage("Error deleting skill. Try again."),
                    HttpStatus.BAD_REQUEST);
        }
    }
}
