package waag.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import waag.domain.entidades.Buque;

public interface CompvendRepository extends PagingAndSortingRepository<Buque, Integer> {
}
