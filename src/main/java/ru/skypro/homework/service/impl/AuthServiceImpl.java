package ru.skypro.homework.service.impl;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;
import ru.skypro.homework.config.SecurityService;
import ru.skypro.homework.dto.Register;
import ru.skypro.homework.mapper.UserMapper;
import ru.skypro.homework.repository.UserRepository;
import ru.skypro.homework.service.AuthService;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {

    private final UserDetailsManager manager;
    private final SecurityService securityService;
    private final PasswordEncoder encoder;
    private final UserRepository userRepository;
    private final UserMapper map;


    @Override
    public boolean login(String userName, String password) {
        if (!manager.userExists(userName)) {
            return false;
        }
        return encoder.matches(password, securityService.loadUserByUsername(userName).getPassword());
    }

//    @Override
//    public boolean register(Register register) {
//        if (manager.userExists(register.getUsername())) {
//            return false;
//        }
//        manager.createUser(
//                User.builder()
//                        .passwordEncoder(this.encoder::encode)
//                        .password(register.getPassword())
//                        .username(register.getUsername())
//                        .roles(register.getRole().name())
//                        .build());
//        return true;
//    }


        @Override
    public boolean register(Register register) {
            if (manager.userExists(register.getUsername())) {
                return false;
            }
//        User user = map.userFromRegister(register);
//        user.setPassword(encoder.encode(register.getPassword()));
//        user.setRole(register.getRole());
//        userRepository.save(user);
//        return true;
//            ru.skypro.homework.entity.User user = new ru.skypro.homework.entity.User();
//            user.setEmail(register.getUsername());
//            user.setPassword(encoder.encode(register.getPassword()));
//            user.setFirstName(register.getFirstName());
//            user.setLastName(register.getLastName());
//            user.setPhone(register.getPhone());
//            user.setRole(register.getRole());
//            userRepository.save(user);
            manager.createUser(
                    User.builder()
                            .passwordEncoder(this.encoder::encode)
                            .password(register.getPassword())
                            .username(register.getUsername())
                            .roles(register.getRole().name())
                            .build());
            ru.skypro.homework.entity.User user = (ru.skypro.homework.entity.User) securityService.loadUserByUsername (register.getUsername());
            user.setLastName(register.getLastName());
            user.setFirstName(register.getFirstName());
            user.setPhone(register.getPhone());
            userRepository.save(user);
            return true;
    }


}
