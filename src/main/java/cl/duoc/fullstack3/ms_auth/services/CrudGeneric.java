package cl.duoc.fullstack3.ms_auth.services;

import java.util.List;

public interface CrudGeneric <RequestCreate, RequestUpdate, Response,ID>{
    List <Response> findAll ();
    Response findById(ID id);
    Response create (RequestCreate request);
    Response update (RequestUpdate request);
    void delete (ID id);
}
