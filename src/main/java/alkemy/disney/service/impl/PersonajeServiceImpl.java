package alkemy.disney.service.impl;

import alkemy.disney.dto.PersonajeDT0;
import alkemy.disney.entity.PersonajeEntity;
import alkemy.disney.exception.ParamNotFound;
import alkemy.disney.mapper.PersonajeMapper;
import alkemy.disney.repository.IPersonajeRepository;
import alkemy.disney.service.IPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonajeServiceImpl implements IPersonajeService {

    @Autowired
    private IPersonajeRepository iPersonajeRepository;

    @Autowired
    private PersonajeMapper personajeMapper;

    public PersonajeDT0 save(PersonajeDT0 personajeDT0) {
        PersonajeEntity personajeEntity = personajeMapper.personajeDTO2Entity(personajeDT0, true);
        PersonajeEntity personaje = iPersonajeRepository.save(personajeEntity);
        PersonajeDT0 resutl = personajeMapper.personajeEntity2DTO(personajeEntity, false);
        return resutl;
    }

    public PersonajeEntity findById(Long idPersonaje) {
        Optional<PersonajeEntity> optional = iPersonajeRepository.findById(idPersonaje);
        if(!optional.isPresent()){
            throw new ParamNotFound("Character id is not valid");
        }
        return optional.get();
    }
}

