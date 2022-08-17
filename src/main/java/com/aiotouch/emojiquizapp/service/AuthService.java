package com.aiotouch.emojiquizapp.service;

import com.aiotouch.emojiquizapp.dto.AdminDTO;
import com.aiotouch.emojiquizapp.dto.ClientDTO;
import com.aiotouch.emojiquizapp.model.AuthResponse;

public interface AuthService {

    AuthResponse generateToken(String username);

    void createAdmin(AdminDTO admin);

    void createClient(ClientDTO client);
}
