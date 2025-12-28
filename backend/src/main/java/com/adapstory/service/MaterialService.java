package com.adapstory.course.service;

import com.adapstory.course.exception.NotFoundException;
import com.adapstory.course.model.Material;
import com.adapstory.course.repository.MaterialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MaterialService {

    private final MaterialRepository materialRepository;

    public Material create(Material material) {
        return materialRepository.save(material);
    }

    public Material getById(UUID id) {
        return materialRepository.findById(id)
                .orElseThrow(() ->
                        new NotFoundException("Material not found: " + id)
                );
    }

    public Material update(UUID id, Material updated) {
        Material existing = getById(id);

        existing.setTitle(updated.getTitle());
        existing.setContent(updated.getContent());

        return materialRepository.save(existing);
    }

    public void delete(UUID id) {
        Material material = getById(id);
        materialRepository.delete(material);
    }
}
