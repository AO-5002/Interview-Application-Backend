package org.example.interviewprojectserver.services;

import lombok.RequiredArgsConstructor;
import org.example.interviewprojectserver.dtos.InterviewCreateDto;
import org.example.interviewprojectserver.entities.Assignment;
import org.example.interviewprojectserver.entities.Interview;
import org.example.interviewprojectserver.entities.User;
import org.example.interviewprojectserver.entities.UserRole;
import org.example.interviewprojectserver.exceptions.interview_errors.IncorrectRoleException;
import org.example.interviewprojectserver.exceptions.user_errors.UserNotFoundException;
import org.example.interviewprojectserver.mappers.InterviewMapper;
import org.example.interviewprojectserver.repositories.InterviewRepository;
import org.example.interviewprojectserver.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class InterviewService {

    private final InterviewRepository interviewRepository;
    private final UserRepository userRepository;
    private final AssignmentService assignmentService;
    private final InterviewMapper interviewMapper;

    // Helper functions

    public User getUserBasedOnAuth(String authToken) {
        return userRepository.findByAuth0_id(authToken)
                .orElseThrow(() -> new UserNotFoundException("User not found."));
    }

    // The main service methods below:

    public void createInterview(InterviewCreateDto newInterview, String authId){

        // 1) Check if the user exists via the auth token.

        User user = getUserBasedOnAuth(authId);

        // 2) If the user exists, extract the list of assignment id's, and create an Interview Object (EMPTY)

        String title = newInterview.getTitle();
        String description = newInterview.getDescription();
        List<String> assignmentIds = newInterview.getAssignmentListIds();

        // 3) Save the data into the Interview Object.

        Interview createdInterview = new Interview();
        createdInterview.setTitle(title);
        createdInterview.setDescription(description);

        // 4) Convert the assignment ids into a list of Assignment Objects, if any.

        // First, convert the list of Strings into a list of UUIDs.

        if(assignmentIds != null){
            List<UUID> assignmentIdsUUID = assignmentIds.stream().map(UUID::fromString).toList();
            List<Assignment> assignments = assignmentService.returnAssignmentsBasedOnIds(assignmentIdsUUID);
            createdInterview.setAssignments(assignments);
        }

        // 5) Set the interview's candidate and recruiter within the Interview Object

        UserRole role = user.getRole();

        if(role == UserRole.CANDIDATE){
            createdInterview.setCandidate_user(user);
        }
        else if(role == UserRole.RECRUITER){
            createdInterview.setCandidate_user(user);
        }
        else{
            throw new IncorrectRoleException("User role is incorrect. (UNAUTHORIZED)");
        }

        // 6) Finally, save the Interview Object to the database.

        interviewRepository.save(createdInterview);
    }


}
