package cl.duoc.fullstack3.ms_lab_assignment.infrastructure.rest;

import cl.duoc.fullstack3.ms_lab_assignment.infrastructure.dtos.analysis.AnalysisCreateRequest;
import cl.duoc.fullstack3.ms_lab_assignment.infrastructure.dtos.analysis.AnalysisResponse;
import cl.duoc.fullstack3.ms_lab_assignment.infrastructure.dtos.analysis.AnalysisUpdateRequest;
import cl.duoc.fullstack3.commons.wrapper.WrapperResponse;
import cl.duoc.fullstack3.ms_lab_assignment.service.analysis.IAnalysisService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/analysis")
@RequiredArgsConstructor
@Slf4j
public class AnalysisRestController {
    private final IAnalysisService service;

    @PostMapping
    public WrapperResponse<AnalysisResponse> create (@Valid @RequestBody AnalysisCreateRequest request){
        log.info("[POST] Solicitud de crear analisis");
        AnalysisResponse response = service.create(request);
        return new WrapperResponse<>(response);
    }

    @PutMapping
    public WrapperResponse<AnalysisResponse> update (@Valid @RequestBody AnalysisUpdateRequest request){
        log.info("[PUT] Solicitud de actualizar analisis");
        AnalysisResponse response = service.update(request);
        return new WrapperResponse<>(response);
    }

    @GetMapping
    public WrapperResponse<List<AnalysisResponse>> readAll (){
        log.info("[GET] Solicitud de obtener todos los analisis");
        List<AnalysisResponse> response = service.findAll();
        return new WrapperResponse<>(response);
    }

    @GetMapping("findById/{id}")
    public WrapperResponse<AnalysisResponse> readById (@PathVariable Long id){
        log.info("[GET] Solicitud de obtener analisis por id: {}",id);
        AnalysisResponse response = service.findById(id);
        return new WrapperResponse<>(response);
    }

}
