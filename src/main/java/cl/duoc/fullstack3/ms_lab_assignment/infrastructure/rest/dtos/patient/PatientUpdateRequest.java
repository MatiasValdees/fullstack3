package cl.duoc.fullstack3.ms_lab_assignment.infrastructure.rest.dtos.patient;

import cl.duoc.fullstack3.ms_lab_assignment.domain.models.entities.PatientEntity;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record PatientUpdateRequest(
        @Min(1)
        @NotNull
        Long id,
        @NotBlank
        @Max(60)
        String fullName,
        @NotBlank
        @Size(min = 10, max = 15)
        String rut,
        LocalDate birthDate
) {
    public PatientEntity toEntity(){
        return PatientEntity.builder()
                .id(this.id)
                .fullName(this.fullName)
                .rut(this.rut)
                .birthDate(this.birthDate)
                .build();
    }
}
