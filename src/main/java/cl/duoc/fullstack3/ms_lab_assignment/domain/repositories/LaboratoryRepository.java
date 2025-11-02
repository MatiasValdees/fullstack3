package cl.duoc.fullstack3.ms_lab_assignment.domain.repositories;

import cl.duoc.fullstack3.ms_lab_assignment.domain.entities.LaboratoryEntity;
import org.springframework.data.repository.CrudRepository;

public interface LaboratoryRepository extends CrudRepository<LaboratoryEntity,Long> {
}
