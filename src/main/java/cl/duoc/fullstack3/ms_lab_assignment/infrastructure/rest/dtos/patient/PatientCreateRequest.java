package cl.duoc.fullstack3.ms_lab_assignment.infrastructure.rest.dtos.patient;

import cl.duoc.fullstack3.ms_lab_assignment.domain.models.entities.PatientEntity;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record PatientCreateRequest(
        @NotBlank
        @Max(60)
        String fullName,
        @NotBlank
        @Min(10)
        @Max(15)
        String rut,
        @NotNull
        LocalDate birthDate
) {

    public PatientEntity toEntity(){
        return PatientEntity.builder()
                .fullName(this.fullName)
                .rut(this.rut)
                .birthDate(this.birthDate)
                .build();
    }
}
