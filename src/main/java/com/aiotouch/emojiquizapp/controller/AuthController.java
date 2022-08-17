package com.aiotouch.emojiquizapp.controller;

import com.aiotouch.emojiquizapp.dto.AdminDTO;
import com.aiotouch.emojiquizapp.dto.ClientDTO;
import com.aiotouch.emojiquizapp.model.AuthRequest;
import com.aiotouch.emojiquizapp.model.AuthResponse;
import com.aiotouch.emojiquizapp.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
@RestController
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> loginClient(@RequestBody @Valid AuthRequest authRequest) {
        Authentication authenticate = new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest);
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        return ResponseEntity.ok()
                .body(authService.generateToken(authRequest.getUsername()));
    }


    @PostMapping("/admin/register")
    public ResponseEntity<String> registerAdmin(@RequestBody @Valid AdminDTO admin) {
        authService.createAdmin(admin);
        return ResponseEntity.ok()
                .body("Registration Successful");
    }


    @PostMapping("/client/register")
    public ResponseEntity<String> registerClient(@RequestBody @Valid ClientDTO client) {
        authService.createClient(client);
        return ResponseEntity.ok()
                .body("Registration Successful");
    }

}
