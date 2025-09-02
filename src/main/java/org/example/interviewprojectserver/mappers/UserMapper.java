package org.example.interviewprojectserver.mappers;

import org.example.interviewprojectserver.dtos.UserCreateDto;
import org.example.interviewprojectserver.dtos.UserDto;
import org.example.interviewprojectserver.entities.User;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface UserMapper {
    UserCreateDto userToUserCreateDto(User userObject);
    User userCreateDtoToUser(UserCreateDto userCreateDtoObject);
    User userDtoToUser(UserDto userDtoObject);
    UserDto userToUserDto(User userObject);
}
