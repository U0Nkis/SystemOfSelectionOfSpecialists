package ru.vsu.cs.trufanov.specialistservice.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record ServiceRequest(
        @NotBlank @Size(max = 255) String serviceName,
        @NotBlank @Positive BigDecimal price
) {}
