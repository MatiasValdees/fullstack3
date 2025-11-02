package cl.duoc.fullstack3.ms_lab_assignment.infrastructure.rest;

import cl.duoc.fullstack3.ms_lab_assignment.infrastructure.rest.dtos.patient.PatientCreateRequest;
import cl.duoc.fullstack3.ms_lab_assignment.infrastructure.rest.dtos.patient.PatientResponse;
import cl.duoc.fullstack3.ms_lab_assignment.infrastructure.rest.dtos.patient.PatientUpdateRequest;
import cl.duoc.fullstack3.ms_lab_assignment.infrastructure.rest.wrapper.WrapperResponse;
import cl.duoc.fullstack3.ms_lab_assignment.service.patient.IPatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class PatientRestController {
    private final IPatientService service;

    @GetMapping("findById/{id}")
    public WrapperResponse<PatientResponse> readById (@PathVariable Long id){
        log.info("[POST] - Solicitud de obtención de paciente por id");
        PatientResponse response = service.findById(id);
        return new WrapperResponse<>(response);
    }

    @GetMapping("findByRut/{id}")
    public WrapperResponse<PatientResponse> readByRut (@PathVariable String rut){
        log.info("[POST] - Solicitud de obtención de paciente por rut");
        PatientResponse response = service.findByRut(rut);
        return new WrapperResponse<>(response);
    }

    @GetMapping
    public WrapperResponse<List<PatientResponse>> readAll (){
        log.info("[POST] - Solicitud de obtención de todos los paciente");
        List<PatientResponse> response = service.findAll();
        return new WrapperResponse<>(response);
    }

    @PostMapping
    public WrapperResponse<PatientResponse> create (@Valid @RequestBody PatientCreateRequest request){
        log.info("[POST] - Solicitud de creación de paciente");
        PatientResponse response = service.create(request);
        return new WrapperResponse<>(response);
    }

    @PutMapping
    public WrapperResponse<PatientResponse> update (@Valid @RequestBody PatientUpdateRequest request){
        log.info("[POST] - Solicitud de actualización de paciente");
        PatientResponse response = service.update(request);
        return new WrapperResponse<>(response);
    }

    @DeleteMapping("{id}")
    public WrapperResponse<Void> delete (@PathVariable Long id){
        log.info("[POST] - Solicitud de eliminación de paciente por id: {}",id);
        service.delete(id);
        return new WrapperResponse<>();
    }


}
