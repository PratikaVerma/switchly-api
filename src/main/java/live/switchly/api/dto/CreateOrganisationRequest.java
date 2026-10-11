package live.switchly.api.dto;
import jakarta.validation.constraints.NotBlank;

public record CreateOrganisationRequest(@NotBlank String name){}

