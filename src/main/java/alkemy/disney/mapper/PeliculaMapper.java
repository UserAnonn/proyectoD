package alkemy.disney.mapper;

import alkemy.disney.dto.GeneroDTO;
import alkemy.disney.dto.PeliculaBasicDTO;
import alkemy.disney.dto.PeliculaDTO;
import alkemy.disney.entity.GeneroEntity;
import alkemy.disney.entity.PeliculaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PeliculaMapper {

    @Autowired
    private GeneroMapper generoMapper;

    public PeliculaEntity peliculaDTO2Entity(PeliculaDTO peliculaDTO) {

        PeliculaEntity peliculaEntity = new PeliculaEntity();
        peliculaEntity.setImagen(peliculaDTO.getImagen());
        peliculaEntity.setTitulo(peliculaDTO.getTitulo());
        peliculaEntity.setFechaCreacion(peliculaDTO.getFechaCreacion());
        peliculaEntity.setCalificacion(peliculaDTO.getCalificacion());
        peliculaEntity.setGeneroId(peliculaDTO.getGeneroId());
        return peliculaEntity;
    }

    public PeliculaDTO peliculaEntity2DTO(PeliculaEntity peliculaEntity, boolean b) {
        PeliculaDTO peliculaDTO = new PeliculaDTO();
        peliculaDTO.setId(peliculaEntity.getId());
        peliculaDTO.setImagen(peliculaEntity.getImagen());
        peliculaDTO.setTitulo(peliculaEntity.getTitulo());
        peliculaDTO.setFechaCreacion(peliculaDTO.getFechaCreacion());
        peliculaDTO.setCalificacion(peliculaEntity.getCalificacion());
        peliculaEntity.setGenero(peliculaEntity.getGenero());
        return peliculaDTO;
    }

    public PeliculaBasicDTO peliculaEntity2BasicDTO(PeliculaEntity peliculaEntity){
        PeliculaBasicDTO peliculaBasicDTO = new PeliculaBasicDTO();
        peliculaBasicDTO.setImagen(peliculaEntity.getImagen());
        peliculaBasicDTO.setTitulo(peliculaEntity.getTitulo());
        peliculaBasicDTO.setFechaCreacion(peliculaEntity.getFechaCreacion());
        return peliculaBasicDTO;
    }

    public List<PeliculaBasicDTO> peliculaEntitySet2DTOSet(List<PeliculaEntity> peliculaEntities){
        List<PeliculaBasicDTO> dtos = new ArrayList<>();
        for (PeliculaEntity entity : peliculaEntities){
            dtos.add(peliculaEntity2BasicDTO(entity));
        }
        return dtos;
    }

   public PeliculaEntity updateValues(PeliculaEntity peliculaEntity, PeliculaDTO peliculaDTO){
        peliculaEntity.setImagen(peliculaDTO.getImagen());
        peliculaEntity.setTitulo(peliculaDTO.getTitulo());
        peliculaEntity.setFechaCreacion(peliculaDTO.getFechaCreacion());
        peliculaEntity.setCalificacion(peliculaDTO.getCalificacion());
        peliculaEntity.setGeneroId(peliculaDTO.getGeneroId());
        return peliculaEntity;
    }
}
