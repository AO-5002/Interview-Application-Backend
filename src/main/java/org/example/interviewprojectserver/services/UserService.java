package org.example.interviewprojectserver.services;

import lombok.RequiredArgsConstructor;
import org.example.interviewprojectserver.dtos.UserDto;
import org.example.interviewprojectserver.mappers.UserMapper;
import org.example.interviewprojectserver.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public UserDto createUser(String authId, UserDto newUser){

        return null;
    }






}
