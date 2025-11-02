package cl.duoc.fullstack3.ms_lab_assignment.infrastructure.dtos.laboratory;


import cl.duoc.fullstack3.ms_lab_assignment.domain.entities.LaboratoryEntity;

public record LaboratoryResponse(
        Long id,
        String name,
        String address
) {

    public static LaboratoryResponse fromEntity(LaboratoryEntity entity){
        return new LaboratoryResponse(
                entity.getId(),
                entity.getName(),
                entity.getAddress()
        );
    }
}
