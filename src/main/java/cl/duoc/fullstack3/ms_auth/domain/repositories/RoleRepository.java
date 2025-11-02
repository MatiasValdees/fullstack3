package cl.duoc.fullstack3.ms_auth.domain.repositories;

import cl.duoc.fullstack3.ms_auth.domain.entities.RoleEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RoleRepository extends CrudRepository<RoleEntity,Long> {
    Optional<RoleEntity> findByName(String name);
}
