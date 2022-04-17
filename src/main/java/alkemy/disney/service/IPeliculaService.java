package alkemy.disney.service;

import alkemy.disney.dto.PeliculaBasicDTO;
import alkemy.disney.dto.PeliculaDTO;
import alkemy.disney.entity.PeliculaEntity;

import java.util.List;
import java.util.Optional;

public interface IPeliculaService {

    PeliculaDTO save(PeliculaDTO peliculaDTO);

    void delete(Long id);

    PeliculaDTO update(Long id, PeliculaDTO peliculaDTO);

    PeliculaEntity findById(Long id);

    List<PeliculaBasicDTO> getAll();

}
