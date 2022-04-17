package alkemy.disney.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
public class PeliculaDTO implements Serializable {

    private Long id;
    private String imagen;
    private String titulo;
    private LocalDate fechaCreacion;
    private Integer calificacion;
    private Long generoId;
    private Set<PersonajeBasicDTO> personajes;

}