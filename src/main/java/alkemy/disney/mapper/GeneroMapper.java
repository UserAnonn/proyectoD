package alkemy.disney.mapper;

import alkemy.disney.dto.GeneroDTO;
import alkemy.disney.entity.GeneroEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class GeneroMapper {

    public GeneroEntity generoDTO2Entity(GeneroDTO generoDTO){

        GeneroEntity generoEntity = new GeneroEntity();
        generoEntity.setImagen(generoDTO.getImagen());
        generoEntity.setNombre(generoDTO.getNombre());
        return generoEntity;
    }

    public GeneroDTO generoEntity2DTO(GeneroEntity generoEntity){
        GeneroDTO generoDTO = new GeneroDTO();
        generoDTO.setId(generoEntity.getId());
        generoDTO.setImagen(generoEntity.getImagen());
        generoDTO.setNombre(generoEntity.getNombre());
        return generoDTO;
    }

    public List<GeneroDTO> generoEntitySet2DTOSet(List<GeneroEntity> generoEntitySet){
        List<GeneroDTO> dtos = new ArrayList<>();
        for (GeneroEntity entity : generoEntitySet){
            dtos.add(generoEntity2DTO(entity));
        }
        return dtos;
    }
}
