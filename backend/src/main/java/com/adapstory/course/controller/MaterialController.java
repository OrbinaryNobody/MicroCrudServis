package com.adapstory.course.controller;

import com.adapstory.course.model.Material;
import com.adapstory.course.service.MaterialService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/materials")
@RequiredArgsConstructor
public class MaterialController {

    private final MaterialService materialService;

    @PostMapping
    public Material create(@RequestBody Material material) {
        return materialService.create(material);
    }

    @GetMapping("/{id}")
    public Material getById(@PathVariable UUID id) {
        return materialService.getById(id);
    }

    @PutMapping("/{id}")
    public Material update(
            @PathVariable UUID id,
            @RequestBody Material material
    ) {
        return materialService.update(id, material);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        materialService.delete(id);
    }
}
