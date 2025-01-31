package ru.skypro.homework.mapper;

import ru.skypro.homework.dto.ad.AdDTO;
import ru.skypro.homework.dto.ad.CreateOrUpdateAd;
import ru.skypro.homework.dto.ad.ExtendedAd;
import ru.skypro.homework.dto.auth.Login;
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
    public CreateOrUpdateAd  CreateOrUpdateAdFromAd(Ad ad){
        CreateOrUpdateAd createOrUpdateAd = new CreateOrUpdateAd();
        createOrUpdateAd.setTitle(ad.getTitle());
        createOrUpdateAd.setPrice(ad.getPrice());
        createOrUpdateAd.setDescription(ad.getDescription());
        return createOrUpdateAd;
    }
    public ExtendedAd AdFromExtendedAd(Ad ad){
        ExtendedAd extendedAd = new ExtendedAd();
        extendedAd.setPk(ad.getPk());
        extendedAd.setAuthorFirstName(ad.getUser().getFirstName());
        extendedAd.setAuthorFirstName(ad.getUser().getLastName());
        extendedAd.setDescription(ad.getDescription());
        extendedAd.setLogin(new Login().getUsername());
        extendedAd.setImage(ad.getImage());
        extendedAd.setPhone(ad.getUser().getPhone());
        extendedAd.setPrice(ad.getPrice());
        extendedAd.setTitle(ad.getTitle());
        return extendedAd;
    }

}



