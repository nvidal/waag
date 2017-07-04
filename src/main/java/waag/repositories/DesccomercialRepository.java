package waag.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import waag.domain.entidades.Buque;
import waag.domain.entidades.Desccomercial;

public interface DesccomercialRepository extends PagingAndSortingRepository<Desccomercial, Integer> {
}
