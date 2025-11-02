package cl.duoc.fullstack3.ms_lab_assignment.service.analysis;

import cl.duoc.fullstack3.ms_lab_assignment.infrastructure.dtos.analysis.AnalysisCreateRequest;
import cl.duoc.fullstack3.ms_lab_assignment.infrastructure.dtos.analysis.AnalysisResponse;
import cl.duoc.fullstack3.ms_lab_assignment.infrastructure.dtos.analysis.AnalysisUpdateRequest;

import java.util.List;

public interface IAnalysisService {
    AnalysisResponse create (AnalysisCreateRequest request);
    AnalysisResponse update (AnalysisUpdateRequest request);
    List<AnalysisResponse> findAll();
    AnalysisResponse findById(Long id);
}
