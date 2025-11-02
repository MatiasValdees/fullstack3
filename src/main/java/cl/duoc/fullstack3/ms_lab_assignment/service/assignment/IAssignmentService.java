package cl.duoc.fullstack3.ms_lab_assignment.service.assignment;

import cl.duoc.fullstack3.ms_lab_assignment.infrastructure.dtos.assignment.AssignmentCreateRequest;
import cl.duoc.fullstack3.ms_lab_assignment.infrastructure.dtos.assignment.AssignmentResponse;
import cl.duoc.fullstack3.ms_lab_assignment.infrastructure.dtos.assignment.AssignmentUpdateRequest;

import java.util.List;

public interface IAssignmentService {
    AssignmentResponse create (AssignmentCreateRequest request);
    AssignmentResponse updateStatus (AssignmentUpdateRequest request);
    List<AssignmentResponse> findAll();
    AssignmentResponse findById(Long id);

}
