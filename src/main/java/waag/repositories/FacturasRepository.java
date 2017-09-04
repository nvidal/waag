package waag.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import waag.domain.entidades.Factura;

public interface FacturasRepository extends PagingAndSortingRepository<Factura, Integer> {
	
	public List<Factura> findTop10ByOrderByFechaDesc();
	
	public Page<Factura> findAllByOrderByFechaDesc(Pageable pageable);
	
	public Iterable<Factura> findAllByOrderByFechaDesc();
}
