package cl.duoc.fullstack3.ms_lab_assignment.infrastructure.rest.dtos.analysis;

import cl.duoc.fullstack3.ms_lab_assignment.domain.models.entities.AnalysisEntity;
import jakarta.validation.constraints.Size;

public record AnalysisCreateRequest(
        @Size(max = 60)
        String name,
        @Size(max = 200)
        String description
) {
    public AnalysisEntity toEntity(){
        return AnalysisEntity.builder()
                .name(this.name)
                .description(this.description)
                .build();
    }
}
