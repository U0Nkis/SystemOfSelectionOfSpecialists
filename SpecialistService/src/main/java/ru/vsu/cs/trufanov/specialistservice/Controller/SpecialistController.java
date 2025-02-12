package ru.vsu.cs.trufanov.specialistservice.Controller;

import ru.vsu.cs.trufanov.specialistservice.DTO.SpecialistRequest;
import ru.vsu.cs.trufanov.specialistservice.Entity.Specialist;
import ru.vsu.cs.trufanov.specialistservice.Service.SpecialistService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/specialists")
public class SpecialistController {
    private final SpecialistService service;

    public SpecialistController(SpecialistService service) {
        this.service = service;
    }

    @GetMapping
    public List<Specialist> getAllSpecialists() {
        return service.getAllSpecialists();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Specialist> getSpecialistById(@PathVariable UUID id) {
        return service.getSpecialistById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Specialist> createSpecialist(@RequestBody SpecialistRequest request) {
        return ResponseEntity.ok(service.createSpecialist(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Specialist> updateSpecialist(@PathVariable UUID id, @RequestBody SpecialistRequest request) {
        return service.updateSpecialist(id, request)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSpecialist(@PathVariable UUID id) {
        service.deleteSpecialist(id);
        return ResponseEntity.noContent().build();
    }
}
