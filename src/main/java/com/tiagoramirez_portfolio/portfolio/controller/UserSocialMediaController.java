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

import com.tiagoramirez_portfolio.portfolio.model.UserSocialMedia;
import com.tiagoramirez_portfolio.portfolio.service.UserSocialMediaService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class UserSocialMediaController {
    @Autowired
    private UserSocialMediaService userSocialMediaService;

    @GetMapping("/redes-sociales/{userId}")
    public List<UserSocialMedia> getByUserId(@PathVariable Integer userId) {
        return userSocialMediaService.getByUserId(userId);
    }

    @GetMapping("/redes-sociales")
    public UserSocialMedia getById(@RequestParam Integer id) {
        return userSocialMediaService.getById(id);
    }

    @PostMapping("/redes-sociales/crear")
    public UserSocialMedia addNew(@RequestBody UserSocialMedia usm) {
        return userSocialMediaService.addNew(usm);
    }

    @PutMapping("/redes-sociales/editar")
    public UserSocialMedia edit(@RequestBody UserSocialMedia usm) {
        return userSocialMediaService.edit(usm);
    }

    @DeleteMapping("/redes-sociales/borrar/{id}")
    public void delete(@PathVariable Integer id) {
        userSocialMediaService.delete(id);
    }
}
