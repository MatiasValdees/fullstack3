package cl.duoc.fullstack3.ms_auth.infastructure.dtos.user;

import jakarta.validation.constraints.Min;

import java.util.List;

public record UserUpdateRequest(
        @Min(1)
        Long id,
        String username,
        String password,
        List<Long> rolesId
) {
}
