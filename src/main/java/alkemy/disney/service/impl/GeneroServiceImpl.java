package alkemy.disney.service.impl;

import alkemy.disney.dto.GeneroDTO;
import alkemy.disney.entity.GeneroEntity;
import alkemy.disney.mapper.GeneroMapper;
import alkemy.disney.repository.IGeneroRepository;
import alkemy.disney.service.IGeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class GeneroServiceImpl implements IGeneroService {

    @Autowired
    public GeneroMapper generoMapper;

    @Autowired
    public IGeneroRepository iGeneroRepository;

    public GeneroDTO save(GeneroDTO generoDTO){

        GeneroEntity generoEntity = generoMapper.generoDTO2Entity(generoDTO); //convierto el dto a entity
        GeneroEntity generoSaved = iGeneroRepository.save(generoEntity); //la guardo a la entidad
        GeneroDTO result = generoMapper.generoEntity2DTO(generoSaved); //a ella la convierto en dto
        return result; //devuelvo ese dto
    }

    public List<GeneroDTO> getAllGeneros() {
        List<GeneroEntity> generoEntitySet = iGeneroRepository.findAll();
        List<GeneroDTO> result = generoMapper.generoEntitySet2DTOSet(generoEntitySet);
        return result;
    }
}
