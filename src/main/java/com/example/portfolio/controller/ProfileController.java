package com.example.portfolio.controller;

import com.example.portfolio.dto.ProfileDTO;
import com.example.portfolio.model.Profile;
import com.example.portfolio.repository.ProfileRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profiles")
public class ProfileController {

    private final ProfileRepository repository;

    public ProfileController(ProfileRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<Profile> create(
            @Valid @RequestBody ProfileDTO dto) {

        Profile profile = new Profile();
        profile.setName(dto.name());
        profile.setEmail(dto.email());
        profile.setBio(dto.bio());

        return ResponseEntity.ok(repository.save(profile));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profile> findById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
