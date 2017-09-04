package waag.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import waag.domain.entidades.Bulto;

public interface BultoRepository extends PagingAndSortingRepository<Bulto, Integer> {
	
	Page<Bulto> findAllByOrderByTipoAsc(Pageable pageable);
	
	Iterable<Bulto> findAllByOrderByTipoAsc();
}
