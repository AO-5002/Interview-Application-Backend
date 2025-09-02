package org.example.interviewprojectserver.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    private UUID id;

    @Column(
            name = "auth0_id",
            nullable = false,
            unique = true
    )
    private String auth0_id;

    @Column(
            name = "name",
            nullable = false
    )
    private String name;
    @Column(
            name = "email",
            nullable = false,
            unique = true
    )
    private String email;
    @Column(
            name = "role"
    )
    private UserRole role;

    @Column(
            name = "profile_url"
    )
    private String profile_url;

    @Column(
            name = "created_at",
            nullable = false
    )
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @CreationTimestamp
    private LocalDateTime created_at;
    @Column(
            name = "updated_at",
            nullable = false
    )
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @UpdateTimestamp
    private LocalDateTime updated_at;

    // A user can be a candidate of multiple interviews

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "candidate_user"
    )
    private List<Interview> candidate_interviews;

    // A user can be a recruiter of multiple interviews

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "recruiter_user"
    )
    private List<Interview> recruiter_interviews;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "assignment_user"
    )
    private List<Assignment> assignments;
}