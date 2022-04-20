package alkemy.disney.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PeliculaFiltersDTO {
    private String titulo;
    private Long generoId;
    private String orden;

    public PeliculaFiltersDTO(String titulo, Long generoId, String orden){
        this.titulo = titulo;
        this.generoId = generoId;
        this.orden = orden;
    }

    public boolean isASC(){ return this.orden.compareToIgnoreCase("ASC") == 0; }
    public boolean isDESC() { return this.orden.compareToIgnoreCase("DESC") == 0; }
}
