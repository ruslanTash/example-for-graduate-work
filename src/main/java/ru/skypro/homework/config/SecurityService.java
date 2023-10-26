package ru.skypro.homework.config;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.auth.Register;
import ru.skypro.homework.entity.User;
import ru.skypro.homework.repository.UserRepository;

@RequiredArgsConstructor
@Service
public class SecurityService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.getUserByEmail(username).orElseThrow(RuntimeException::new);
        return new SecurityUserDetails(user);
    }

    public boolean userExists(String username) {
        User userNotExists = new User();
        User users = userRepository.getUserByEmail(username).orElse(userNotExists);
        return !userNotExists.equals(users);
    }

    public void createUser(Register register, String password) {
        User user = new User();
        user.setId(user.getId());
        user.setPassword(password);
        user.setPhone(register.getPhone());
        user.setEmail(register.getUsername());
        user.setFirstName(register.getFirstName());
        user.setEmail(register.getUsername());
        user.setLastName(register.getLastName());
        user.setRole(register.getRole());
        userRepository.save(user);
    }
}
