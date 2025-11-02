package cl.duoc.fullstack3.ms_auth.infastructure.rest;

import cl.duoc.fullstack3.commons.wrapper.WrapperResponse;
import cl.duoc.fullstack3.ms_auth.infastructure.dtos.role.RoleCreateRequest;
import cl.duoc.fullstack3.ms_auth.infastructure.dtos.role.RoleResponse;
import cl.duoc.fullstack3.ms_auth.infastructure.dtos.role.RoleUpdateRequest;
import cl.duoc.fullstack3.ms_auth.services.role.IRoleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
@Slf4j
public class RoleRestController {
    private final IRoleService service;

    @GetMapping
    public WrapperResponse<List<RoleResponse>>readAll(){
        log.info("[GET] Solicitud de obtención de todos los roles");
        List<RoleResponse> response = service.findAll();
        return new WrapperResponse<>(response);
    }
    @GetMapping("/findById/{id}")
    public WrapperResponse<RoleResponse>readById (@PathVariable Long id){
        log.info("[GET] Solicitud de obtención de rol por id: {}",id);
        RoleResponse response = service.findById(id);
        return new WrapperResponse<>(response);
    }

    @PostMapping
    public WrapperResponse<RoleResponse> create (@Valid @RequestBody RoleCreateRequest request){
        log.info("[POST] Solicitud de creación de rol");
        RoleResponse response = service.create(request);
        return new WrapperResponse<>(response);
    }

    @PutMapping
    public WrapperResponse<RoleResponse>update (@Valid @RequestBody RoleUpdateRequest request){
        log.info("[PUT] Solicitud de actualizacion de rol");
        RoleResponse response = service.update(request);
        return new WrapperResponse<>(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        log.info("[DELETE] Solicitud de eliminación de rol por id: {}",id);
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
