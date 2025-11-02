package cl.duoc.fullstack3.ms_lab_assignment.domain.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ANALYSIS_STATUS")
@AllArgsConstructor
@Getter
@Setter
@Builder
public class StatusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "DESCRIPTION",length = 20)
    private String description;
}
