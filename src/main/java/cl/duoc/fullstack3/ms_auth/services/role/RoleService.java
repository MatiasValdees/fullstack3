package cl.duoc.fullstack3.ms_auth.services.role;

import cl.duoc.fullstack3.commons.exceptions.EntityNotFoundException;
import cl.duoc.fullstack3.ms_auth.domain.entities.RoleEntity;
import cl.duoc.fullstack3.ms_auth.domain.repositories.RoleRepository;
import cl.duoc.fullstack3.ms_auth.infastructure.dtos.role.RoleCreateRequest;
import cl.duoc.fullstack3.ms_auth.infastructure.dtos.role.RoleResponse;
import cl.duoc.fullstack3.ms_auth.infastructure.dtos.role.RoleUpdateRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoleService implements IRoleService{
    private final RoleRepository repository;

    @Override
    public List<RoleResponse> findAll() {
        log.info("Obteniendo todos los roles");
        List<RoleEntity> roles = (List<RoleEntity> ) repository.findAll();
        log.info("Cantidad de roles: {}",roles.size());

        return roles.stream()
                .map(RoleResponse::fromEntity)
                .toList();
    }

    @Override
    public RoleResponse findById(Long id) {
        log.info("Obteniendo rol por id: {}",id);
        RoleEntity entity = repository.findById(id)
                .orElseThrow(()->new EntityNotFoundException(String.format("Rol con id: %s, no existe",id)));
        log.info("Rol encontrado");
        return RoleResponse.fromEntity(entity);
    }

    @Override
    public RoleResponse create(RoleCreateRequest request) {
        log.info("Creando rol: {}",request);
        Optional<RoleEntity> roleName = repository.findByName(request.name());
        if (roleName.isPresent()){
            log.error("No es posible crear rol, nombre: {} ya existe",request.name());
            throw new RuntimeException("Nombre ya existe");
        }
        RoleEntity toPersist = RoleEntity.builder()
                .name(request.name())
                .description(request.description())
                .build();
        RoleEntity persisted = repository.save(toPersist);
        log.info("Rol creado");
        return RoleResponse.fromEntity(persisted);
    }

    @Override
    public RoleResponse update(RoleUpdateRequest request) {
        log.info("Actualizando rol id: {}",request.id());
        RoleEntity toUpdate = repository.findById(request.id())
                .orElseThrow(()->new EntityNotFoundException(String.format("Rol con id: %s no encontrado",request.id())));

        Optional<RoleEntity> roleName = repository.findByName(request.name());
        if (roleName.isPresent() && !roleName.get().getId().equals(request.id())){
            log.error("No es posible crear rol, nombre ya existe");
            throw new RuntimeException("Nombre ya existe");
        }

        if (!request.name().isBlank()){
            toUpdate.setName(request.name());
        }
        if (!request.description().isBlank()){
            toUpdate.setDescription(request.description());
        }

        RoleEntity updated = repository.save(toUpdate);
        log.info("Rol actualizado");
        return RoleResponse.fromEntity(updated);
    }

    @Override
    public void delete(Long id) {
        log.info("Eliminando rol por id: {}",id);
        if (!repository.existsById(id)){
            log.warn("No se puede eliminar rol, debido a que no existe");
            throw new EntityNotFoundException(String.format("No es posible eliminar rol id: %s",id));
        }
        repository.deleteById(id);
        log.warn("Rol eliminado");
    }
}
