package cl.duoc.fullstack3.ms_auth.infastructure.dtos.role;

import cl.duoc.fullstack3.ms_auth.domain.entities.RoleEntity;

public record RoleResponse(
        Long id,
        String name,
        String description
) {

    public static RoleResponse fromEntity(RoleEntity entity){
        return new RoleResponse(
                entity.getId(),
                entity.getName(),
                entity.getDescription()
        );
    }
}
