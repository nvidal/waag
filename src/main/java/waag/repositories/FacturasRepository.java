package waag.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import waag.domain.entidades.Facturas;

public interface FacturasRepository extends PagingAndSortingRepository<Facturas, Integer> {
}
