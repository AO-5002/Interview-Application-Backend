package org.example.interviewprojectserver.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.example.interviewprojectserver.entities.Assignment;

import java.util.List;
import java.util.UUID;

@Data
public class InterviewCreateDto {

    @NotNull(message = "Title cannot be null.")
    private String title;
    @Size(max = 255, message = "Description must be at most 255 characters.")
    private String description;
    // This will be the OPTIONAL array list of assignment ids.
    private List<String> assignmentListIds;
}
