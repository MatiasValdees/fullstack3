package cl.duoc.fullstack3.ms_auth.domain.repositories;

import cl.duoc.fullstack3.ms_auth.domain.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserEntity,Long> {
    Optional<UserEntity> findByUsername(String username);
}
