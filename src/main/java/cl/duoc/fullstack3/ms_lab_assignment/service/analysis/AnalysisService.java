package cl.duoc.fullstack3.ms_lab_assignment.service.analysis;

import cl.duoc.fullstack3.commons.exceptions.EntityNotFoundException;
import cl.duoc.fullstack3.ms_lab_assignment.infrastructure.dtos.analysis.AnalysisCreateRequest;
import cl.duoc.fullstack3.ms_lab_assignment.infrastructure.dtos.analysis.AnalysisResponse;
import cl.duoc.fullstack3.ms_lab_assignment.infrastructure.dtos.analysis.AnalysisUpdateRequest;
import cl.duoc.fullstack3.ms_lab_assignment.domain.entities.AnalysisEntity;
import cl.duoc.fullstack3.ms_lab_assignment.domain.repositories.AnalysisRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AnalysisService implements IAnalysisService{

    private final AnalysisRepository repository;

    @Transactional
    @Override
    public AnalysisResponse create(AnalysisCreateRequest request) {
        log.info("Creando analisis: {}",request);
        AnalysisEntity toPersist = request.toEntity();
        AnalysisEntity persisted = repository.save(toPersist);
        log.info("Analisís creado");
        return AnalysisResponse.fromEntity(persisted);
    }

    @Transactional
    @Override
    public AnalysisResponse update(AnalysisUpdateRequest request) {
        log.info("Actualizando analisis");
        log.info("Obteniendo analisis id: {}",request.id());
        AnalysisEntity found = repository.findById(request.id())
                .orElseThrow(()-> new EntityNotFoundException(String.format("Analisís no encontrado id: %s",request.id())));
        if (!request.name().isBlank()){
            found.setName(request.name());
        }
        if (!request.description().isBlank()){
            found.setDescription(request.description());
        }
        AnalysisEntity updated = repository.save(found);
        log.info("Analisís actualizado");
        return AnalysisResponse.fromEntity(updated);
    }

    @Transactional(readOnly = true)
    @Override
    public List<AnalysisResponse> findAll() {
        log.info("Obteniendo todos los analisís");
        List<AnalysisEntity> entities = (List<AnalysisEntity>) repository.findAll();
        log.info("Cantidad de analisís: {}",entities.size());
        return entities.stream()
                .map(AnalysisResponse::fromEntity)
                .toList();
    }

    @Transactional(readOnly = true)
    @Override
    public AnalysisResponse findById(Long id) {
        log.info("Obteniendo analisis por id: {}",id);
        AnalysisEntity found = repository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException(String.format("Analisís no encontrado id: %s",id)));
        return AnalysisResponse.fromEntity(found);
    }
}
