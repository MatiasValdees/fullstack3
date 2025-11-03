package cl.duoc.fullstack3.ms_auth.services.user;

import cl.duoc.fullstack3.commons.exceptions.EntityNotFoundException;
import cl.duoc.fullstack3.ms_auth.domain.entities.RoleEntity;
import cl.duoc.fullstack3.ms_auth.domain.entities.UserEntity;
import cl.duoc.fullstack3.commons.exceptions.UsernameException;
import cl.duoc.fullstack3.ms_auth.domain.repositories.RoleRepository;
import cl.duoc.fullstack3.ms_auth.domain.repositories.UserRepository;
import cl.duoc.fullstack3.ms_auth.infastructure.dtos.user.UserCreateRequest;
import cl.duoc.fullstack3.ms_auth.infastructure.dtos.user.UserResponse;
import cl.duoc.fullstack3.ms_auth.infastructure.dtos.user.UserUpdateRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService implements IUserService{
    private final UserRepository repository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoderBean;

    @Transactional(readOnly = true)
    @Override
    public List<UserResponse> findAll() {
        log.info("Obteniendo todos los usuarios");
        List<UserEntity> users = (List<UserEntity>) repository.findAll();
        log.info("Cantidad de usuarios: {}",users.size());
        return users.stream()
                .map(UserResponse::fromEntity)
                .toList();
    }
    @Transactional(readOnly = true)
    @Override
    public UserResponse findById(Long id) {
        log.info("Obteniendo usuario por id: {}",id);
        UserEntity found = repository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException(String.format("Usuario con id: %s, no existe",id)));
        log.info("Usuario encontrado");
        return UserResponse.fromEntity(found);
    }

    @Override
    public UserResponse create(UserCreateRequest request) {
        log.info("Creando usuario: {}",request);

        Optional<UserEntity> userByUsername = repository.findByUsername(request.username().toUpperCase());
        if (userByUsername.isPresent()){
            log.info("Username no disponible");
            throw new UsernameException("El username no está disponible");
        }
        UserEntity toPersist = UserEntity.builder()
                .username(request.username().toUpperCase())
                .createdAt(LocalDateTime.now())
                .password(passwordEncoderBean.encode(request.password()))
                .build();

        if (!request.rolesId().isEmpty()){
            List<RoleEntity> roles = (List<RoleEntity>) roleRepository.findAllById(request.rolesId());
            toPersist.setRoles(roles);
        }
        UserEntity persisted = repository.save(toPersist);
        log.info("Usuario creado");
        return UserResponse.fromEntity(persisted);
    }

    @Override
    public UserResponse update(UserUpdateRequest request) {
        UserEntity toUpdate = repository.findById(request.id())
                .orElseThrow(()-> new EntityNotFoundException(String.format("Usuario con id: %s, no existe",request.id())));
        if (!request.password().isBlank()){
            toUpdate.setPassword(passwordEncoderBean.encode(request.password()));
        }
        if (!request.username().isBlank()){
            Optional<UserEntity> userByUsername = repository.findByUsername(request.username().toUpperCase());
            if (userByUsername.isPresent() && !userByUsername.get().getId().equals(request.id())){
                throw new UsernameException("El username no está disponible");
            }
            toUpdate.setUsername(request.username().toUpperCase());
        }
        if (!request.rolesId().isEmpty()){
            List<RoleEntity> roles = (List<RoleEntity>) roleRepository.findAllById(request.rolesId());
            toUpdate.setRoles(roles);
        }
        toUpdate.setUpdatedAt(LocalDateTime.now());

        UserEntity updated = repository.save(toUpdate);
        log.info("Usuario actualizado");
        return UserResponse.fromEntity(updated);
    }

    @Override
    public void delete(Long id) {
        log.info("Eliminando usuario con id: {}",id);
        if(!repository.existsById(id)){
           throw new EntityNotFoundException(String.format("Usuario con id: %s no existe",id));
        }
        repository.deleteById(id);
        log.info("Usuario eliminado");
    }
}
