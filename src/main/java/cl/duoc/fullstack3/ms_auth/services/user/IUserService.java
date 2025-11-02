package cl.duoc.fullstack3.ms_auth.services.user;

import cl.duoc.fullstack3.ms_auth.infastructure.dtos.user.UserCreateRequest;
import cl.duoc.fullstack3.ms_auth.infastructure.dtos.user.UserResponse;
import cl.duoc.fullstack3.ms_auth.infastructure.dtos.user.UserUpdateRequest;
import cl.duoc.fullstack3.ms_auth.services.CrudGeneric;

public interface IUserService extends CrudGeneric<UserCreateRequest, UserUpdateRequest, UserResponse,Long> {
}
