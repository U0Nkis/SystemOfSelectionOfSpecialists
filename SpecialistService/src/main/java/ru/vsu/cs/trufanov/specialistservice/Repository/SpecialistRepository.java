package ru.vsu.cs.trufanov.specialistservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vsu.cs.trufanov.specialistservice.Entity.Specialist;

import java.util.UUID;

public interface SpecialistRepository extends JpaRepository<Specialist, UUID> {
}
