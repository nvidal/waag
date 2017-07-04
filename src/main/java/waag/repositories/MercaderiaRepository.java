package waag.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import waag.domain.entidades.Buque;
import waag.domain.entidades.Mercaderia;

public interface MercaderiaRepository extends PagingAndSortingRepository<Mercaderia, Integer> {
}
