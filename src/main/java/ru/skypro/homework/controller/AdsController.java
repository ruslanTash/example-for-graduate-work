package ru.skypro.homework.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.entity.Ad;
import ru.skypro.homework.dto.ad.Ads;
import ru.skypro.homework.dto.ad.CreateOrUpdateAd;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/ads")
@RequiredArgsConstructor
public class AdsController {
//    private final AdService adService;

    @GetMapping
    public Ads getAds(Authentication authentication){
        Ad ad = new Ad();
        ad.setPk(1);
        ad.setPrice(22000);
        ad.setTitle("Sale");
        return new Ads(List.of(ad));
    }

    //Удаление объявления
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAdId (@PathVariable Integer id){
//        return adService.deleteAdId(id);
        return null;
    }
    //Обновление информации об объявлении
    @PatchMapping("/{id}")
    public ResponseEntity<?> updateAdId (@PathVariable Integer id,
                                         @RequestBody CreateOrUpdateAd createOrUpdateAd){
//        return adService.updateAdId(id, createOrUpdateAd);
        return null;
    }
    //Получение объявлений авторизованного пользователя
    @GetMapping("/me")
    public Ads getAdMe(){
//        Ad ad = new Ad();
//        ad.setPk(1);
//        ad.setPrice(100);
//        ad.setTitle("Sale");
//        return new Ads(List.of(ad));
        return null;
    }

//    Обновление картинки объявления

    @PatchMapping("/{id}/image")
    public ResponseEntity<?> setImageAd(@PathVariable Integer id,
                                        @RequestPart (value = "photo", required = false) MultipartFile photo){
//        return adService.setImageAd(photo);
        return null;
    }


}
