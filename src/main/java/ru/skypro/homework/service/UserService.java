package ru.skypro.homework.service;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.user.NewPassword;
import ru.skypro.homework.dto.user.UpdateUser;
import ru.skypro.homework.dto.user.UserDTO;

import java.io.IOException;

public interface UserService {
    ResponseEntity<?> setPassword(Authentication authentication, NewPassword newPassword);

    UserDTO getProfile(Authentication authentication);

    UpdateUser updateUser(Authentication authentication, UpdateUser updateUser);

    ResponseEntity<?> updateImage(Authentication authentication, MultipartFile photo) throws IOException;
}
