package alkemy.disney.service.impl;

import alkemy.disney.dto.PeliculaBasicDTO;
import alkemy.disney.dto.PeliculaDTO;
import alkemy.disney.dto.PersonajeBasicDTO;
import alkemy.disney.dto.PersonajeDT0;
import alkemy.disney.entity.PeliculaEntity;
import alkemy.disney.entity.PersonajeEntity;
import alkemy.disney.exception.ParamNotFound;
import alkemy.disney.mapper.PersonajeMapper;
import alkemy.disney.repository.IPersonajeRepository;
import alkemy.disney.service.IPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public List<PersonajeBasicDTO> getAll(){
        List<PersonajeEntity> peliculaEntities = iPersonajeRepository.findAll();
        List<PersonajeBasicDTO> result = personajeMapper.personajeEntitySet2BasicDTOSet(peliculaEntities);
        return result;
    }

    public PersonajeEntity findById(Long idPersonaje) {
        Optional<PersonajeEntity> optional = iPersonajeRepository.findById(idPersonaje);
        if(!optional.isPresent()){
            throw new ParamNotFound("Character id is not valid");
        }
        PersonajeDT0 personajeDT0 = this.personajeMapper.personajeEntity2DTO(optional.get(), true);
        return optional.get();
    }

    public PersonajeDT0 update(Long id, PersonajeDT0 personajeDT0) {
        PersonajeEntity personajeEntity = this.findById(id);
        personajeMapper.updateValues(personajeEntity, personajeDT0);
        return personajeMapper.personajeEntity2DTO(iPersonajeRepository.save(personajeEntity), false);
    }

    public void delete(Long id) {
        iPersonajeRepository.deleteById(id);
    }

}

