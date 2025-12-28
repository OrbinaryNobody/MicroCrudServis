package com.adapstory.course.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "track", schema = "course")
@Getter
@Setter
public class Track {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "track_constructor_id")
    private TrackConstructor trackConstructor;

    @Column(nullable = false)
    private String title;

    @Column(name = "full_text", columnDefinition = "TEXT", nullable = false)
    private String fullText;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
