package cl.duoc.fullstack3.ms_auth.services.auth;

import cl.duoc.fullstack3.ms_auth.infastructure.dtos.auth.LoginRequest;
import cl.duoc.fullstack3.ms_auth.infastructure.dtos.auth.LoginResponse;

public interface IAuthService {
    LoginResponse login (LoginRequest request);
}
