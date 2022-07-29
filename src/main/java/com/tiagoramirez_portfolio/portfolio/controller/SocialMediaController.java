package com.tiagoramirez_portfolio.portfolio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiagoramirez_portfolio.portfolio.model.SocialMedia;
import com.tiagoramirez_portfolio.portfolio.service.ISocialMediaService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class SocialMediaController {

    @Autowired
    private ISocialMediaService socialMediaService;

    @GetMapping("redes-sociales/todas")
    public List<SocialMedia> getAll() {
        return socialMediaService.getAll();
    }
}
