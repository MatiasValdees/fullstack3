package cl.duoc.fullstack3.ms_lab_assignment.infrastructure.rest.dtos.analysis;

import cl.duoc.fullstack3.ms_lab_assignment.domain.models.entities.AnalysisEntity;

public record AnalysisResponse(
        Long id,
        String name,
        String description

) {
    public static AnalysisResponse fromEntity (AnalysisEntity entity){
        return new AnalysisResponse(
                entity.getId(),
                entity.getName(),
                entity.getDescription()
        );
    }
}
