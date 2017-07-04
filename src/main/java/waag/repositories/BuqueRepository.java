package waag.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import waag.domain.entidades.Buque;

public interface BuqueRepository extends PagingAndSortingRepository<Buque, Integer> {
}
