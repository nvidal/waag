package waag.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import waag.domain.entidades.Buque;
import waag.domain.entidades.Compvend;

public interface CompvendRepository extends PagingAndSortingRepository<Compvend, Integer> {
}
