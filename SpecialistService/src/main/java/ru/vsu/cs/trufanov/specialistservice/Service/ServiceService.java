package ru.vsu.cs.trufanov.specialistservice.Service;

import ru.vsu.cs.trufanov.specialistservice.DTO.ServiceRequest;
import ru.vsu.cs.trufanov.specialistservice.Entity.Service;
import ru.vsu.cs.trufanov.specialistservice.Repository.ServiceRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@org.springframework.stereotype.Service
public class ServiceService {
    private final ServiceRepository serviceRepository;

    public ServiceService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public List<Service> getAllServices() {
        return serviceRepository.findAll();
    }

    public Optional<Service> createService(ServiceRequest request, UUID specialistId) {
        Service service = new Service();
        service.setSpecialistId(specialistId);
        service.setServiceName(request.serviceName());
        service.setPrice(request.price());
        return Optional.of(serviceRepository.save(service));
    }

    public Optional<Service> updateService(UUID serviceId, ServiceRequest request) {
        return serviceRepository.findById(serviceId).map(service -> {
            service.setServiceName(request.serviceName());
            service.setPrice(request.price());
            return serviceRepository.save(service);
        });
    }

    public Optional<Service> getServiceById(UUID serviceId) {
        return serviceRepository.findById(serviceId);
    }

    public void deleteService(UUID serviceId) {
        serviceRepository.deleteById(serviceId);
    }
}
