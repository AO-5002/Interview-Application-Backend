package org.example.interviewprojectserver.services;

import lombok.RequiredArgsConstructor;
import org.example.interviewprojectserver.dtos.UserDto;
import org.example.interviewprojectserver.entities.User;
import org.example.interviewprojectserver.exceptions.user_errors.UserAlreadyExistsException;
import org.example.interviewprojectserver.mappers.UserMapper;
import org.example.interviewprojectserver.repositories.UserRepository;
import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.util.Arrays;
//import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    // Helper functions

//    private boolean isValidFile(MultipartFile file) {
//        if (file == null || file.isEmpty()) {
//            return false;
//        }
//
//        // Check file extension
//        String filename = file.getOriginalFilename();
//        if (filename == null) {
//            return false;
//        }
//
//        String extension = filename.substring(filename.lastIndexOf(".") + 1).toLowerCase();
//        List<String> allowedExtensions = Arrays.asList("txt", "pdf", "doc", "docx");
//
//        if (!allowedExtensions.contains(extension)) {
//            return false;
//        }
//
//        // Check file size (e.g., max 5MB)
//        return file.getSize() <= 5 * 1024 * 1024;
//
//        // Add any other validation rules you need
//    }

    public void createUser(
            UserDto newUser,
            String authId
    ){

        // 1) Check if the user already exists

        if(userRepository.existsByAuth0_id(authId)){
            throw new UserAlreadyExistsException("User with auth0 id " + authId + " already exists");
        }

        // 2) Create the user & set the auth id

        User createdUser = userMapper.userDtoToUser(newUser);
        createdUser.setAuth0_id(authId);

        // 3) Save to the db

        userRepository.save(createdUser);
    }



}
