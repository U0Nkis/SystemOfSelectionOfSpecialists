package ru.vsu.cs.trufanov.registrationservice.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "registrations")
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @ColumnDefault("gen_random_uuid()")
    @Column(name = "id", nullable = false)
    private UUID id;

    @NotNull
    @Column(name = "client_id", nullable = false)
    private UUID clientId;

    @NotNull
    @Column(name = "specialist_id", nullable = false)
    private UUID specialistId;

    @NotNull
    @Column(name = "service_id", nullable = false)
    private UUID serviceId;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "registration_date")
    private Instant registrationDate;
}