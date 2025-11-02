package cl.duoc.fullstack3.ms_lab_assignment.infrastructure.rest.dtos.assignment;

import cl.duoc.fullstack3.ms_lab_assignment.infrastructure.rest.dtos.laboratory.LaboratoryResponse;
import cl.duoc.fullstack3.ms_lab_assignment.infrastructure.rest.dtos.patient.PatientResponse;
import cl.duoc.fullstack3.ms_lab_assignment.domain.models.entities.AssignmentEntity;

public record AssignmentResponse(
        Long id,
        PatientResponse patient,
        LaboratoryResponse laboratory,
        String status
) {

    public static AssignmentResponse fromEntity(AssignmentEntity entity){
        return new AssignmentResponse(
                entity.getId(),
                PatientResponse.fromEntity(entity.getPatient()),
                LaboratoryResponse.fromEntity(entity.getLaboratory()),
                entity.getStatus().getDescription()
        );
    }
}
