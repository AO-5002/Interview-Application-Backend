package org.example.interviewprojectserver.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.interviewprojectserver.dtos.UserDto;
import org.example.interviewprojectserver.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
@CrossOrigin(
        origins = "http://localhost:3000",
        allowedHeaders = "*",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS}
)
public class UserController {

    private final UserService userService;

    @GetMapping
    private String checkAuth(){
        return "Only Authenticated users can access this endpoint";
    }

    @PostMapping
    private ResponseEntity<UserDto> createUser(
            @RequestBody @Valid UserDto newUser,
            Authentication authToken
    ) {

        // 1) Extract id auth from the auth token

        String auth_id = authToken.getName();

        // 2) Input the auth_token into the function as well as the other data fields.

        userService.createUser(newUser, auth_id);

        // 3) Return a 200 OK response, if the function was successful.

        return ResponseEntity.ok().build();
    }
}
