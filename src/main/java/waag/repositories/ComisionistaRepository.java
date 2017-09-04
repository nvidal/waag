package waag.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import waag.domain.entidades.Comisionista;

public interface ComisionistaRepository extends PagingAndSortingRepository<Comisionista, Integer> {
	
	Page<Comisionista> findAllByOrderByComisionistaAsc(Pageable pageable);
	
	Iterable<Comisionista> findAllByOrderByComisionistaAsc();
}
