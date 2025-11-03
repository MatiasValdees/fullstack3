package cl.duoc.fullstack3.ms_auth.infastructure.rest;

import cl.duoc.fullstack3.commons.wrapper.WrapperResponse;
import cl.duoc.fullstack3.ms_auth.infastructure.dtos.user.UserCreateRequest;
import cl.duoc.fullstack3.ms_auth.infastructure.dtos.user.UserResponse;
import cl.duoc.fullstack3.ms_auth.infastructure.dtos.user.UserUpdateRequest;
import cl.duoc.fullstack3.ms_auth.services.user.IUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Slf4j
public class UserRestController {
    private final IUserService service;

    @GetMapping
    public WrapperResponse<List<UserResponse>>readAll(){
        log.info("[GET] Solicitud de obtención de todos los usuarios");
        List<UserResponse> response = service.findAll();
        return new WrapperResponse<>(response);
    }
    @GetMapping("/findById/{id}")
    public WrapperResponse<UserResponse>readById (@PathVariable Long id){
        log.info("[GET] Solicitud de obtención de usuario por id: {}",id);
        UserResponse response = service.findById(id);
        return new WrapperResponse<>(response);
    }

    @PostMapping
    public WrapperResponse<UserResponse> create (@Valid @RequestBody UserCreateRequest request){
        log.info("[POST] Solicitud de creación de usuario");
        UserResponse response = service.create(request);
        return new WrapperResponse<>(response);
    }

    @PutMapping
    public WrapperResponse<UserResponse>update (@Valid @RequestBody UserUpdateRequest request){
        log.info("[PUT] Solicitud de actualizacion de usuario");
        UserResponse response = service.update(request);
        return new WrapperResponse<>(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        log.info("[DELETE] Solicitud de eliminación de usuario por id: {}",id);
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
