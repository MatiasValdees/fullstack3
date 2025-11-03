package cl.duoc.fullstack3.ms_lab_assignment.service.assignment;

import cl.duoc.fullstack3.ms_lab_assignment.domain.entities.*;
import cl.duoc.fullstack3.ms_lab_assignment.domain.enums.StatusEnum;
import cl.duoc.fullstack3.commons.exceptions.EntityNotFoundException;
import cl.duoc.fullstack3.ms_lab_assignment.domain.repositories.*;
import cl.duoc.fullstack3.ms_lab_assignment.infrastructure.dtos.assignment.AssignmentCreateRequest;
import cl.duoc.fullstack3.ms_lab_assignment.infrastructure.dtos.assignment.AssignmentResponse;
import cl.duoc.fullstack3.ms_lab_assignment.infrastructure.dtos.assignment.AssignmentUpdateRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AssignmentService implements IAssignmentService{
    private final AssignmentRepository repository;
    private final StatusRepository statusRepository;
    private final PatientRepository patientRepository;
    private final LaboratoryRepository laboratoryRepository;
    private final AnalysisRepository analysisRepository;

    @Transactional
    @Override
    public AssignmentResponse create(AssignmentCreateRequest request) {
        log.info("Creando asignación de analisis: {}",request);
        Integer initialStatus =  StatusEnum.PENDING.getStatusId();

        log.info("Obteniendo estado inicial");
        StatusEntity status = statusRepository.findById(initialStatus)
                .orElseThrow(()->new EntityNotFoundException(String.format("Estado no encontrado id: %s",initialStatus)));
        log.info("Estado inicial: {}",status.getDescription());

        log.info("Obteniendo laboratorio");
        LaboratoryEntity laboratory = laboratoryRepository.findById(request.laboratoryId())
                .orElseThrow(()->new EntityNotFoundException(String.format("Laboratorio no encontrado id: %s",request.laboratoryId())));
        log.info("Laboratorio encontrado: {}",laboratory.getName());

        log.info("Obteniendo Paciente");
        PatientEntity patient = patientRepository.findById(request.patientId())
                .orElseThrow(()->new EntityNotFoundException(String.format("Paciente no encontrado id: %s",request.patientId())));
        log.info("Paciente encontrado: {}",patient.getRut());

        log.info("Obteniendo analisis");
        AnalysisEntity analysis = analysisRepository.findById(request.analysisId())
                .orElseThrow(()->new EntityNotFoundException(String.format("Analisis no encontrado id: %s",request.analysisId())));
        log.info("Analisis encontrado");

        AssignmentEntity toPersist = AssignmentEntity.builder()
                .patient(patient)
                .laboratory(laboratory)
                .status(status)
                .analysis(analysis)
                .build();
        log.info("Guardando nueva asignación");
        AssignmentEntity persisted = repository.save(toPersist);
        log.info("Asignación guardada");
        return AssignmentResponse.fromEntity(persisted);
    }

    @Transactional
    @Override
    public AssignmentResponse updateStatus(AssignmentUpdateRequest request) {
        log.info("Actualizando asignación");

        log.info("Obteniendo asignación id: {}",request.id());
        AssignmentEntity toPersist = repository.findById(request.id())
                        .orElseThrow(()->new EntityNotFoundException(String.format("Asignación con id: %s, no existe",request.id())));
        log.info("Asignación encontrada");

        log.info("Obteniendo nuevo estado");
        StatusEntity status = statusRepository.findById(request.statusId())
                .orElseThrow(()->new EntityNotFoundException(String.format("Estado no encontrado id: %s",request.statusId())));
        log.info("Estado encontrado: {}",status.getDescription());

        toPersist.setStatus(status);

        AssignmentEntity persisted = repository.save(toPersist);
        return AssignmentResponse.fromEntity(persisted);
    }

    @Transactional(readOnly = true)
    @Override
    public List<AssignmentResponse> findAll() {
        log.info("Obteniendo todas las asignaciones");
        List<AssignmentEntity> assignments = (List<AssignmentEntity>) repository.findAll();
        log.info("Cantidad de Asignaciones");
        return assignments.stream()
                .map(AssignmentResponse::fromEntity)
                .toList();
    }

    @Override
    public AssignmentResponse findById(Long id) {
        log.info("Obteniendo asignación por id: {}",id);
        AssignmentEntity found = repository.findById(id)
                .orElseThrow(()->new EntityNotFoundException(String.format("Asignación con id: %s, no existe",id)));
        log.info("Asignación encontrada");
        return AssignmentResponse.fromEntity(found);
    }
}
