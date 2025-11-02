package cl.duoc.fullstack3.ms_lab_assignment.infrastructure.rest.dtos.assignment;

import jakarta.validation.constraints.Min;

public record AssignmentUpdateRequest(
        @Min(1)
        Long id,
        @Min(1)
        Integer statusId
) {
}
