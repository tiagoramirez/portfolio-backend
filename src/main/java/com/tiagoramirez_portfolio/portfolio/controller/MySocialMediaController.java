package com.tiagoramirez_portfolio.portfolio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tiagoramirez_portfolio.portfolio.model.MySocialMedia;
import com.tiagoramirez_portfolio.portfolio.service.IMySocialMediaService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class MySocialMediaController {
    @Autowired
    private IMySocialMediaService mySocialMediaService;

    @GetMapping("/redes-sociales")
    public List<MySocialMedia> getAll() {
        return mySocialMediaService.getAll();
    }

    @PostMapping("/redes-sociales/nuevo")
    public MySocialMedia addNew(@RequestBody MySocialMedia msm) {
        mySocialMediaService.addNew(msm);
        return msm;
    }
}
