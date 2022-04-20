package alkemy.disney.repository.specification;

import alkemy.disney.dto.PeliculaFiltersDTO;
import alkemy.disney.entity.PeliculaEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Component
public class PeliculaSpec {

    public Specification<PeliculaEntity> getByFilters(PeliculaFiltersDTO filtersDTO){
        return ((root, criteriaQuery, criteriaBuilder) -> {

            List<Predicate> predicates = new ArrayList<>();

            if (StringUtils.hasLength(filtersDTO.getTitulo())){

                predicates.add(
                        criteriaBuilder.like(
                                criteriaBuilder.lower(root.get("titulo")),
                                "%" + filtersDTO.getTitulo().toLowerCase() + "%"
                        )
                );

                predicates.add(
                        criteriaBuilder.like(
                                criteriaBuilder.lower(root.get("genero id")),
                                "%" + filtersDTO.getGeneroId() + "%"
                        )
                );
            }
        criteriaQuery.distinct(true);
            String orderByField = "titulo";
            criteriaQuery.orderBy(
                    filtersDTO.isASC() ?
                            criteriaBuilder.asc(root.get(orderByField)) :
                            criteriaBuilder.desc(root.get(orderByField))
            );
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });

    }


}
