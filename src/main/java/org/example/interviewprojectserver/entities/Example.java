package org.example.interviewprojectserver.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "examples")
public class Example {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(
            name = "input",
            nullable = false
    )
    private String input;
    @Column(
            name = "output",
            nullable = false
    )
    private String output;
    @Column(
            name = "explanation"
    )
    private String explanation;

    // Here, the examples will be distinguished by their associated interview id

    @Column(
            name = "interview_id",
            nullable = false
    )
    private UUID interview_id;
}
