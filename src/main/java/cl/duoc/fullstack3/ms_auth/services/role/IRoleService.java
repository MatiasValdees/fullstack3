package cl.duoc.fullstack3.ms_auth.services.role;

import cl.duoc.fullstack3.ms_auth.infastructure.dtos.role.RoleCreateRequest;
import cl.duoc.fullstack3.ms_auth.infastructure.dtos.role.RoleResponse;
import cl.duoc.fullstack3.ms_auth.infastructure.dtos.role.RoleUpdateRequest;
import cl.duoc.fullstack3.ms_auth.services.CrudGeneric;

public interface IRoleService extends CrudGeneric<RoleCreateRequest, RoleUpdateRequest, RoleResponse,Long> {
}
