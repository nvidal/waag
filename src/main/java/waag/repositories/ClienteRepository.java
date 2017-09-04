package waag.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import waag.domain.entidades.Cliente;

public interface ClienteRepository extends PagingAndSortingRepository<Cliente, Integer> {
	
	public Page<Cliente> findAllByOrderByExportadorAsc(Pageable pageable);
	public Iterable<Cliente> findAllByOrderByExportadorAsc();
}
