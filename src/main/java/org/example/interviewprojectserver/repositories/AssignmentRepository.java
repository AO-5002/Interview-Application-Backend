package org.example.interviewprojectserver.repositories;

import org.example.interviewprojectserver.entities.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AssignmentRepository extends JpaRepository<Assignment, UUID> {
}
