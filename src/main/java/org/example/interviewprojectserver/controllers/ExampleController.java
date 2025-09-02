package org.example.interviewprojectserver.controllers;

import lombok.RequiredArgsConstructor;
import org.example.interviewprojectserver.services.ExampleService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/example")
@CrossOrigin(
        origins = "http://localhost:3000",
        allowedHeaders = "*",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS}
)
public class ExampleController {

    private final ExampleService exampleService;

//    @PostMapping
//    private ResponseEntity<>


}
