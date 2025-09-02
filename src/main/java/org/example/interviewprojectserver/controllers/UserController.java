package org.example.interviewprojectserver.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.example.interviewprojectserver.dtos.UserCreateDto;
import org.example.interviewprojectserver.dtos.UserDto;
import org.example.interviewprojectserver.entities.Interview;
import org.example.interviewprojectserver.entities.User;
import org.example.interviewprojectserver.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@CrossOrigin(
        origins = "http://localhost:3000",
        allowedHeaders = "*",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS}
)
public class UserController {

    private final UserService userService;

    @PostMapping
    private ResponseEntity<UserCreateDto> createUser(
            @RequestBody @Valid UserCreateDto newUser,
            Authentication authToken
    ) {

        // 1) Extract id auth from the auth token

        String auth_id = authToken.getName();

        // 2) Input the auth_token into the function as well as the other data fields.

        userService.createUser(newUser, auth_id);

        // 3) Return a 200 OK response, if the function was successful.

        return ResponseEntity.ok().build();
    }

    // Return your candidate interviews (YOU THE CANDIDATE).

    @GetMapping("/interviews")
    private ResponseEntity<List<Interview>> getCandidates(Authentication authToken){

        // 1) Extract id auth from the auth token

        String auth_id = authToken.getName();

        // 2) Return the interviews.

        List<Interview> interviews = userService.getInterviews(auth_id);

        // 3) Return Response

        return ResponseEntity.ok(interviews);
    }

    @GetMapping
    private ResponseEntity<UserDto> getUser(Authentication authToken){

        // 1) Extract id auth from the auth token

        String auth_id = authToken.getName();

        // 2) Return the user.

        UserDto returnedUser = userService.getUserDto(auth_id);

        // 3) Return response

        return ResponseEntity.ok(returnedUser);
    }
}
