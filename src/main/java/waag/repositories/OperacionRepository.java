package waag.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import waag.domain.entidades.Buque;

public interface OperacionRepository extends PagingAndSortingRepository<Buque, Integer> {
}
