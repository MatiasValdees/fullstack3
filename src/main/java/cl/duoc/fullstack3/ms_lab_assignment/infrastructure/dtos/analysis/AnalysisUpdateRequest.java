package cl.duoc.fullstack3.ms_lab_assignment.infrastructure.dtos.analysis;

import cl.duoc.fullstack3.ms_lab_assignment.domain.entities.AnalysisEntity;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

public record AnalysisUpdateRequest(
        @Min(1)
        Long id,
        @Size(max = 60)
        String name,
        @Size(max = 200)
        String description
) {
    public AnalysisEntity toEntity(){
        return AnalysisEntity.builder()
                .id(this.id)
                .name(this.name)
                .description(this.description)
                .build();
    }
}
