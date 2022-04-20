package alkemy.disney.repository;

import alkemy.disney.entity.GeneroEntity;
import alkemy.disney.entity.PeliculaEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface IPeliculaRepository extends JpaRepository<PeliculaEntity, Long>, JpaSpecificationExecutor<PeliculaEntity> {

        List<PeliculaEntity> findAll(Specification<PeliculaEntity> specification);
}
