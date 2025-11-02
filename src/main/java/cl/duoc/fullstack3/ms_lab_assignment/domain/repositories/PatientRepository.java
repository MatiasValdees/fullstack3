package cl.duoc.fullstack3.ms_lab_assignment.domain.repositories;

import cl.duoc.fullstack3.ms_lab_assignment.domain.entities.PatientEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PatientRepository extends CrudRepository<PatientEntity,Long> {
    Optional<PatientEntity> findByRut(String rut);
}
