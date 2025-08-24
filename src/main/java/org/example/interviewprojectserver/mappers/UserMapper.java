package org.example.interviewprojectserver.mappers;

import org.example.interviewprojectserver.dtos.UserDto;
import org.example.interviewprojectserver.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto userToUserDto(User user);
    User userDtoToUser(UserDto userDto);

}
