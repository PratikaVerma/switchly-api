package live.switchly.api.service;

import live.switchly.api.exception.NotFoundException;
import live.switchly.api.model.Organisation;
import live.switchly.api.model.Project;
import live.switchly.api.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProjectService {

    private final OrganisationService organisationService;
    private final ProjectRepository projectRepository;

    public ProjectService(OrganisationService organisationService, ProjectRepository projectRepository) {
        this.organisationService = organisationService;
        this.projectRepository = projectRepository;
    }

    public Project create(UUID organisationId, String name) {
        Organisation organisation = organisationService.getById(organisationId);  // 404 if it doesn't exist
        Project project = new Project(UUID.randomUUID(), organisation.getId(), name);
        return projectRepository.save(project);
    }

    public Project getById(UUID id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Project " + id + " not found"));
    }

    public List<Project> getAllForOrganisation(UUID organisationId) {
        organisationService.getById(organisationId);  // 404 if it doesn't exist
        return projectRepository.findByOrganisationId(organisationId);
    }
}
