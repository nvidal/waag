package waag.services;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import waag.domain.entidades.Facturas;
import waag.repositories.FacturasRepository;

@Service
public class FacturaServiceImpl implements FacturaService {

	private static final Log LOG = LogFactory.getLog(FacturaServiceImpl.class);

	@Autowired
	private FacturasRepository facturaRepository;

	@Override
	public Iterable<Facturas> listAllFacturas() {
		LOG.info("listAllFacturas");
		return facturaRepository.findAll();
	}

	@Override
	public Facturas getFacturaById(Integer id) {
		return facturaRepository.findOne(id);
	}

	@Override
	public Facturas saveFactura(Facturas factura) {
		return facturaRepository.save(factura);
	}

	@Override
	public void deleteFactura(Integer id) {
		facturaRepository.delete(id);
	}

	@Override
	public Page<Facturas> getFacturasByPages(Pageable pageable) {
		LOG.info("getFacturasByPages");
		return facturaRepository.findAll(pageable);
	}
}
