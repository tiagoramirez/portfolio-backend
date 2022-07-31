package com.tiagoramirez_portfolio.portfolio.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tiagoramirez_portfolio.portfolio.model.Banner;
import com.tiagoramirez_portfolio.portfolio.service.IBannerService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class BannerController {

    @Autowired
    private IBannerService bannerService;

    @GetMapping("/fondo/{id}")
    public Banner getById(@PathVariable Integer id) {
        Banner returnBanner = bannerService.getById(id);
        if (returnBanner != null) {
            returnBanner.setBanner(bannerService.decompressBytes(returnBanner.getBanner()));
            return returnBanner;
        }
        return null;
    }

    @PostMapping("/fondo/crear")
    public Banner uplaodImage(@RequestParam("banner") MultipartFile file) throws IOException {
        Banner banner = new Banner();
        banner.setBanner(bannerService.compressBytes(file.getBytes()));
        return bannerService.addNew(banner);
    }
}
