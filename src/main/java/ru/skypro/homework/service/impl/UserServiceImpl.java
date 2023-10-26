package ru.skypro.homework.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.user.NewPassword;
import ru.skypro.homework.dto.user.UpdateUser;
import ru.skypro.homework.entity.User;
import ru.skypro.homework.repository.UserRepository;
import ru.skypro.homework.service.UserService;
@Component
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public ResponseEntity<?> setPassword(Authentication authentication, NewPassword newPassword) {
        return null;
    }

    @Override
    public User getProfile(Authentication authentication) {
        //проверка авторизации авторизация.getId()
        userRepository.findById(1);
        return null;
    }

    @Override
    public UpdateUser updateUser(Authentication authentication, UpdateUser updateUser) {
        return null;
    }

    @Override
    public ResponseEntity<?> updateImage(Authentication authentication, MultipartFile photo) {
        return null;
    }
}
