package waag.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import waag.domain.entidades.Buque;
import waag.domain.entidades.Unidadcomercial;

public interface UnidadcomercialRepository extends PagingAndSortingRepository<Unidadcomercial, Integer> {
}
