package cl.duoc.fullstack3.ms_lab_assignment.infrastructure.dtos.patient;

import cl.duoc.fullstack3.ms_lab_assignment.domain.entities.PatientEntity;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record PatientCreateRequest(
        @NotBlank
        @Size(min = 2,max = 60)
        String fullName,
        @NotBlank
        @Pattern(regexp = "\\d{7,8}-[0-9kK]", message = "El RUT debe tener 7 u 8 dígitos, guion y dígito verificador")
        String rut,
        @NotNull
        LocalDate birthDate
) {

    public PatientEntity toEntity(){
        return PatientEntity.builder()
                .fullName(this.fullName.toUpperCase())
                .rut(this.rut.toUpperCase())
                .birthDate(this.birthDate)
                .build();
    }
}
