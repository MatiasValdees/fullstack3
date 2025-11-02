package cl.duoc.fullstack3.ms_lab_assignment.infrastructure.dtos.patient;

import cl.duoc.fullstack3.ms_lab_assignment.domain.entities.PatientEntity;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record PatientUpdateRequest(
        @Min(1)
        @NotNull
        Long id,
        String fullName,
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
