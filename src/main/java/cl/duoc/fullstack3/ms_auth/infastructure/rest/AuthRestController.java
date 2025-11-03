package cl.duoc.fullstack3.ms_auth.infastructure.rest;

import cl.duoc.fullstack3.commons.wrapper.WrapperResponse;
import cl.duoc.fullstack3.ms_auth.infastructure.dtos.auth.LoginRequest;
import cl.duoc.fullstack3.ms_auth.infastructure.dtos.auth.LoginResponse;
import cl.duoc.fullstack3.ms_auth.services.auth.IAuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class AuthRestController {
    private final IAuthService service;

    @PostMapping("/login")
    public WrapperResponse<LoginResponse> login (@Valid @RequestBody LoginRequest request){
        log.info("Solicitud de login");
        LoginResponse response = service.login(request);
        return new WrapperResponse<>(response);
    }
}
