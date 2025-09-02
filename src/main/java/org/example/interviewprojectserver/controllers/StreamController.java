package org.example.interviewprojectserver.controllers;

import lombok.RequiredArgsConstructor;
import org.example.interviewprojectserver.services.StreamTokenService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/interview")
@CrossOrigin(
        origins = "http://localhost:3000",
        allowedHeaders = "*",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS}
)
public class StreamController {

    private final StreamTokenService streamTokenService;

    @GetMapping("/token")
    public ResponseEntity<String> getStreamToken(Authentication authToken){
        String authId = authToken.getName();
        String token = streamTokenService.generateStreamToken(authId);
        return ResponseEntity.ok(token);
    }


}
