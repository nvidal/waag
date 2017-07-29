package waag.controllers;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import waag.domain.entidades.Factura;
import waag.services.FacturaService;

@Controller
public class IndexController {

	private static final Log LOG = LogFactory.getLog(IndexController.class);
	
	@Autowired
	private FacturaService facturaService;
	
	@RequestMapping("/")
	public String index(Model model) {
		
		List<Factura> facturas = facturaService.getUltimasFacturas();
		model.addAttribute("activeTab", "inicio");
		model.addAttribute("facturas", facturas);
		return "index";
	}
}