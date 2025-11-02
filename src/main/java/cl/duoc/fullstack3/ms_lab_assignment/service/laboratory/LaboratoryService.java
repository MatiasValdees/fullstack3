package cl.duoc.fullstack3.ms_lab_assignment.service.laboratory;

import cl.duoc.fullstack3.commons.exceptions.EntityNotFoundException;
import cl.duoc.fullstack3.ms_lab_assignment.infrastructure.dtos.laboratory.LaboratoryCreateRequest;
import cl.duoc.fullstack3.ms_lab_assignment.infrastructure.dtos.laboratory.LaboratoryResponse;
import cl.duoc.fullstack3.ms_lab_assignment.infrastructure.dtos.laboratory.LaboratoryUpdateRequest;
import cl.duoc.fullstack3.ms_lab_assignment.domain.entities.LaboratoryEntity;
import cl.duoc.fullstack3.ms_lab_assignment.domain.repositories.LaboratoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class LaboratoryService implements ILaboratoryService {
    private final LaboratoryRepository repository;

    @Transactional(readOnly = true)
    @Override
    public List<LaboratoryResponse> findAll() {
        log.info("Obteniendo todos los laboratorios");
        List<LaboratoryEntity> laboratories = (List<LaboratoryEntity>) repository.findAll();
        log.info("Cantidad de laboratorios: {}", laboratories.size());

        return laboratories.stream()
                .map(LaboratoryResponse::fromEntity)
                .toList();
    }

    @Transactional(readOnly = true)
    @Override
    public LaboratoryResponse findById(Long id) {
        log.info("Obteniendo laboratorio por id: {}",id);
        LaboratoryEntity laboratoryFound = repository.findById(id)
                .orElseThrow(()->new EntityNotFoundException(String.format("Laboratorio con id: %s no existe",id)));
        log.info("Laboratorio encontrado");
        return LaboratoryResponse.fromEntity(laboratoryFound);
    }
    @Transactional
    @Override
    public LaboratoryResponse create(LaboratoryCreateRequest request) {
        log.info("Creado laboratorio: {}",request);
        LaboratoryEntity toPersist = request.toEntity();
        LaboratoryEntity persisted = repository.save(toPersist);
        log.info("Laboratorio creado");
        return LaboratoryResponse.fromEntity(persisted);
    }

    @Transactional
    @Override
    public LaboratoryResponse update(LaboratoryUpdateRequest request) {
        log.info("Actualizando laboratorio con id: {}",request.id());
        LaboratoryEntity laboratoryFound = repository.findById(request.id())
                .orElseThrow(()->new EntityNotFoundException(String.format("Laboratorio con id: %s no existe",request.id())));
        log.info("Laboratorio encontrado");
        if (!request.name().isBlank()){
            laboratoryFound.setName(request.name());
        }
        if (!request.address().isBlank()){
            laboratoryFound.setAddress(request.address());
        }
        LaboratoryEntity updated = repository.save(laboratoryFound);
        return LaboratoryResponse.fromEntity(updated);
    }
}
