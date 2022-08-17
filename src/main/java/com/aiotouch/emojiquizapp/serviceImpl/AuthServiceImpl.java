package com.aiotouch.emojiquizapp.serviceImpl;

import com.aiotouch.emojiquizapp.dto.AdminDTO;
import com.aiotouch.emojiquizapp.dto.ClientDTO;
import com.aiotouch.emojiquizapp.entity.AdminDAO;
import com.aiotouch.emojiquizapp.entity.ClientDAO;
import com.aiotouch.emojiquizapp.model.AuthResponse;
import com.aiotouch.emojiquizapp.repository.AdminRepository;
import com.aiotouch.emojiquizapp.repository.ClientRepository;
import com.aiotouch.emojiquizapp.security.JwtUtil;
import com.aiotouch.emojiquizapp.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {

    private final JwtUtil jwtUtil;
    private final AdminRepository adminRepo;
    private final ClientRepository clientRepo;
    private final PasswordEncoder passwordEncoder;

    @Override
    public AuthResponse generateToken(String username) {
        return AuthResponse.builder()
                .token(jwtUtil.generateTokenWithUsername(username))
                .build();
    }

    @Override
    public void createAdmin(AdminDTO admin) {
        AdminDAO adminDAO = AdminDAO.builder()
                .username(admin.getUsername())
                .password(passwordEncoder.encode(admin.getPassword()))
                .build();

        adminRepo.save(adminDAO);
    }

    @Override
    public void createClient(ClientDTO client) {
        ClientDAO clientDAO = ClientDAO.builder()
                .username(client.getUsername())
                .password(passwordEncoder.encode(client.getPassword()))
                .build();
        clientRepo.save(clientDAO);
    }

}
