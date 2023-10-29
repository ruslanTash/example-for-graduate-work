package ru.skypro.homework.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import ru.skypro.homework.dto.ad.AdDTO;
import ru.skypro.homework.dto.ad.Ads;
import ru.skypro.homework.dto.ad.CreateOrUpdateAd;
import ru.skypro.homework.dto.ad.ExtendedAd;
import ru.skypro.homework.entity.Ad;
import ru.skypro.homework.entity.User;
import ru.skypro.homework.mapper.AdMapper;
import ru.skypro.homework.repository.AdRepository;
import ru.skypro.homework.repository.UserRepository;
import ru.skypro.homework.service.AdService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;


@RequiredArgsConstructor
@Service
public class AdServiceImpl implements AdService {

    private final AdRepository adsRepository;
    private final UserRepository usersRepository;
    private final AdMapper mapper;
    private final UserRepository userRepository;

    @Override
    public Ads getAllAds() {
        ArrayList<Ad> adList = (ArrayList<Ad>) adsRepository.findAll();
        ArrayList<AdDTO> adDTOList = (ArrayList<AdDTO>) adList.stream()
        .map(mapper::toAdDTO).toList();

        return new Ads(adDTOList);
    }

    @Override
    public AdDTO addAd(CreateOrUpdateAd createAd, MultipartFile image, String username) {
        User user = usersRepository.getUserByEmail(username).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        });

        Ad ad = mapper.fromCreateOrUpdate(createAd);

        String uploadDir = "C:/Users/rusla/OneDrive/Изображения/";
        File directory = new File(uploadDir);
        if (!directory.exists()) {
            directory.mkdirs();
        }
        String curDate = LocalDateTime.now().toString();
        String fileName = "image_" + curDate + "_" + image.getOriginalFilename().toLowerCase().replaceAll(" ", "-");
        String filePath = directory + "/" + fileName + "." + "PNG";
        File newImage = new File(filePath);
        try {
            Files.write(Paths.get(filePath), image.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ad.setImage(newImage.getPath());
        Ad newAd = adsRepository.save(ad);

        return mapper.toAdDTO(newAd);
    }

    @Override
    public ExtendedAd getAds(long id, Authentication authentication) {
        if (authentication.isAuthenticated()) {
            Ad ad = adsRepository.findAdByPk(id).orElseThrow(() -> {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            });
            return mapper.toExtendedAd(ad);
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }


    @Override
    public void removeAd(long id, Authentication authentication) {
        adsRepository.deleteById(id);
    }

    @Override
    public AdDTO updateAds(long id, CreateOrUpdateAd updateAd, Authentication authentication) {
        return null;
    }


    @Override
    public Ads getAdsMe(Authentication authentication) {
        Long userId = getUser(authentication).getId();

        ArrayList<Ad> adList = (ArrayList<Ad>) adsRepository.findAdsByUserId(userId);
        ArrayList<AdDTO> adDTOList = (ArrayList<AdDTO>) adList.stream()
                .map(mapper::toAdDTO).toList();

        return new Ads(new ArrayList<>(adDTOList));
    }

    @Override
    public String updateImage(long id, MultipartFile image, String username) {
        return null;
    }

    private User getUser(Authentication authentication) {
        return userRepository.getUserByEmail(authentication.getName()).orElseThrow(
                () -> {
                    throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
                });
    }
}
