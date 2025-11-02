package cl.duoc.fullstack3.ms_auth.infastructure.dtos.role;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record RoleUpdateRequest(
        @Min(1)
        @NotNull
        Long id,
        String name,
        String description
) {
}
