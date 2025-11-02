package cl.duoc.fullstack3.ms_lab_assignment.domain.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ANALYSIS_STATUS")
@AllArgsConstructor
@Getter
@Setter
@Builder
@NoArgsConstructor
public class StatusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "DESCRIPTION",length = 20)
    private String description;
}
