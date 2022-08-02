package com.tiagoramirez_portfolio.portfolio.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tiagoramirez_portfolio.portfolio.model.Photo;
import com.tiagoramirez_portfolio.portfolio.service.PhotoService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class PhotoController {

    @Autowired
    private PhotoService photoService;

    @GetMapping("/foto/{userId}")
    public Photo getById(@PathVariable Integer userId) {
        Photo returnPhoto = photoService.getByUserId(userId);
        if (returnPhoto != null) {
            returnPhoto.setPhoto(photoService.decompressBytes(returnPhoto.getPhoto()));
            return returnPhoto;
        }
        return null;
    }

    @PostMapping("/foto/crear/{userId}")
    public Photo uplaodImage(@RequestParam("photo") MultipartFile file, @PathVariable Integer userId)
            throws IOException {
        Photo photo = new Photo();
        photo.setPhoto(photoService.compressBytes(file.getBytes()));
        photo.setUserId(userId);
        return photoService.addNew(photo);
    }

    @PutMapping("/fondo/editar/{userId}/{photoId}")
    public Photo updateImage(@RequestParam("photo") MultipartFile file, @PathVariable Integer userId,
            @PathVariable Integer photoId)
            throws IOException {
        Photo photo = new Photo();
        photo.setPhoto(photoService.compressBytes(file.getBytes()));
        photo.setUserId(userId);
        photo.setId(photoId);
        return photoService.addNew(photo);
    }
}
