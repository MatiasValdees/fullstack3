package cl.duoc.fullstack3.ms_lab_assignment.domain.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ASSIGNMENTS")
@Getter
@Setter
@Builder
@AllArgsConstructor
public class AssignmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "PATIENT_ID")
    private PatientEntity patient;
    @ManyToOne
    @JoinColumn(name = "LABORATORY_ID")
    private LaboratoryEntity laboratory;
    @ManyToOne
    @JoinColumn(name = "STATUS_ID")
    private StatusEntity status;
}
