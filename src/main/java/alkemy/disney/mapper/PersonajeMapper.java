package alkemy.disney.mapper;

import alkemy.disney.dto.PeliculaBasicDTO;
import alkemy.disney.dto.PeliculaDTO;
import alkemy.disney.dto.PersonajeDT0;
import alkemy.disney.entity.PeliculaEntity;
import alkemy.disney.entity.PersonajeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class PersonajeMapper {

    @Autowired
    private PeliculaMapper peliculaMapper;

    @Autowired
    private PersonajeMapper personajeMapper;

    public PersonajeEntity personajeDTO2Entity(PersonajeDT0 personajeDT0, boolean loadPeliculas) {

        PersonajeEntity personajeEntity = new PersonajeEntity();
        if(personajeDT0.getId()!=null){
            personajeEntity.setId(personajeDT0.getId());
        }
        personajeEntity.setImagen(personajeDT0.getImagen());
        personajeEntity.setNombre(personajeDT0.getNombre());
        personajeEntity.setEdad(personajeDT0.getEdad());
        personajeEntity.setPeso(personajeDT0.getPeso());
        personajeEntity.setHistoria(personajeDT0.getHistoria());
        if(loadPeliculas){
            Set<PeliculaDTO> dtoSet = personajeDT0.getPeliculas();
            Set<PeliculaEntity> peliculaEntities = peliculaMapper.dtoSet2EntitySet(dtoSet, false);
            personajeEntity.setPeliculas(peliculaEntities);
        }
        return personajeEntity;
    }

    public PersonajeDT0 personajeEntity2DTO(PersonajeEntity personajeEntity, boolean loadPeliculas){

        PersonajeDT0 personajeDT0 = new PersonajeDT0();
        personajeDT0.setId(personajeEntity.getId());
        personajeDT0.setImagen(personajeEntity.getImagen());
        personajeDT0.setNombre(personajeEntity.getNombre());
        personajeDT0.setEdad(personajeEntity.getEdad());
        personajeDT0.setPeso(personajeEntity.getPeso());
        personajeDT0.setHistoria(personajeEntity.getHistoria());
        return personajeDT0;
    }

    public Set<PersonajeEntity> dtoSet2EntitySet(Set<PersonajeDT0> dtoSet, boolean loadPeliculas) {
        Set<PersonajeEntity> entitySet = new HashSet<>();
        for (PersonajeDT0 dto : dtoSet){
            entitySet.add(this.personajeDTO2Entity(dto,loadPeliculas));
        }
        return entitySet;
    }
}

