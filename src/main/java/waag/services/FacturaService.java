package waag.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import waag.domain.model.FacturaModel;
import waag.exceptions.SaveWaagException;

public interface FacturaService {
	Iterable<FacturaModel> listAllFacturas();

	FacturaModel getFacturaById(Integer id);

	FacturaModel saveFactura(FacturaModel factura) throws SaveWaagException;

	boolean deleteFactura(Integer id);

	Page<FacturaModel> getFacturasByPages(Pageable pageable);
}
