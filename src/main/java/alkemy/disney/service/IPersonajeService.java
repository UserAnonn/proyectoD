package alkemy.disney.service;

import alkemy.disney.dto.PeliculaBasicDTO;
import alkemy.disney.dto.PeliculaDTO;
import alkemy.disney.dto.PersonajeBasicDTO;
import alkemy.disney.dto.PersonajeDT0;
import alkemy.disney.entity.PersonajeEntity;

import java.util.List;

public interface IPersonajeService {

    PersonajeDT0 save(PersonajeDT0 personajeDT0);

    PersonajeEntity findById(Long idPersonaje);

    List<PersonajeBasicDTO> getAll();

    PersonajeDT0 update(Long id, PersonajeDT0 personajeDT0);

    void delete(Long id);
}
