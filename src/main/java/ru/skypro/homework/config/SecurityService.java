package ru.skypro.homework.config;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.skypro.homework.config.SecurityUserDetails;
import ru.skypro.homework.entity.User;
import ru.skypro.homework.repository.UserRepository;

@RequiredArgsConstructor
@Service
public class SecurityService implements UserDetailsService {
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.getUserByEmail(username);
        return new SecurityUserDetails(
//                user.getId(),
                user.getPassword(), user.getRole().name(), user.getEmail());
    }
}
