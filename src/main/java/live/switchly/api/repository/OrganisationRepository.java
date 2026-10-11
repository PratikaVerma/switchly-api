package live.switchly.api.repository;
import live.switchly.api.model.Organisation;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrganisationRepository {
    Organisation save(Organisation Organisation);
    Optional<Organisation> findById(UUID id);
    List<Organisation> findAll();
}
