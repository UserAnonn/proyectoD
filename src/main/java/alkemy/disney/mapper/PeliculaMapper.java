package alkemy.disney.mapper;

import alkemy.disney.dto.PeliculaBasicDTO;
import alkemy.disney.dto.PeliculaDTO;
import alkemy.disney.dto.PersonajeDT0;
import alkemy.disney.entity.PeliculaEntity;
import alkemy.disney.entity.PersonajeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class PeliculaMapper {

    @Autowired
    private PersonajeMapper personajeMapper;

    public PeliculaEntity peliculaDTO2Entity(PeliculaDTO peliculaDTO, boolean loadPersonajes) {

        PeliculaEntity peliculaEntity = new PeliculaEntity();
        if(peliculaDTO.getId()!=null){
            peliculaEntity.setId(peliculaDTO.getId());
        }
        peliculaEntity.setImagen(peliculaDTO.getImagen());
        peliculaEntity.setTitulo(peliculaDTO.getTitulo());
        peliculaEntity.setFechaCreacion(peliculaDTO.getFechaCreacion());
        peliculaEntity.setCalificacion(peliculaDTO.getCalificacion());
        peliculaEntity.setGeneroId(peliculaDTO.getGeneroId());
        if(loadPersonajes){
            Set<PersonajeDT0> dtoSet = peliculaDTO.getPersonajes();
            Set<PersonajeEntity> personajeEntitySet =  personajeMapper.dtoSet2EntitySet(dtoSet,false);
            peliculaEntity.setPersonajes(personajeEntitySet);
        }
        return peliculaEntity;
    }

    public PeliculaDTO peliculaEntity2DTO(PeliculaEntity peliculaEntity, boolean b) {
        PeliculaDTO peliculaDTO = new PeliculaDTO();
        peliculaDTO.setId(peliculaEntity.getId());
        peliculaDTO.setImagen(peliculaEntity.getImagen());
        peliculaDTO.setTitulo(peliculaEntity.getTitulo());
        peliculaDTO.setFechaCreacion(peliculaEntity.getFechaCreacion());
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

    public List<PeliculaBasicDTO> peliculaEntitySet2BasicDTOSet(List<PeliculaEntity> peliculaEntities){
        List<PeliculaBasicDTO> dtos = new ArrayList<>();
        for (PeliculaEntity entity : peliculaEntities){
            dtos.add(peliculaEntity2BasicDTO(entity));
        }
        return dtos;
    }

    public List<PeliculaDTO> entitySet2DtoList(List<PeliculaEntity> entities, boolean loadPersonajes) {
        List<PeliculaDTO> peliculaDTOS = new ArrayList<>();
        for (PeliculaEntity entity : entities){
            peliculaDTOS.add(peliculaEntity2DTO(entity,loadPersonajes));
        }
        return peliculaDTOS;
    }

    public Set<PeliculaEntity> dtoSet2EntitySet(Set<PeliculaDTO> dtoSet, boolean loadPersonajes) {
        Set<PeliculaEntity> entitySet = new HashSet<>();
        for (PeliculaDTO dto : dtoSet){
            entitySet.add(this.peliculaDTO2Entity(dto,loadPersonajes));
        }
        return entitySet;
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
