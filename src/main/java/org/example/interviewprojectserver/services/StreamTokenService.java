package org.example.interviewprojectserver.services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class StreamTokenService {

    // Make sure this is your Stream VIDEO API secret, not Chat
    @Value("${io.stream.api.secret}")
    private String streamVideoSecret;

    public String generateStreamToken(String userId) {
        // Convert string secret to SecretKey
        SecretKey key = Keys.hmacShaKeyFor(streamVideoSecret.getBytes());

        // Current time
        Instant now = Instant.now();

        // Create claims for Stream Video token
        Map<String, Object> claims = new HashMap<>();
        claims.put("user_id", userId);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(Date.from(now))
                .setExpiration(Date.from(now.plusSeconds(3600))) // 1 hour expiry
                .signWith(key)
                .compact();
    }
}