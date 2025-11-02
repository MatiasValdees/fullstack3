package cl.duoc.fullstack3.ms_lab_assignment.domain.repositories;

import cl.duoc.fullstack3.ms_lab_assignment.domain.models.entities.StatusEntity;
import org.springframework.data.repository.CrudRepository;

public interface StatusRepository extends CrudRepository<StatusEntity,Integer> {
}
