package cl.duoc.fullstack3.ms_lab_assignment.domain.repositories;

import cl.duoc.fullstack3.ms_lab_assignment.domain.models.entities.AnalysisEntity;
import org.springframework.data.repository.CrudRepository;

public interface AnalysisRepository extends CrudRepository<AnalysisEntity,Long> {
}
