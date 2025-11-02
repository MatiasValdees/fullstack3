package cl.duoc.fullstack3.ms_lab_assignment.domain.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ANALYSIS")
@Getter
@Setter
@Builder
@AllArgsConstructor
public class AnalysisEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME", length = 60,unique = true)
    private String name;
    @Column(name = "DESCRIPTION",length = 200)
    private String description;
}
