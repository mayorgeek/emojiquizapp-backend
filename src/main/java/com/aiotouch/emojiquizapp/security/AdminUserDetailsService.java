package com.aiotouch.emojiquizapp.security;

import com.aiotouch.emojiquizapp.entity.AdminDAO;
import com.aiotouch.emojiquizapp.exception.AdminNotFoundException;
import com.aiotouch.emojiquizapp.repository.AdminRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class AdminUserDetailsService implements UserDetailsService {

    private AdminRepository adminRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        AdminDAO user = adminRepo.findByUsername(username);

        if (user == null) {
            throw new AdminNotFoundException(username);
        }

        return new User(
                user.getUsername(),
                user.getPassword(),
                List.of(new SimpleGrantedAuthority("ROLE_CLIENT"),
                        new SimpleGrantedAuthority("ROLE_ADMIN"))
        );
    }
}
