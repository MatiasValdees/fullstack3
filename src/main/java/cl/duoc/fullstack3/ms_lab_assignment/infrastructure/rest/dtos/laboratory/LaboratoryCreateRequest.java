package cl.duoc.fullstack3.ms_lab_assignment.infrastructure.rest.dtos.laboratory;

import cl.duoc.fullstack3.ms_lab_assignment.domain.models.entities.LaboratoryEntity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record LaboratoryCreateRequest(
        @NotNull
        @Size(min = 2, max = 60)
        String name,
        @Size(min = 5,max = 80)
        String address
) {
    public LaboratoryEntity toEntity(){
        return LaboratoryEntity.builder()
                .name(this.name)
                .address(this.address)
                .build();
    }
}
