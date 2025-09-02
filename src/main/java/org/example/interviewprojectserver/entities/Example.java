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
            name = "explanation",
            nullable = false
    )
    private String explanation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assignment_examples")
    private Assignment assignment_examples;
}
