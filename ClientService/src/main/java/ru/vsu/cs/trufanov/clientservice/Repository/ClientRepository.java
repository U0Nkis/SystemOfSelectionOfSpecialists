package ru.vsu.cs.trufanov.clientservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vsu.cs.trufanov.clientservice.Entity.Client;

import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, UUID> {
}
