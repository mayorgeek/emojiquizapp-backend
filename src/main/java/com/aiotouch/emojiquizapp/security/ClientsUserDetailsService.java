package com.aiotouch.emojiquizapp.security;

import com.aiotouch.emojiquizapp.entity.ClientDAO;
import com.aiotouch.emojiquizapp.exception.ClientNotFoundException;
import com.aiotouch.emojiquizapp.repository.ClientRepository;
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
public class ClientsUserDetailsService implements UserDetailsService {

    private ClientRepository clientRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        ClientDAO user = clientRepo.findByUsername(username);

        if (user == null) {
            throw new ClientNotFoundException(username);
        }

        return new User(
                user.getUsername(),
                user.getPassword(),
                List.of(new SimpleGrantedAuthority("ROLE_CLIENT"))
        );
    }
}
