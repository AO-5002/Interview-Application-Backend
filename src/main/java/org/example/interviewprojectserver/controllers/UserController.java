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

    @PostMapping
    private ResponseEntity<UserDto> createUser(@RequestBody @Valid UserDto newUser, Authentication auth) {

        String auth_id = auth.getName();

        UserDto createdUser = userService.createUser(auth_id, newUser);
        return ResponseEntity.ok(createdUser);
    }

}
