package org.example.interviewprojectserver.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "assignments")
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(
            name = "id",
            nullable = false,
            unique = true
    )
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

    @ManyToMany(mappedBy = "assignments")
    private List<Interview> interviews;

}
