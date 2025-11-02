package cl.duoc.fullstack3.ms_lab_assignment.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "PATIENTS")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PatientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "FULL_NAME", length = 60)
    private String fullName;
    @Column(name = "RUT",unique = true,length = 15)
    private String rut;
    @Column(name = "BIRTH_DATE")
    private LocalDate birthDate;
}
