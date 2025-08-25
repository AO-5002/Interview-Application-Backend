package org.example.interviewprojectserver.services;

import lombok.RequiredArgsConstructor;
import org.example.interviewprojectserver.dtos.UserCreateDto;
import org.example.interviewprojectserver.entities.Interview;
import org.example.interviewprojectserver.entities.User;
import org.example.interviewprojectserver.entities.UserRole;
import org.example.interviewprojectserver.exceptions.interview_errors.IncorrectRoleException;
import org.example.interviewprojectserver.exceptions.interview_errors.NoInterviewsFoundException;
import org.example.interviewprojectserver.exceptions.user_errors.UserAlreadyExistsException;
import org.example.interviewprojectserver.exceptions.user_errors.UserNotFoundException;
import org.example.interviewprojectserver.mappers.UserMapper;
import org.example.interviewprojectserver.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    // Helper functions

    // This method will either throw an exception or return the user if found based on Auth token.

    public User getUserBasedOnAuth(String authToken) {
        return userRepository.findByAuth0_id(authToken)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    // Main service methods

    public void createUser(
            UserCreateDto newUser,
            String authId
    ){

        // 1) Check if the user already exists

        if(userRepository.existsByAuth0_id(authId)){
            throw new UserAlreadyExistsException("User with auth0 id " + authId + " already exists");
        }

        // 2) Create the user AND set the auth id to the newly created user.

        User createdUser = userMapper.userDtoToUser(newUser);
        createdUser.setAuth0_id(authId);

        // 3) Save to the db

        userRepository.save(createdUser);
    }

    // This works for either candidate or recruiter.
    public List<Interview> getInterviews(String authId){

        // 1) Return user based on Auth id.

        User user = getUserBasedOnAuth(authId);

        // 2) Check if the user is either a candidate or recruiter and check if they have any interviews.

        UserRole role = user.getRole();

        // 3) Finally, return the interviews.

        if(role == UserRole.RECRUITER){
            if(user.getRecruiter_interviews().isEmpty()){
                throw new NoInterviewsFoundException("User has no interviews");
            }
            return user.getRecruiter_interviews();
        }
        else if(role == UserRole.CANDIDATE){
            if(user.getCandidate_interviews().isEmpty()){
                throw new NoInterviewsFoundException("User has no interviews");
            }

            return user.getCandidate_interviews();
        }
        else{
            throw new IncorrectRoleException("User role is incorrect. (UNAUTHORIZED)");
        }
    }

}
