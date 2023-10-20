package ru.skypro.homework.mapper;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import ru.skypro.homework.dto.AdDTO.AdDTO;
import ru.skypro.homework.dto.AdDTO.Ads;
import ru.skypro.homework.dto.AdDTO.CreateOrUpdateAd;
import ru.skypro.homework.dto.AdDTO.ExtendedAd;
import ru.skypro.homework.entity.Ad;



public class AdMapper {
    public Ad AdFromAdDTO(AdDTO atDdo) {
        Ad ad = new Ad();
        ad.setImage(atDdo.getImage());
        ad.setPk(atDdo.getPk());
        ad.setPrice(atDdo.getPrice());
        ad.setTitle(atDdo.getTitle());
        return ad;
    }
    public AdDTO AdDTOFromAd(Ad ad){
        AdDTO adDTO = new AdDTO();
        adDTO.setImage(ad.getImage());
        adDTO.setPk(ad.getPk());
        adDTO.setPrice(ad.getPrice());
        adDTO.setTitle(ad.getTitle());
        return adDTO;
    }

    public Ad AdFromCreateOrUpdate(CreateOrUpdateAd createOrUpdateAd) {
        Ad ad = new Ad();
        ad.setTitle(createOrUpdateAd.getTitle());
        ad.setPrice(createOrUpdateAd.getPrice());
        ad.setDescription(createOrUpdateAd.getDescription());
        return ad;
    }
    public CreateOrUpdateAd  reateOrUpdateAdFromAd(Ad ad){
        CreateOrUpdateAd createOrUpdateAd = new CreateOrUpdateAd();
        createOrUpdateAd.setTitle(ad.getTitle());
        createOrUpdateAd.setPrice(ad.getPrice());
        createOrUpdateAd.setDescription(ad.getDescription());
        return createOrUpdateAd;
    }

}



