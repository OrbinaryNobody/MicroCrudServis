package com.adapstory.course.controller;

import com.adapstory.course.model.TrackConstructor;
import com.adapstory.course.service.TrackConstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/constructors")
@RequiredArgsConstructor
public class TrackConstructorController {

    private final TrackConstructorService constructorService;

    @PostMapping
    public TrackConstructor create(@RequestBody TrackConstructor constructor) {
        return constructorService.create(constructor);
    }

    @GetMapping("/{id}")
    public TrackConstructor getById(@PathVariable UUID id) {
        return constructorService.getById(id);
    }

    @PutMapping("/{id}")
    public TrackConstructor update(
            @PathVariable UUID id,
            @RequestBody TrackConstructor constructor
    ) {
        return constructorService.update(id, constructor);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        constructorService.delete(id);
    }
}
