package ru.skypro.homework.service.impl;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;
import ru.skypro.homework.config.SecurityService;
import ru.skypro.homework.dto.auth.Register;
import ru.skypro.homework.mapper.UserMapper;
import ru.skypro.homework.repository.UserRepository;
import ru.skypro.homework.service.AuthService;


@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final SecurityService securityService;
    private final PasswordEncoder encoder;


    @Override
    public boolean login(String userName, String password) {
        if (!securityService.userExists(userName)) {
            return false;
        }
        UserDetails userDetails = securityService.loadUserByUsername(userName);
        return encoder.matches(password, userDetails.getPassword());
    }

    @Override
    public boolean register(Register register) {
        if (securityService.userExists(register.getUsername())) {
            return false;
        }
        String password = encoder.encode(register.getPassword());
        securityService.createUser(register, password);
        return true;
    }

}
