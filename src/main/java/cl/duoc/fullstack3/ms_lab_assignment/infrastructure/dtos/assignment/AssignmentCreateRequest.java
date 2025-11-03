package cl.duoc.fullstack3.ms_lab_assignment.infrastructure.dtos.assignment;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record AssignmentCreateRequest(
        @Min(1)
        @NotNull
        Long patientId,
        @Min(1)
        @NotNull
        Long laboratoryId,
        @Min(1)
        @NotNull
        Long analysisId
) {

}
