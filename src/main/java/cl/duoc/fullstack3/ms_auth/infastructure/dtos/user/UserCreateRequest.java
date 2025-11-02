package cl.duoc.fullstack3.ms_auth.infastructure.dtos.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

public record UserCreateRequest(
        @NotBlank
        String username,
        @NotBlank
        @Size(min = 5, max = 15)
        String password,
        List<Long>rolesId
) {
}
