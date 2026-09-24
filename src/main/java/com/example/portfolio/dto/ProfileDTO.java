package com.example.portfolio.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record ProfileDTO(
        @NotBlank String name,
        @NotBlank @Email String email,
        String bio
) {
}
