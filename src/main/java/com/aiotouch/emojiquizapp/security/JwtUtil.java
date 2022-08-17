package com.aiotouch.emojiquizapp.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.stereotype.Service;

import java.security.KeyPair;
import java.security.interfaces.RSAPublicKey;
import java.time.Instant;
import java.util.Date;

@Service
public class JwtUtil {

    KeyPair keyPair = Keys.keyPairFor(SignatureAlgorithm.RS256);


    @Bean
    public JwtDecoder jwtDecoder() {
        return NimbusJwtDecoder.withPublicKey((RSAPublicKey) keyPair.getPublic()).build();
    }

    public String generateTokenWithUsername(String username) {
        return Jwts.builder()
                .setIssuer("emojiquizapp")
                .setAudience(username)
                .setSubject(username)
                .claim("scope", "SCOPE_USER")
                .setIssuedAt(new Date())
                .setExpiration(Date.from(Instant.now().plusMillis(900000)))
                .signWith(keyPair.getPrivate())
                .compact();
    }

}
