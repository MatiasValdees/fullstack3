package cl.duoc.fullstack3.ms_lab_assignment.domain.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "LABORATORIES")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LaboratoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME", length = 60)
    private String name;
    @Column(name = "ADDRESS", length = 80)
    private String address;

}
