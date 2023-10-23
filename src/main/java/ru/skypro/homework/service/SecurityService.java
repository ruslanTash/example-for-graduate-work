package ru.skypro.homework.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.skypro.homework.dto.SecurityUserDetails;
import ru.skypro.homework.entity.User;
import ru.skypro.homework.repository.UserRepository;

@RequiredArgsConstructor
public class SecurityService implements UserDetailsService {
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.getUserByEmail(username);
        return new SecurityUserDetails(user.getId(), user.getPassword(), user.getRole(), user.getEmail());
    }
}
