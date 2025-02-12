package ru.vsu.cs.trufanov.specialistservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vsu.cs.trufanov.specialistservice.Entity.Service;

import java.util.UUID;

public interface ServiceRepository extends JpaRepository<Service, UUID> {
}
