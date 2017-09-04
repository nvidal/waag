package waag.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import waag.domain.entidades.Operacion;

public interface OperacionRepository extends PagingAndSortingRepository<Operacion, Integer> {
	
	Page<Operacion> findAllByOrderByOperacionAsc(Pageable pageable);
	
	Iterable<Operacion> findAllByOrderByOperacionAsc();
}
