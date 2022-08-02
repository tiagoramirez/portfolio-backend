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

import com.tiagoramirez_portfolio.portfolio.model.Banner;
import com.tiagoramirez_portfolio.portfolio.service.BannerService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class BannerController {

    @Autowired
    private BannerService bannerService;

    @GetMapping("/fondo/{userId}")
    public Banner getByUserId(@PathVariable Integer userId) {
        Banner returnBanner = bannerService.getByUserId(userId);
        if (returnBanner != null) {
            returnBanner.setBanner(bannerService.decompressBytes(returnBanner.getBanner()));
            return returnBanner;
        }
        return null;
    }

    @PostMapping("/fondo/crear/{userId}")
    public Banner uplaodImage(@RequestParam("banner") MultipartFile file, @PathVariable Integer userId)
            throws IOException {
        Banner banner = new Banner();
        banner.setBanner(bannerService.compressBytes(file.getBytes()));
        banner.setUserId(userId);
        return bannerService.addNew(banner);
    }

    @PutMapping("/fondo/editar/{userId}/{bannerId}")
    public Banner updateImage(@RequestParam("banner") MultipartFile file, @PathVariable Integer userId,
            @PathVariable Integer bannerId)
            throws IOException {
        Banner banner = new Banner();
        banner.setBanner(bannerService.compressBytes(file.getBytes()));
        banner.setUserId(userId);
        banner.setId(bannerId);
        return bannerService.addNew(banner);
    }
}
