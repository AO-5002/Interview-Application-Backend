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

        // 1) Extract id auth from the auth token

        String authId = authToken.getName();

        // 2) Return the stream token.

        String cleanUserId = authId.replaceAll("[^a-zA-Z0-9@_-]", "_");


        String token = streamTokenService.generateStreamToken(authId);

        // 3) Return response

        return ResponseEntity.ok(token);
    }

}
