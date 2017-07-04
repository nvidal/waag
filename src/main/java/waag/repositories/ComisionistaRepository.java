package waag.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import waag.domain.entidades.Comisionista;

public interface ComisionistaRepository extends PagingAndSortingRepository<Comisionista, Integer> {
}
