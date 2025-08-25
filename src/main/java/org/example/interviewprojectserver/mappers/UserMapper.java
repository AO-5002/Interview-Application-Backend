package org.example.interviewprojectserver.mappers;

import org.example.interviewprojectserver.dtos.UserCreateDto;
import org.example.interviewprojectserver.entities.User;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface UserMapper {
    UserCreateDto userToUserDto(User userObject);
    User userDtoToUser(UserCreateDto userCreateDtoObject);
}
