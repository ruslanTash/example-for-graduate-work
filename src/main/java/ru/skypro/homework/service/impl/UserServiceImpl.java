package ru.skypro.homework.service.impl;

import lombok.RequiredArgsConstructor;
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
import ru.skypro.homework.mapper.UserMapper;
import ru.skypro.homework.repository.UserRepository;
import ru.skypro.homework.service.UserService;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper map;
    private final PasswordEncoder encoder;

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
        return map.toUserDTO(user);
    }

    @Override
    public UpdateUser updateUser(Authentication authentication, UpdateUser updateUser) {
        User user = getUser(authentication);
        user.setFirstName(updateUser.getFirstName());
        user.setLastName(updateUser.getLastName());
        user.setPhone(updateUser.getPhone());
        userRepository.save(user);
        return map.userToUpdateUser(user);
    }

    @Override
    public ResponseEntity<?> updateImage(Authentication authentication, MultipartFile photo) {
        return null;
    }

    private User getUser(Authentication authentication) {
        return userRepository.getUserByEmail(authentication.getName()).orElseThrow(
                () -> {
                    throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
                });
    }
}
