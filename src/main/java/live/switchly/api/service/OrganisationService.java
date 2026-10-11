package live.switchly.api.service;

import live.switchly.api.exception.NotFoundException;
import live.switchly.api.model.Organisation;
import live.switchly.api.repository.OrganisationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrganisationService {

    private final OrganisationRepository organisationRepository;

    public OrganisationService(OrganisationRepository organisationRepository) {
        this.organisationRepository = organisationRepository;
    }

    public Organisation create(String name) {
        Organisation organisation = new Organisation(UUID.randomUUID(), name);
        return organisationRepository.save(organisation);
    }

    public Organisation getById(UUID id) {
        return organisationRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Organisation " + id + " not found"));
    }

    public List<Organisation> getAll() {
        return organisationRepository.findAll();
    }
}