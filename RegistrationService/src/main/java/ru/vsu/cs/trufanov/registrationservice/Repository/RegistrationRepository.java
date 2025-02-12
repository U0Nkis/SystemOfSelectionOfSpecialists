package ru.vsu.cs.trufanov.registrationservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vsu.cs.trufanov.registrationservice.Entity.Registration;

import java.util.UUID;

public interface RegistrationRepository extends JpaRepository<Registration, UUID> {
}
