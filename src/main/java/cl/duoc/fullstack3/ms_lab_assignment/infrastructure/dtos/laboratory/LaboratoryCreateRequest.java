package cl.duoc.fullstack3.ms_lab_assignment.infrastructure.dtos.laboratory;

import cl.duoc.fullstack3.ms_lab_assignment.domain.entities.LaboratoryEntity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record LaboratoryCreateRequest(
        @NotNull
        @Size(min = 2, max = 60)
        String name,
        @NotNull
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
