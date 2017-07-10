package waag.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import waag.domain.entidades.Buque;
import waag.domain.entidades.Operacion;

public interface OperacionRepository extends PagingAndSortingRepository<Operacion, Integer> {
}
