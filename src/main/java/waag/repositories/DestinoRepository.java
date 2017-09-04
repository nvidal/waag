package waag.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import waag.domain.entidades.Destino;

public interface DestinoRepository extends PagingAndSortingRepository<Destino, Integer> {
	
	Page<Destino> findAllByOrderByCiudadAsc(Pageable pageable);
	
	Iterable<Destino> findAllByOrderByCiudadAsc();
}
