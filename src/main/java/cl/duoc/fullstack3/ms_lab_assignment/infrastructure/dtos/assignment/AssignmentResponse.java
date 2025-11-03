package cl.duoc.fullstack3.ms_lab_assignment.infrastructure.dtos.assignment;

import cl.duoc.fullstack3.ms_lab_assignment.infrastructure.dtos.analysis.AnalysisResponse;
import cl.duoc.fullstack3.ms_lab_assignment.infrastructure.dtos.laboratory.LaboratoryResponse;
import cl.duoc.fullstack3.ms_lab_assignment.infrastructure.dtos.patient.PatientResponse;
import cl.duoc.fullstack3.ms_lab_assignment.domain.entities.AssignmentEntity;

public record AssignmentResponse(
        Long id,
        PatientResponse patient,
        LaboratoryResponse laboratory,
        AnalysisResponse analysis,
        String status
) {

    public static AssignmentResponse fromEntity(AssignmentEntity entity){
        return new AssignmentResponse(
                entity.getId(),
                PatientResponse.fromEntity(entity.getPatient()),
                LaboratoryResponse.fromEntity(entity.getLaboratory()),
                AnalysisResponse.fromEntity(entity.getAnalysis()),
                entity.getStatus().getDescription()
        );
    }
}
