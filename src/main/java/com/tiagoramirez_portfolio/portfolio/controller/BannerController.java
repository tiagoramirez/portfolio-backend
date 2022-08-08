package com.tiagoramirez_portfolio.portfolio.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tiagoramirez_portfolio.portfolio.model.Banner;
import com.tiagoramirez_portfolio.portfolio.service.BannerService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/banner")
public class BannerController {

    @Autowired
    private BannerService bannerService;

    @GetMapping("/{username}")
    public Banner getByUsername(@PathVariable String username) {
        Banner returnBanner = bannerService.getByUsername(username);
        if (returnBanner != null) {
            returnBanner.setBanner(bannerService.decompressBytes(returnBanner.getBanner()));
            return returnBanner;
        }
        return null;
    }

    @PostMapping("/add/{userId}")
    public void uplaodImage(@RequestParam("banner") MultipartFile file, @PathVariable Integer userId)
            throws IOException {
        Banner banner = new Banner();
        banner.setBanner(bannerService.compressBytes(file.getBytes()));
        banner.setUserId(userId);
        bannerService.addNew(banner);
    }

    @PutMapping("/edit/{userId}/{bannerId}")
    public void updateImage(@RequestParam("banner") MultipartFile file, @PathVariable Integer userId,
            @PathVariable Integer bannerId)
            throws IOException {
        Banner banner = new Banner();
        banner.setBanner(bannerService.compressBytes(file.getBytes()));
        banner.setUserId(userId);
        banner.setId(bannerId);
        bannerService.addNew(banner);
    }
}