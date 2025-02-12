package ru.vsu.cs.trufanov.registrationservice.Service;

import ru.vsu.cs.trufanov.registrationservice.DTO.RegistrationRequest;
import ru.vsu.cs.trufanov.registrationservice.Entity.Registration;
import ru.vsu.cs.trufanov.registrationservice.Repository.RegistrationRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RegistrationService {
    private final RegistrationRepository registrationRepository;
    private final RestTemplate restTemplate;

    public RegistrationService(RegistrationRepository registrationRepository, RestTemplate restTemplate) {
        this.registrationRepository = registrationRepository;
        this.restTemplate = restTemplate;
    }

    public Optional<Registration> createRegistration(RegistrationRequest request) {
        boolean clientExists = restTemplate.getForObject("http://client-service:8081/api/clients/" + request.clientId(), String.class) != null;

        boolean specialistExists = restTemplate.getForObject("http://specialist-service:8082/api/specialists/" + request.specialistId(), String.class) != null;

        boolean serviceExists = restTemplate.getForObject("http://specialist-service:8082/api/services/" + request.serviceId(), String.class) != null;

        if (clientExists && specialistExists && serviceExists) {
            Registration registration = new Registration();
            registration.setClientId(request.clientId());
            registration.setSpecialistId(request.specialistId());
            registration.setServiceId(request.serviceId());
            registration.setRegistrationDate(java.time.Instant.now());
            return Optional.of(registrationRepository.save(registration));
        }

        return Optional.empty();
    }

    public List<Registration> getAllRegistrations() {
        return registrationRepository.findAll();
    }

    public Optional<Registration> getRegistrationById(UUID id) {
        return registrationRepository.findById(id);
    }

    public void deleteRegistration(UUID id) {
        registrationRepository.deleteById(id);
    }
}
