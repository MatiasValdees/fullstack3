package cl.duoc.fullstack3.ms_lab_assignment.infrastructure.dtos.assignment;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record AssignmentUpdateRequest(
        @Min(1)
        @NotNull
        Long id,
        @Min(1)
        @NotNull
        Integer statusId
) {
}
