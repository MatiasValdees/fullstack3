package cl.duoc.fullstack3.ms_lab_assignment.domain.repositories;

import cl.duoc.fullstack3.ms_lab_assignment.domain.entities.AssignmentEntity;
import org.springframework.data.repository.CrudRepository;

public interface AssignmentRepository extends CrudRepository<AssignmentEntity,Long> {
}
