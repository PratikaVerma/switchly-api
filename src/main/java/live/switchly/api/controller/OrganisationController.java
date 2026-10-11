package live.switchly.api.controller;

import live.switchly.api.dto.CreateOrganisationRequest;
import live.switchly.api.model.Organisation;
import live.switchly.api.service.OrganisationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/orgs")
public class OrganisationController {

    private final OrganisationService organisationService;

    public OrganisationController(OrganisationService organisationService) {
        this.organisationService = organisationService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Organisation create(@Valid @RequestBody CreateOrganisationRequest request) {
        return organisationService.create(request.name());
    }

    @GetMapping
    public List<Organisation> getAll() {
        return organisationService.getAll();
    }

    @GetMapping("/{orgId}")
    public Organisation getById(@PathVariable UUID orgId) {
        return organisationService.getById(orgId);
    }
}