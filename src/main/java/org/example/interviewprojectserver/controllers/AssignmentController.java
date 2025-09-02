package org.example.interviewprojectserver.controllers;

import lombok.RequiredArgsConstructor;
import org.example.interviewprojectserver.dtos.AssignmentCreateDto;
import org.example.interviewprojectserver.services.AssignmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/assignment")
@CrossOrigin(
        origins = "http://localhost:3000",
        allowedHeaders = "*",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS}
)
public class AssignmentController {

    private AssignmentService assignmentService;

    private ResponseEntity<Void> createAssignment(Authentication auth, AssignmentCreateDto assignment){

        // 1) Extract id auth from the auth token

        String auth_id = auth.getName();

        // 2) Input the auth_token into the function as well as the other data fields.
        assignmentService.createAssignment(auth_id, assignment);

        // 3) Return ok if no errors

        return ResponseEntity.ok().build();
    }
}
