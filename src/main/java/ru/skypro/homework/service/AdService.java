package ru.skypro.homework.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.AdDTO.CreateOrUpdateAd;

public interface AdService {
    ResponseEntity<?> setImageAd(MultipartFile photo);

    ResponseEntity<?> getAdMe();

    ResponseEntity<?> updateAdId(Integer id, CreateOrUpdateAd createOrUpdateAd);

    ResponseEntity<?> deleteAdId(Integer id);
}
