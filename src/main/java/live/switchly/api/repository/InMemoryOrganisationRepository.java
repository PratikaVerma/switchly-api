package live.switchly.api.repository;

import live.switchly.api.model.Organisation;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryOrganisationRepository implements OrganisationRepository {

    private final Map<UUID, Organisation> store = new ConcurrentHashMap<>();

    @Override
    public Organisation save(Organisation organisation) {
        store.put(organisation.getId(), organisation);
        return organisation;
    }

    @Override
    public Optional<Organisation> findById(UUID id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<Organisation> findAll() {
        return new ArrayList<>(store.values());
    }
}