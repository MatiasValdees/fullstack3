package cl.duoc.fullstack3.ms_lab_assignment.infrastructure.dtos.assignment;

import jakarta.validation.constraints.Min;

public record AssignmentCreateRequest(
        @Min(1)
        Long patientId,
        @Min(1)
        Long LaboratoryId,
        @Min(1)
        Long analysisId
) {

}
