package waag.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import waag.domain.entidades.Compvend;

public interface CompvendRepository extends PagingAndSortingRepository<Compvend, Integer> {
	
	Page<Compvend> findAllByOrderByClienteAsc(Pageable pageable);
	
	Iterable<Compvend> findAllByOrderByClienteAsc();
}
