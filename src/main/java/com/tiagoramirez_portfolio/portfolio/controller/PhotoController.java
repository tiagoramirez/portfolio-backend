package com.tiagoramirez_portfolio.portfolio.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tiagoramirez_portfolio.portfolio.dto.ResponseMessage;
import com.tiagoramirez_portfolio.portfolio.model.Photo;
import com.tiagoramirez_portfolio.portfolio.service.PhotoService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/photo")
public class PhotoController {

    @Autowired
    private PhotoService photoService;

    @GetMapping("/get/{username}")
    public Photo getByUsername(@PathVariable String username) {
        Photo returnPhoto = photoService.getByUsername(username);
        if (returnPhoto != null) {
            returnPhoto.setPhoto(photoService.decompressBytes(returnPhoto.getPhoto()));
            return returnPhoto;
        }
        return null;
    }

    @PostMapping("/add/{userId}")
    public ResponseEntity<ResponseMessage> uplaodImage(@RequestParam("photo") MultipartFile file,
            @PathVariable Integer userId)
            throws IOException {
        Photo photo = new Photo();
        try {
            photo.setPhoto(photoService.compressBytes(file.getBytes()));
            photo.setUserId(userId);
            photoService.addNew(photo);
            return new ResponseEntity<ResponseMessage>(new ResponseMessage("New photo added."),
                    HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<ResponseMessage>(new ResponseMessage("Error adding photo. Try again."),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/edit/{userId}/{photoId}")
    public ResponseEntity<ResponseMessage> updateImage(@RequestParam("photo") MultipartFile file,
            @PathVariable Integer userId,
            @PathVariable Integer photoId)
            throws IOException {
        Photo photo = new Photo();
        try {
            photo.setPhoto(photoService.compressBytes(file.getBytes()));
            photo.setUserId(userId);
            photo.setId(photoId);
            photoService.addNew(photo);
            return new ResponseEntity<ResponseMessage>(new ResponseMessage("Photo edited."),
                    HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<ResponseMessage>(new ResponseMessage("Error editing photo. Try again."),
                    HttpStatus.BAD_REQUEST);
        }
    }
}
