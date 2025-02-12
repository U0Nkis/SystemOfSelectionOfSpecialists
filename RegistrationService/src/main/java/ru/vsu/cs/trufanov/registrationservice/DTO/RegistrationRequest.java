package ru.vsu.cs.trufanov.registrationservice.DTO;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record RegistrationRequest(
        @NotNull UUID clientId,
        @NotNull UUID specialistId,
        @NotNull UUID serviceId
) {}
