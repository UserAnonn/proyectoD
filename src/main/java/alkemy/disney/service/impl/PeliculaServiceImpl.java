package alkemy.disney.service.impl;

import alkemy.disney.dto.GeneroDTO;
import alkemy.disney.dto.PeliculaBasicDTO;
import alkemy.disney.dto.PeliculaDTO;
import alkemy.disney.entity.GeneroEntity;
import alkemy.disney.entity.PeliculaEntity;
import alkemy.disney.mapper.PeliculaMapper;
import alkemy.disney.repository.IPeliculaRepository;
import alkemy.disney.service.IPeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeliculaServiceImpl implements IPeliculaService {


    @Autowired
    public IPeliculaRepository iPeliculaRepository;

    @Autowired
    public PeliculaMapper mapper;

    public PeliculaDTO save(PeliculaDTO peliculaDTO) {

        PeliculaEntity peliculaEntity = mapper.peliculaDTO2Entity(peliculaDTO);
        PeliculaEntity peliculaGuardada = iPeliculaRepository.save(peliculaEntity);
        PeliculaDTO result = mapper.peliculaEntity2DTO(peliculaGuardada, false);
        return result;
    }

    public void delete(Long id) {
        iPeliculaRepository.deleteById(id);
    }

    @Override
    public PeliculaDTO update(Long id, PeliculaDTO peliculaDTO) {
        PeliculaEntity peliculaEntity = this.findById(id);
        mapper.updateValues(peliculaEntity,peliculaDTO);
        return mapper.peliculaEntity2DTO(iPeliculaRepository.save(peliculaEntity), false);
    }

    @Override
    public PeliculaEntity findById(Long id){
        Optional<PeliculaEntity> optional = iPeliculaRepository.findById(id);
        if(!optional.isPresent()){
            throw new ParamNotFound("Movie id is not valid");
        }
        return optional.get();
    }

    public List<PeliculaBasicDTO> getAll() {
        List<PeliculaEntity> peliculaEntities = iPeliculaRepository.findAll();
        List<PeliculaBasicDTO> result = mapper.peliculaEntitySet2DTOSet(peliculaEntities);
        return result;
    }

}
