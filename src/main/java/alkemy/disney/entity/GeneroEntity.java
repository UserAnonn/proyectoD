package alkemy.disney.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.sql.Update;

import javax.persistence.*;

@Entity
@Table(name = "genero")
@Getter
@Setter


public class GeneroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "genero_id")
    private Long id;
    private String imagen;
    private String nombre;
}
