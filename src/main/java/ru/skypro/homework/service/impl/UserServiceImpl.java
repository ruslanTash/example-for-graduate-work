package ru.skypro.homework.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import ru.skypro.homework.dto.user.NewPassword;
import ru.skypro.homework.dto.user.UpdateUser;
import ru.skypro.homework.dto.user.UserDTO;
import ru.skypro.homework.entity.User;
import ru.skypro.homework.entity.Image;
import ru.skypro.homework.mapper.UserMapper;
import ru.skypro.homework.repository.ImageRepository;
import ru.skypro.homework.repository.UserRepository;
import ru.skypro.homework.service.UserService;


import java.awt.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper mapper;
    private final PasswordEncoder encoder;
    private final ImageRepository imageRepository;

    @Value("${image.upload.directory}")
    private String uploadDirectory;

    @Override
    public ResponseEntity<?> setPassword(Authentication authentication, NewPassword newPassword) {
        User user = getUser(authentication);
        if (encoder.matches(newPassword.getCurrentPassword(), user.getPassword())) {
            user.setPassword(encoder.encode(newPassword.getNewPassword()));
            userRepository.save(user);
            return new ResponseEntity<ResponseStatusException>(HttpStatus.OK);
        }
        return new ResponseEntity<ResponseStatusException>(HttpStatus.FORBIDDEN);
    }

    @Override
    public UserDTO getProfile(Authentication authentication) {
        User user = getUser(authentication);
        return mapper.toUserDTO(user);
    }

    @Override
    public UpdateUser updateUser(Authentication authentication, UpdateUser updateUser) {
        User user = getUser(authentication);
        user.setFirstName(updateUser.getFirstName());
        user.setLastName(updateUser.getLastName());
        user.setPhone(updateUser.getPhone());
        userRepository.save(user);
        return mapper.userToUpdateUser(user);
    }

    @Override
    public ResponseEntity<?> updateImage(Authentication authentication, MultipartFile file) throws IOException {

        if (!file.isEmpty()) {
            byte[] data = file.getBytes();
            String fileName = file.getOriginalFilename();


            // Сохранение файла на локальный диск
            String filePath = saveFile(data, fileName);

            // Сохранение пути к файлу в базе данных
            Image image = new Image();
            image.setData(file.getBytes());
            image.setImagePath(filePath);
            image.setImageSize(file.getSize());
            image.setImageType(file.getContentType());

            // Сохранение изображения в базе данных и получение его ID
            Long imageId = imageRepository.save(image).getImageId();

            // Извлечение имени пользователя из объекта Authentication
            String userName = authentication.getName();

            // Обновление поля imageId в сущности User
            User user = getUser(authentication);
            if (user != null) {
                user.setAvatarId(imageId);
                userRepository.save(user);
            }

            return new ResponseEntity<ResponseStatusException>(HttpStatus.OK);
        } else {
            throw new IllegalArgumentException("Uploaded file is empty");
        }

    }

    private User getUser(Authentication authentication) {
        return userRepository.getUserByEmail(authentication.getName()).orElseThrow(
                () -> {
                    throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
                });
    }

    public String saveFile(byte[] data, String fileName) throws IOException {
        String filePath = Paths.get(uploadDirectory, fileName).toString();
        Path path = Paths.get(filePath);
        Files.write(path, data);
        return filePath;
    }
}
