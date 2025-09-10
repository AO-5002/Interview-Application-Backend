package org.example.interviewprojectserver.controllers;

import lombok.RequiredArgsConstructor;
import org.example.interviewprojectserver.services.StreamTokenService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stream")
@CrossOrigin(
        origins = "http://localhost:3000",
        allowedHeaders = "*",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS}
)
public class StreamController {

    private final StreamTokenService streamTokenService;

    @GetMapping("/token")
    private ResponseEntity<String> getStreamToken(Authentication authToken){
        String authId = authToken.getName();
        String cleanUserId = authId.replaceAll("[^a-zA-Z0-9@_-]", "_");
        String token = streamTokenService.generateStreamToken(cleanUserId); // ← Use cleanUserId
        return ResponseEntity.ok(token);
    }

}
