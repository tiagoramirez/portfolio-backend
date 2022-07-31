package com.tiagoramirez_portfolio.portfolio.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tiagoramirez_portfolio.portfolio.model.Photo;
import com.tiagoramirez_portfolio.portfolio.service.IPhotoService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class PhotoController {

    @Autowired
    private IPhotoService photoService;

    @GetMapping("/foto/{id}")
    public Photo getById(@PathVariable Integer id) {
        Photo returnPhoto = photoService.getById(id);
        if (returnPhoto != null) {
            returnPhoto.setPhoto(photoService.decompressBytes(returnPhoto.getPhoto()));
            return returnPhoto;
        }
        return null;
    }

    @PostMapping("/foto/crear")
    public Photo uplaodImage(@RequestParam("photo") MultipartFile file) throws IOException {
        Photo photo = new Photo();
        photo.setPhoto(photoService.compressBytes(file.getBytes()));
        return photoService.addNew(photo);
    }

    @PutMapping("/foto/editar")
    public Photo edit(@RequestBody Photo photo) {
        return photoService.edit(photo);
    }
}
