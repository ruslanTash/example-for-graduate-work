package ru.skypro.homework.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.ad.AdDTO;
import ru.skypro.homework.dto.ad.ExtendedAd;
import ru.skypro.homework.entity.Ad;
import ru.skypro.homework.dto.ad.Ads;
import ru.skypro.homework.dto.ad.CreateOrUpdateAd;
import ru.skypro.homework.service.AdService;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/ads")
@RequiredArgsConstructor
public class AdsController {

    private final AdService adsService;

    @GetMapping()
    public Ads getAllAds(){
        return adsService.getAllAds();
    }

    @PostMapping(value = "/", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public AdDTO addAd(@RequestParam("properties") CreateOrUpdateAd createAd,
                       @RequestParam("image") MultipartFile image,
                       Authentication authentication){
        return adsService.addAd(createAd, image, authentication.getName());

    }

    @GetMapping("/{id}")
    public ExtendedAd getAds(@PathVariable int id, Authentication authentication) {
        return adsService.getAds(id, authentication);
    }

    @DeleteMapping("/{id}")
    public void removeAd (@PathVariable int id, Authentication authentication){
        adsService.removeAd(id, authentication);

    }

    @PatchMapping("/{id}")
    public AdDTO updateAds(@PathVariable int id,
                           @RequestBody CreateOrUpdateAd updateAd,
                           Authentication authentication){
        return adsService.updateAds(id, updateAd, authentication);
    }

    @GetMapping("/me")
    public Ads getAdsMe(Authentication authentication){
        return adsService.getAdsMe(authentication);
    }

    @PatchMapping(value = "/{id}/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String updateImage(@PathVariable int id,
                              @RequestParam("image") MultipartFile image,
                              Authentication authentication){
        return adsService.updateImage(id, image, authentication.getName());
    }

}


