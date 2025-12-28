package com.adapstory.course.service;

import com.adapstory.course.exception.NotFoundException;
import com.adapstory.course.model.Track;
import com.adapstory.course.repository.TrackRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class TrackService {

    private final TrackRepository repository;

    public TrackService(TrackRepository repository) {
        this.repository = repository;
    }

    public Track create(Track track) {
        track.setCreatedAt(LocalDateTime.now());
        track.setUpdatedAt(LocalDateTime.now());
        return repository.save(track);
    }

    public Track getById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Track not found: " + id));
    }

    public List<Track> getAll() {
        return repository.findAll();
    }

    public Track update(UUID id, Track track) {
        Track updated = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Track not found: " + id));

        updated.setTitle(track.getTitle());
        updated.setFullText(track.getFullText());
        updated.setUpdatedAt(LocalDateTime.now());

        return repository.save(updated);
    }

    public void delete(UUID id) {
        if (!repository.existsById(id)) {
            throw new NotFoundException("Track not found: " + id);
        }
        repository.deleteById(id);
    }
}
