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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tiagoramirez_portfolio.portfolio.model.MySocialMedia;
import com.tiagoramirez_portfolio.portfolio.service.IMySocialMediaService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class MySocialMediaController {
    @Autowired
    private IMySocialMediaService mySocialMediaService;

    @GetMapping("/redes-sociales/{personId}")
    public List<MySocialMedia> getByPersonId(@PathVariable Integer personId) {
        return mySocialMediaService.getByPersonId(personId);
    }

    @GetMapping("/redes-sociales")
    public MySocialMedia getById(@RequestParam Integer id) {
        return mySocialMediaService.getById(id);
    }

    @PostMapping("/redes-sociales/crear")
    public MySocialMedia addNew(@RequestBody MySocialMedia msm) {
        return mySocialMediaService.addNew(msm);
    }

    @PutMapping("/redes-sociales/editar")
    public MySocialMedia edit(@RequestBody MySocialMedia msm) {
        return mySocialMediaService.edit(msm);
    }

    @DeleteMapping("/redes-sociales/borrar/{id}")
    public void delete(@PathVariable Integer id) {
        mySocialMediaService.delete(id);
    }
}
