package com.adapstory.course.service;

import com.adapstory.course.exception.NotFoundException;
import com.adapstory.course.model.TrackConstructor;
import com.adapstory.course.repository.TrackConstructorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TrackConstructorService {

    private final TrackConstructorRepository repository;

    public TrackConstructor create(TrackConstructor constructor) {
        return repository.save(constructor);
    }

    public TrackConstructor getById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new NotFoundException("TrackConstructor not found: " + id)
                );
    }

    public TrackConstructor update(UUID id, TrackConstructor updated) {
        TrackConstructor existing = getById(id);

        existing.setName(updated.getName());
        existing.setDescription(updated.getDescription());

        return repository.save(existing);
    }

    public void delete(UUID id) {
        TrackConstructor constructor = getById(id);
        repository.delete(constructor);
    }
}
