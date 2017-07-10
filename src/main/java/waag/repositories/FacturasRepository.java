package waag.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import waag.domain.entidades.Factura;

public interface FacturasRepository extends PagingAndSortingRepository<Factura, Integer> {
}
