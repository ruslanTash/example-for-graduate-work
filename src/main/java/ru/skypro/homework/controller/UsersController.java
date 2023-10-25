package ru.skypro.homework.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.config.SecurityUserDetails;
import ru.skypro.homework.dto.UserDTO.NewPassword;
import ru.skypro.homework.dto.UserDTO.UpdateUser;
import ru.skypro.homework.entity.User;
import ru.skypro.homework.mapper.UserMapper;
import ru.skypro.homework.repository.UserRepository;
import ru.skypro.homework.service.UserService;

@Slf4j
@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersController {
    private UserService userService;
    private UserMapper userMapper;
    private UserRepository userRepository;

    //   Обновление пароля
    @PostMapping("/set_password")
    public ResponseEntity<?> setPassword(Authentication authentication, @RequestBody NewPassword newPassword) {
       return userService.setPassword(authentication, newPassword);

    }

    //    Получение информации об авторизованном пользователе
    @GetMapping("/me")
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public User getProfile(Authentication authentication) throws Exception{
//        User user = new User();
//        user.setFirstName("Name");
//        user.setLastName("Test");
//        user.setPhone("79879000000");
//        user.setId(1);
//        return user;

        return userRepository.findById(1).orElseThrow();
//        return userService.getProfile(authentication);
    }

    //    Обновление информации об авторизованном пользователе
    @PatchMapping("/me")
    public UpdateUser updateUser(Authentication authentication,
                                        @RequestBody UpdateUser updateUser) {
        SecurityUserDetails securityUserDetails = (SecurityUserDetails) authentication.getDetails();
        return userService.updateUser(authentication, updateUser);
    }

    //    Обновление аватара авторизованного пользователя
    @PatchMapping("/me/image")
    public ResponseEntity<?> updateImage(Authentication authentication,
                                         @RequestPart (value = "photo", required = false)MultipartFile photo) {
        return userService.updateImage(authentication, photo);
    }
}
