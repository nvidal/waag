package waag.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import waag.domain.entidades.Facturas;

public interface FacturaService {
	Iterable<Facturas> listAllFacturas();

	Facturas getFacturaById(Integer id);

	Facturas saveFactura(Facturas factura);

	void deleteFactura(Integer id);

	Page<Facturas> getFacturasByPages(Pageable pageable);
}
