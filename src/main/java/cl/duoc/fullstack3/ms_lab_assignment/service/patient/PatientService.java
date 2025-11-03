package cl.duoc.fullstack3.ms_lab_assignment.service.patient;

import cl.duoc.fullstack3.commons.exceptions.EntityNotFoundException;
import cl.duoc.fullstack3.ms_lab_assignment.infrastructure.dtos.patient.PatientCreateRequest;
import cl.duoc.fullstack3.ms_lab_assignment.infrastructure.dtos.patient.PatientResponse;
import cl.duoc.fullstack3.ms_lab_assignment.infrastructure.dtos.patient.PatientUpdateRequest;
import cl.duoc.fullstack3.ms_lab_assignment.domain.entities.PatientEntity;
import cl.duoc.fullstack3.ms_lab_assignment.domain.repositories.PatientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PatientService implements IPatientService{
    private final PatientRepository repository;

    @Transactional(readOnly = true)
    @Override
    public List<PatientResponse> findAll() {
        log.info("Obteniendo todos los pacientes");
        List<PatientEntity> patients = (List<PatientEntity>) repository.findAll();
        log.info("Cantidad de pacientes: {}",patients.size());

        return patients.stream()
                .map(PatientResponse::fromEntity)
                .toList();
    }
    @Transactional(readOnly = true)
    @Override
    public PatientResponse findById(Long id) {
        log.info("Obteniendo paciente por id: {}",id);
        PatientEntity patientFound = repository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException(String.format("Paciente con id: %s no existe",id)));
        log.info("Paciente encontrado");
        return PatientResponse.fromEntity(patientFound);
    }
    @Transactional(readOnly = true)
    @Override
    public PatientResponse findByRut(String rut) {
        log.info("Obteniendo paciente por rut: {}",rut);
        PatientEntity patientFound = repository.findByRut(rut)
                .orElseThrow(()-> new EntityNotFoundException(String.format("Paciente con rut: %s no existe",rut)));
        log.info("Paciente encontrado");
        return PatientResponse.fromEntity(patientFound);
    }

    @Transactional
    @Override
    public PatientResponse create(PatientCreateRequest request) {
        log.info("Creando paciente: {}",request);
        log.info("Consultando existencia de rut: {}",request.rut());
        Optional<PatientEntity> rutExist = repository.findByRut(request.rut());
        if (rutExist.isPresent()){
            throw new RuntimeException("Rut ya existe");
        }
        PatientEntity patientToPersist = request.toEntity();
        PatientEntity patientPersisted = repository.save(patientToPersist);
        log.info("Paciente creado id: {}",patientPersisted.getId());
        return PatientResponse.fromEntity(patientPersisted);
    }

    @Transactional
    @Override
    public PatientResponse update(PatientUpdateRequest request) {
        log.info("Actualizando paciente con id: {}",request.id());

        PatientEntity entityToUpdate = repository.findById(request.id())
                .orElseThrow(()-> new EntityNotFoundException(String.format("Paciente con id: %s no existe",request.id())));

        if (!request.rut().isBlank()){
            entityToUpdate.setRut(request.rut());
        }
        if (request.birthDate() != null){
            entityToUpdate.setBirthDate(request.birthDate());
        }
        if (!request.fullName().isBlank()){
            entityToUpdate.setFullName(request.fullName());
        }
        PatientEntity patientUpdated = repository.save(entityToUpdate);
        log.info("Paciente actualizado");
        return PatientResponse.fromEntity(patientUpdated);
    }
    @Transactional
    @Override
    public void delete(Long id) {
        log.info("Eliminando paciente con id: {}",id);
        if(!repository.existsById(id)){
            log.warn("No es posible eliminar paciente con id: {}, debido a que no existe paciente",id);
            return;
        }
        repository.deleteById(id);
        log.info("Paciente eliminado");
    }
}
