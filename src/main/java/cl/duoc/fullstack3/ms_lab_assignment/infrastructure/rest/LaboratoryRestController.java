package cl.duoc.fullstack3.ms_lab_assignment.infrastructure.rest;

import cl.duoc.fullstack3.ms_lab_assignment.infrastructure.dtos.laboratory.LaboratoryCreateRequest;
import cl.duoc.fullstack3.ms_lab_assignment.infrastructure.dtos.laboratory.LaboratoryResponse;
import cl.duoc.fullstack3.ms_lab_assignment.infrastructure.dtos.laboratory.LaboratoryUpdateRequest;
import cl.duoc.fullstack3.commons.wrapper.WrapperResponse;
import cl.duoc.fullstack3.ms_lab_assignment.service.laboratory.ILaboratoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/laboratories")
@RequiredArgsConstructor
@Slf4j
public class LaboratoryRestController {
    private final ILaboratoryService service;

    @PostMapping
    public WrapperResponse<LaboratoryResponse> create (@Valid @RequestBody LaboratoryCreateRequest request){
        log.info("Solicitud de crear laboratorio");
        LaboratoryResponse response = service.create(request);
        return new WrapperResponse<>(response);
    }

    @PutMapping
    public WrapperResponse<LaboratoryResponse> update (@Valid @RequestBody LaboratoryUpdateRequest request){
        log.info("Solicitud de actualizar laboratorio");
        LaboratoryResponse response = service.update(request);
        return new WrapperResponse<>(response);
    }

    @GetMapping
    public WrapperResponse<List<LaboratoryResponse>> readAll (){
        log.info("Solicitud de obtener todos los laboratorios");
        List<LaboratoryResponse> response = service.findAll();
        return new WrapperResponse<>(response);
    }

    @GetMapping("findById/{id}")
    public WrapperResponse<LaboratoryResponse> readById (@PathVariable Long id){
        log.info("Solicitud de obtener laboratorio por id: {}",id);
        LaboratoryResponse response = service.findById(id);
        return new WrapperResponse<>(response);
    }
    
    
}
