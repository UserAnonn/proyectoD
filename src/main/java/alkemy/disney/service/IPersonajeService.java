package alkemy.disney.service;

import alkemy.disney.dto.PersonajeDT0;
import alkemy.disney.entity.PersonajeEntity;

public interface IPersonajeService {

    PersonajeDT0 save(PersonajeDT0 personajeDT0);

    PersonajeEntity findById(Long idPersonaje);

}
