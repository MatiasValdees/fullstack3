package cl.duoc.fullstack3.ms_auth.services.auth;

import cl.duoc.fullstack3.commons.exceptions.InvalidCredentialException;
import cl.duoc.fullstack3.ms_auth.domain.entities.RoleEntity;
import cl.duoc.fullstack3.ms_auth.domain.entities.UserEntity;
import cl.duoc.fullstack3.ms_auth.domain.repositories.UserRepository;
import cl.duoc.fullstack3.ms_auth.infastructure.dtos.auth.LoginRequest;
import cl.duoc.fullstack3.ms_auth.infastructure.dtos.auth.LoginResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService implements IAuthService{
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoderBean;

    @Transactional(readOnly = true)
    @Override
    public LoginResponse login(LoginRequest request) {
        UserEntity user = repository.findByUsername(request.username().toUpperCase())
                .orElseThrow(InvalidCredentialException::new);
        if (!passwordEncoderBean.matches(request.password(),user.getPassword())){
            throw new InvalidCredentialException();
        }
        List<String> roles = user.getRoles().stream().map(RoleEntity::getName).toList();
        return new LoginResponse(user.getUsername(), roles);
    }
}
