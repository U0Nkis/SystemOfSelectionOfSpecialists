package ru.vsu.cs.trufanov.clientservice.Controller;

import ru.vsu.cs.trufanov.clientservice.DTO.ClientRequest;
import ru.vsu.cs.trufanov.clientservice.Entity.Client;
import ru.vsu.cs.trufanov.clientservice.Service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = {"http://127.0.0.1:8081", "http://localhost:8081"})
@RestController
@RequestMapping("/api/clients")
public class ClientRestController {
    private final ClientService service;

    public ClientRestController(ClientService service) {
        this.service = service;
    }

    @GetMapping
    public List<Client> getAllClients() {
        return service.getAllClients();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable UUID id) {
        return service.getClientById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody ClientRequest request) {
        return ResponseEntity.ok(service.createClient(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable UUID id, @RequestBody ClientRequest request) {
        return service.updateClient(id, request)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable UUID id) {
        service.deleteClient(id);
        return ResponseEntity.noContent().build();
    }
}
