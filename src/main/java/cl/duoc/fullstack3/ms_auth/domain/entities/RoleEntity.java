package cl.duoc.fullstack3.ms_auth.domain.entities;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "ROLES")
@AllArgsConstructor
@Getter
@Setter
@Builder
@NoArgsConstructor
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME",length = 20, unique = true)
    private String name;

    @Column(name = "DESCRIPTION",length = 200)
    private String description;


}
