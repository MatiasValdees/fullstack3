package cl.duoc.fullstack3.ms_auth.infastructure.dtos.role;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RoleCreateRequest(
        @NotBlank
        @Size(min = 3,max = 20)
        String name,
        @NotBlank
        @Size(min = 5,max = 200)
        String description
) {
}
