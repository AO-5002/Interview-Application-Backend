package org.example.interviewprojectserver.repositories;

import org.example.interviewprojectserver.entities.Interview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InterviewRepository extends JpaRepository<Interview, UUID> {
}
