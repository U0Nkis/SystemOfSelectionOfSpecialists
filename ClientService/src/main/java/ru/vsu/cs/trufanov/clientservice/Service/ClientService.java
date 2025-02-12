package ru.vsu.cs.trufanov.clientservice.Service;

import ru.vsu.cs.trufanov.clientservice.DTO.ClientRequest;
import ru.vsu.cs.trufanov.clientservice.Entity.Client;
import ru.vsu.cs.trufanov.clientservice.Repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClientService {
    private final ClientRepository repository;

    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }

    public List<Client> getAllClients() {
        return repository.findAll();
    }

    public Optional<Client> getClientById(UUID id) {
        return repository.findById(id);
    }

    public Client createClient(ClientRequest request) {
        Client client = Client.builder()
                .fullName(request.fullName())
                .email(request.email())
                .phone(request.phone())
                .city(request.city())
                .build();
        return repository.save(client);
    }

    public Optional<Client> updateClient(UUID id, ClientRequest request) {
        return repository.findById(id).map(client -> {
            client.setFullName(request.fullName());
            client.setEmail(request.email());
            client.setPhone(request.phone());
            client.setCity(request.city());
            return repository.save(client);
        });
    }

    public void deleteClient(UUID id) {
        repository.deleteById(id);
    }
}
