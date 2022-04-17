package alkemy.disney.repository;

import alkemy.disney.entity.GeneroEntity;
import alkemy.disney.entity.PeliculaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPeliculaRepository extends JpaRepository<PeliculaEntity, Long> {

}
