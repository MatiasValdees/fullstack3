package cl.duoc.fullstack3.ms_lab_assignment.infrastructure.dtos.patient;

import cl.duoc.fullstack3.ms_lab_assignment.domain.entities.PatientEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record PatientResponse(
        Long id,
        String fullName,
        String rut,
        @JsonFormat(pattern = "dd-MM-yyyy")
        LocalDate birthDate
) {

    public static PatientResponse fromEntity(PatientEntity entity){
        return new PatientResponse(
                entity.getId(),
                entity.getFullName(),
                entity.getRut(),
                entity.getBirthDate()
        );
    }
}
