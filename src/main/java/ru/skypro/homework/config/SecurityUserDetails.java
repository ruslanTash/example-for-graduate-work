package ru.skypro.homework.config;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.Role;

import javax.persistence.JoinColumn;
import java.util.Collection;
import java.util.List;
@Service("userDetailsService")

public class SecurityUserDetails implements UserDetails {
//    @Getter
//    private final Integer userId;
    private final String userPassword;
    private final String userRole;
    private final String userName;

    public SecurityUserDetails(
//            Integer userId,
            String userPassword, String userRole, String userName) {
//        this.userId = userId;
        this.userPassword = userPassword;
        this.userRole = userRole;
        this.userName = userName;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + this.userRole));
    }

    @Override
    public String getPassword() {
        return this.userPassword;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
