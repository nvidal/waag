package waag.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import waag.domain.entidades.Bulto;

public interface BultoRepository extends PagingAndSortingRepository<Bulto, Integer> {
}
