package waag.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import waag.domain.entidades.Buque;

public interface MarcaRepository extends PagingAndSortingRepository<Buque, Integer> {
}
