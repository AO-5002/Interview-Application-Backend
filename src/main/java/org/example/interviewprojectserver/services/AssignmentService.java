package org.example.interviewprojectserver.services;

import lombok.RequiredArgsConstructor;
import org.example.interviewprojectserver.dtos.AssignmentCreateDto;
import org.example.interviewprojectserver.entities.Assignment;
import org.example.interviewprojectserver.entities.User;
import org.example.interviewprojectserver.exceptions.user_errors.UserNotFoundException;
import org.example.interviewprojectserver.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AssignmentService {

    private final UserRepository userRepository;

    // Helper functions

    public User getUserBasedOnAuth(String authToken) {
        return userRepository.findByAuth0_id(authToken)
                .orElseThrow(() -> new UserNotFoundException("User not found."));
    }

    // Services Methods

    public List<Assignment> returnAssignmentsBasedOnIds(List<UUID> assignmentIdArray){

        return null;
    }

    public void createAssignment(String authId, AssignmentCreateDto assignment){

        // 1) Check if the user exists and then return the user based on Auth id.

        User user = getUserBasedOnAuth(authId);

        // 2) Associate the assignment with the user.



        // 3) Save the assignment to the db.


    }


}
