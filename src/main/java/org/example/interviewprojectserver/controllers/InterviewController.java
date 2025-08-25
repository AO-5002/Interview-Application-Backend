package org.example.interviewprojectserver.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.interviewprojectserver.dtos.InterviewCreateDto;
import org.example.interviewprojectserver.services.InterviewService;
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
public class InterviewController {

    private final InterviewService interviewService;

    @PostMapping
    public ResponseEntity<Void> createInterview(@RequestBody @Valid InterviewCreateDto newInterview, Authentication authToken){

        // 1) Extract id auth from the auth token

        String auth_id = authToken.getName();

        // 2) Create the interview

        interviewService.createInterview(newInterview, auth_id);

        // 3) Return a 200 OK response, if the function was successful.

        return ResponseEntity.ok().build();
    }
}
