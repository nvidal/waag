package waag.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import waag.domain.entidades.Buque;

public interface BuqueRepository extends PagingAndSortingRepository<Buque, Integer> {
	
	public Page<Buque> findAllByOrderByNombreAsc(Pageable pageable);
	public Iterable<Buque> findAllByOrderByNombreAsc();
}
