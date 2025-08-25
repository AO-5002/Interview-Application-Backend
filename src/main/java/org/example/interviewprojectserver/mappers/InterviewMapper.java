package org.example.interviewprojectserver.mappers;

import org.example.interviewprojectserver.dtos.InterviewCreateDto;
import org.example.interviewprojectserver.entities.Interview;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InterviewMapper {
    InterviewCreateDto interviewToInterviewDto(InterviewCreateDto interviewObject);
    Interview interviewDtoToInterview(InterviewCreateDto interviewCreateDtoObject);
}
