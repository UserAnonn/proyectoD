package alkemy.disney.repository;

import alkemy.disney.entity.GeneroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGeneroRepository extends JpaRepository<GeneroEntity, Long> {
}
