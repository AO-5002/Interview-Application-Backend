package org.example.interviewprojectserver.services;

import lombok.RequiredArgsConstructor;
import org.example.interviewprojectserver.entities.Assignment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AssignmentService {

    public List<Assignment> returnAssignmentsBasedOnIds(List<UUID> assignmentIdArray){

        return null;
    }

}
