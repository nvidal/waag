package waag.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import waag.domain.entidades.Buque;
import waag.domain.entidades.Estado;

public interface EstadoRepository extends PagingAndSortingRepository<Estado, Integer> {
}
