package ru.skypro.homework.service;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.ad.AdDTO;
import ru.skypro.homework.dto.ad.Ads;
import ru.skypro.homework.dto.ad.CreateOrUpdateAd;
import ru.skypro.homework.dto.ad.ExtendedAd;

public interface AdService {
    Ads getAllAds();
    AdDTO addAd(CreateOrUpdateAd createAd, MultipartFile image, String username);

    ExtendedAd getAds(long id, Authentication authentication);

    //    @PreAuthorize("principal.admin or #username == authentication.principal.username")
    void removeAd (long id, Authentication authentication);

    //    @PreAuthorize("principal.admin or #username == authentication.principal.username")
    AdDTO updateAds(long id, CreateOrUpdateAd updateAd, Authentication authentication);

    Ads getAdsMe(Authentication authentication);

    @PreAuthorize("principal.admin or #username == authentication.principal.username")
    String updateImage(long id,MultipartFile image, String username);

}
