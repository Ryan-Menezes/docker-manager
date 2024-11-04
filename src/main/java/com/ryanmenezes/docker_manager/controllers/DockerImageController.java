package com.ryanmenezes.docker_manager.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.dockerjava.api.model.Image;
import com.ryanmenezes.docker_manager.services.DockerService;

@RestController
@RequestMapping("/api/images")
public class DockerImageController {
    private final DockerService dockerService;

    public DockerImageController(DockerService dockerService) {
        this.dockerService = dockerService;
    }

    @GetMapping
    public List<Image> listImages() {
        return dockerService.listImages();
    }

    @GetMapping("/filter")
    public List<Image> listImages(@RequestParam(required = false, defaultValue="image-") String name) {
        return dockerService.filterImages(name);
    }
}
