package cl.duoc.fullstack3.ms_lab_assignment.service.patient;

import cl.duoc.fullstack3.ms_lab_assignment.infrastructure.dtos.patient.PatientCreateRequest;
import cl.duoc.fullstack3.ms_lab_assignment.infrastructure.dtos.patient.PatientResponse;
import cl.duoc.fullstack3.ms_lab_assignment.infrastructure.dtos.patient.PatientUpdateRequest;

import java.util.List;

public interface IPatientService {
    List<PatientResponse> findAll();
    PatientResponse findById(Long id);
    PatientResponse findByRut(String rut);
    PatientResponse create (PatientCreateRequest request);
    PatientResponse update (PatientUpdateRequest request);
    void delete (Long id);
}
