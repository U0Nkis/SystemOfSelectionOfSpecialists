package ru.vsu.cs.trufanov.specialistservice.Service;

import org.springframework.stereotype.Service;
import ru.vsu.cs.trufanov.specialistservice.DTO.SpecialistRequest;
import ru.vsu.cs.trufanov.specialistservice.Entity.Specialist;
import ru.vsu.cs.trufanov.specialistservice.Repository.SpecialistRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SpecialistService {
    private final SpecialistRepository repository;

    public SpecialistService(SpecialistRepository repository) {
        this.repository = repository;
    }

    public List<Specialist> getAllSpecialists() {
        return repository.findAll();
    }

    public Optional<Specialist> getSpecialistById(UUID id) {
        return repository.findById(id);
    }

    public Specialist createSpecialist(SpecialistRequest request) {
        Specialist specialist = Specialist.builder()
                .fullName(request.fullName())
                .email(request.email())
                .phone(request.phone())
                .city(request.city())
                .build();
        return repository.save(specialist);
    }

    public Optional<Specialist> updateSpecialist(UUID id, SpecialistRequest request) {
        return repository.findById(id).map(specialist -> {
            specialist.setFullName(request.fullName());
            specialist.setEmail(request.email());
            specialist.setPhone(request.phone());
            specialist.setCity(request.city());
            return repository.save(specialist);
        });
    }

    public void deleteSpecialist(UUID id) {
        repository.deleteById(id);
    }
}
