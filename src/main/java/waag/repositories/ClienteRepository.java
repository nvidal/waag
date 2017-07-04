package waag.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import waag.domain.entidades.Cliente;

public interface ClienteRepository extends PagingAndSortingRepository<Cliente, Integer> {
}
