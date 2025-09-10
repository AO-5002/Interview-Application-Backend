package org.example.interviewprojectserver.services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class StreamTokenService {

    @Value("${io.stream.api.secret}")
    private String streamVideoSecret;
    public String generateStreamToken(String userId) {
        System.out.println("=== TOKEN DEBUG ===");
        System.out.println("User ID: " + userId);
        System.out.println("Secret (first 20 chars): " + streamVideoSecret.substring(0, Math.min(20, streamVideoSecret.length())) + "...");

        // Try base64 decoding the secret (some Stream secrets are base64 encoded)
        SecretKey key;
        try {
            byte[] decodedSecret = Base64.getDecoder().decode(streamVideoSecret);
            key = Keys.hmacShaKeyFor(decodedSecret);
            System.out.println("Using base64 decoded secret");
        } catch (Exception e) {
            // If base64 decode fails, use the raw secret
            key = Keys.hmacShaKeyFor(streamVideoSecret.getBytes());
            System.out.println("Using raw secret");
        }

        Instant now = Instant.now();

        Map<String, Object> claims = new HashMap<>();
        claims.put("user_id", userId);

        String token = Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(Date.from(now))
                .setExpiration(Date.from(now.plusSeconds(3600)))
                .signWith(key, SignatureAlgorithm.HS256)  // Force HS256 algorithm
                .compact();

        System.out.println("Generated token: " + token.substring(0, 50) + "...");
        return token;
    }
}