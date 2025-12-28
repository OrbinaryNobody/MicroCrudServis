package com.adapstory.course.controller;

import com.adapstory.course.model.Track;
import com.adapstory.course.service.TrackService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/tracks")
@RequiredArgsConstructor
public class TrackController {

    private final TrackService trackService;

    @PostMapping
    public Track create(@RequestBody Track track) {
        return trackService.create(track);
    }

    @GetMapping("/{id}")
    public Track getById(@PathVariable UUID id) {
        return trackService.getById(id);
    }

    @PutMapping("/{id}")
    public Track update(
            @PathVariable UUID id,
            @RequestBody Track track
    ) {
        return trackService.update(id, track);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        trackService.delete(id);
    }
}
