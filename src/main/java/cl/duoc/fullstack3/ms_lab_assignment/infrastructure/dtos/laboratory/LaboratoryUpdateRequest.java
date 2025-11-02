package cl.duoc.fullstack3.ms_lab_assignment.infrastructure.dtos.laboratory;

import cl.duoc.fullstack3.ms_lab_assignment.domain.entities.LaboratoryEntity;
import jakarta.validation.constraints.Min;

public record LaboratoryUpdateRequest(
        @Min(1)
        Long id,
        String name,
        String address
) {

    public LaboratoryEntity toEntity(){
        return LaboratoryEntity.builder()
                .id(this.id)
                .name(this.name)
                .address(this.address)
                .build();
    }

}
