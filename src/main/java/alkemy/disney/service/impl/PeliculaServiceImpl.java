package alkemy.disney.service.impl;

import alkemy.disney.dto.PeliculaBasicDTO;
import alkemy.disney.dto.PeliculaDTO;
import alkemy.disney.dto.PeliculaFiltersDTO;
import alkemy.disney.entity.PeliculaEntity;
import alkemy.disney.entity.PersonajeEntity;
import alkemy.disney.exception.ParamNotFound;
import alkemy.disney.mapper.PeliculaMapper;
import alkemy.disney.repository.IPeliculaRepository;
import alkemy.disney.repository.specification.PeliculaSpec;
import alkemy.disney.service.IPeliculaService;
import alkemy.disney.service.IPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PeliculaServiceImpl implements IPeliculaService {


    @Autowired
    public IPeliculaRepository iPeliculaRepository;

    @Autowired
    public PeliculaMapper mapper;

    @Autowired
    public IPersonajeService iPersonajeService;

    @Autowired
    public PeliculaSpec peliculaSpec;

    @Autowired
    public PeliculaServiceImpl(
            IPeliculaRepository iPeliculaRepository,
            PeliculaSpec peliculaSpec,
            PeliculaMapper mapper,
            IPersonajeService iPersonajeService){

        this.iPeliculaRepository = iPeliculaRepository;
        this.peliculaSpec = peliculaSpec;
        this.mapper = mapper;
        this.iPersonajeService = iPersonajeService;
    }

    public PeliculaDTO save(PeliculaDTO peliculaDTO) {

        PeliculaEntity peliculaEntity = mapper.peliculaDTO2Entity(peliculaDTO, true);
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
        mapper.updateValues(peliculaEntity, peliculaDTO);
        return mapper.peliculaEntity2DTO(iPeliculaRepository.save(peliculaEntity), false);
    }

    public PeliculaEntity findById(Long id) {
        Optional<PeliculaEntity> optional = iPeliculaRepository.findById(id);
        if (!optional.isPresent()) {
            throw new ParamNotFound("Movie id is not valid");
        }
        PeliculaDTO peliculaDTO = this.mapper.peliculaEntity2DTO(optional.get(), true);
        return optional.get();
    }

    public List<PeliculaDTO> getDetailsByFilters(String titulo, Long generoId, String orden) {
        PeliculaFiltersDTO filtersDTO = new PeliculaFiltersDTO(titulo, generoId, orden);
        List<PeliculaEntity> entities = this.iPeliculaRepository.findAll(this.peliculaSpec.getByFilters(filtersDTO));
        List<PeliculaDTO> dtos = this.mapper.entitySet2DtoList(entities, true);
        return dtos;
    }

    public List<PeliculaBasicDTO> getAll() {
        List<PeliculaEntity> peliculaEntities = iPeliculaRepository.findAll();
        List<PeliculaBasicDTO> result = mapper.peliculaEntitySet2BasicDTOSet(peliculaEntities);
        return result;
    }

    public List<PeliculaDTO> getAllData() {
        List<PeliculaEntity> peliculaEntities = iPeliculaRepository.findAll();
        List<PeliculaDTO> result = mapper.entitySet2DtoList(peliculaEntities, true);
        return result;
    }

    public PeliculaDTO addPersonaje2Pelicula(Long idPelicula, Long idPersonaje) {
        PeliculaEntity peliculaEntity = this.findById(idPelicula);
        Set<PersonajeEntity> personajeEntitySet = peliculaEntity.getPersonajes();
        personajeEntitySet.add(iPersonajeService.findById(idPersonaje));
        peliculaEntity.setPersonajes(personajeEntitySet);
        return mapper.peliculaEntity2DTO(iPeliculaRepository.save(peliculaEntity), true);
    }

    public PeliculaDTO getDetails(Long id){
        PeliculaEntity peliculaEntity = this.findById(id);
        return mapper.peliculaEntity2DTO(peliculaEntity, true);
    }
}