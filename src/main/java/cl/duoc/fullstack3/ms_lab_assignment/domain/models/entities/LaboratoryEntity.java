package cl.duoc.fullstack3.ms_lab_assignment.domain.models.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "LABORATORIES")
@Getter
@Setter
@Builder
@AllArgsConstructor
public class LaboratoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME", length = 60)
    private String name;
    @Column(name = "NAME", length = 80)
    private String address;

}
