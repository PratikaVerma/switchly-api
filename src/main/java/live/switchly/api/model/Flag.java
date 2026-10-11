package live.switchly.api.model;

import java.util.UUID;

public class Flag {

    private final UUID id;
    private final UUID organisationId;
    private final UUID projectId;
    private final String key;
    private final String name;
    private boolean enabled;

    public Flag(UUID id, UUID organisationId, UUID projectId, String key, String name, boolean enabled) {
        this.id = id;
        this.organisationId = organisationId;
        this.projectId = projectId;
        this.key = key;
        this.name = name;
        this.enabled = enabled;
    }

    public UUID getId() { return id; }
    public UUID getOrganisationId() { return organisationId; }
    public UUID getProjectId() { return projectId; }
    public String getKey() { return key; }
    public String getName() { return name; }
    public boolean isEnabled() { return enabled; }

    public void setEnabled(boolean enabled) { this.enabled = enabled; }
}
