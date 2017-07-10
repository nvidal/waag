package waag.components;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import waag.domain.entidades.Factura;
import waag.domain.model.FacturaModel;

@Component("facturaConverter")
public class FacturaConverter implements Converter<Factura, FacturaModel>{

	public Factura convertFacturaModelToFactura(FacturaModel model){
		Factura factura = new Factura();
		if(model != null){
			factura.setId(model.getId());
			factura.setFacturaNro(model.getFacturaNro());
			factura.setFecha(model.getFecha());
			factura.setCliente(model.getCliente());
			factura.setOperacion(model.getOperacion());
			factura.setCompvend(model.getCompvend());
		}
		
		return factura;
	}
	
	public FacturaModel convertFacturaToFacturaModel(Factura factura){
		FacturaModel model = new FacturaModel();
		if(factura != null){
			model.setId(factura.getId());
			model.setFacturaNro(factura.getFacturaNro());
			model.setFecha(factura.getFecha());
			model.setCliente(factura.getCliente());
			model.setOperacion(factura.getOperacion());
			model.setCompvend(factura.getCompvend());
		}
		
		return model;
	}

	@Override
	public FacturaModel convert(Factura factura) {
		return convertFacturaToFacturaModel(factura);
	}
}
