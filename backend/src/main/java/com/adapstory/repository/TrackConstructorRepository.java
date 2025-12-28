package com.adapstory.course.repository;

import com.adapstory.course.model.TrackConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TrackConstructorRepository extends JpaRepository<TrackConstructor, UUID> {
}
