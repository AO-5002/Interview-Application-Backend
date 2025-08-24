package org.example.interviewprojectserver.repositories;

import org.example.interviewprojectserver.entities.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ExampleRepository extends JpaRepository<Example, UUID> {
}
