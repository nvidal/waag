package waag.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import waag.domain.entidades.Destino;

public interface DestinoRepository extends PagingAndSortingRepository<Destino, Integer> {
}
