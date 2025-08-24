package org.example.interviewprojectserver.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "interviews")
public class Interview {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(
            name = "title",
            nullable = false
    )
    private String title;
    @Column(
            name = "description"
    )
    private String description;

    // Multiple interviews can reference multiple assignments
    @ManyToMany
    @JoinTable(
            name = "interview_assignments",
            joinColumns = @JoinColumn(name = "interview_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "assignment_id", referencedColumnName = "id")
    )
    private List<Assignment> assignments;

    @ManyToOne
    @JoinColumn(name = "candidate_user")
    private User candidate_user;

    @ManyToOne
    @JoinColumn(name = "recruiter_user")
    private User recruiter_user;
}
