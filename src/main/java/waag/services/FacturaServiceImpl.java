package waag.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import waag.components.FacturaConverter;
import waag.domain.entidades.Factura;
import waag.domain.model.FacturaModel;
import waag.exceptions.SaveWaagException;
import waag.repositories.FacturasRepository;

@Service
public class FacturaServiceImpl implements FacturaService {

	private static final Log LOG = LogFactory.getLog(FacturaServiceImpl.class);

	@Autowired
	private FacturasRepository facturaRepository;
	@Autowired
	private FacturaConverter facturaConverter;

	@Override
	public Iterable<FacturaModel> listAllFacturas() {
		LOG.info("listAllFacturas");
		Iterable<Factura> facturas = facturaRepository.findAll();
		List<FacturaModel> models = new ArrayList<FacturaModel>();
		for(Factura f : facturas){
			models.add(facturaConverter.convertFacturaToFacturaModel(f));
		}
		return models;
	}

	@Override
	public FacturaModel getFacturaById(Integer id) {
		return facturaConverter.convertFacturaToFacturaModel(facturaRepository.findOne(id));
	}

	@Override
	public FacturaModel saveFactura(FacturaModel model) throws SaveWaagException{
		Factura factura = null;
		try{
			factura = facturaRepository.save(facturaConverter.convertFacturaModelToFactura(model));
		}catch(ConstraintViolationException ex){
			LOG.error("Ocurrió un error al grabar: "+ex.getMessage()+ " "+ex.getCause());
			throw new SaveWaagException("Ya existe una factura con ese Nro Factura: "+ex.getMessage());
		}
		catch(Exception ex){
			LOG.error("Ocurrió un error al grabar: "+ex.getMessage()+ " "+ex.getCause());
			throw new SaveWaagException("Ocurrió un error al grabar: "+ex.getMessage());
		}
		return facturaConverter.convertFacturaToFacturaModel(factura);
	}

	@Override
	public boolean deleteFactura(Integer id) {
		facturaRepository.delete(id);
		if (facturaRepository.findOne(id)==null)
			return true;
		else
			return false;
	}

	@Override
	public Page<FacturaModel> getFacturasByPages(Pageable pageable) {
		LOG.info("getFacturasByPages");
		Page<Factura> facturas = facturaRepository.findAll(pageable);
		Page<FacturaModel> models = facturas.map(facturaConverter);
		return models;
	}
}
