package alkemy.disney.service;

import alkemy.disney.dto.GeneroDTO;

import java.util.List;
import java.util.Set;

public interface IGeneroService {

    GeneroDTO save(GeneroDTO generoDTO);

    List<GeneroDTO> getAllGeneros();
}
