package cl.duoc.fullstack3.ms_auth.infastructure.dtos.user;

import cl.duoc.fullstack3.ms_auth.domain.entities.RoleEntity;
import cl.duoc.fullstack3.ms_auth.domain.entities.UserEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.List;

public record UserResponse(
        Long id,
        String username,
        List<String> roles,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
        LocalDateTime createdAt,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
        LocalDateTime updatedAt
) {
    public static UserResponse fromEntity (UserEntity entity){
        return new UserResponse(
                entity.getId(),
                entity.getUsername(),
                entity.getRoles().stream().map(RoleEntity::getName).toList(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
