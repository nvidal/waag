package waag.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import waag.controllers.utils.Pager;
import waag.domain.entidades.Facturas;
import waag.services.CRUDService;
import waag.services.FacturaService;

@Controller
public class FacturaController {

	private static final int PAGE_SIZE = 10;
	private static final int BUTTONS_TO_SHOW = 5;

	private FacturaService facturaService;
	private CRUDService crudService;

	@Autowired
	public void setFacturaService(FacturaService facturaService) {
		this.facturaService = facturaService;
	}

	@Autowired
	public void setCrudService(CRUDService crudService) {
		this.crudService = crudService;
	}

	@RequestMapping(value = "/facturas", method = RequestMethod.GET)
	public String list(Model model) {
		Page<Facturas> pages = facturaService.getFacturasByPages(new PageRequest(0, PAGE_SIZE));
		Pager pager = new Pager(pages.getTotalPages(), pages.getNumber(), BUTTONS_TO_SHOW);

		model.addAttribute("facturas", pages);
		model.addAttribute("pager", pager);
		return "facturas";
	}

	@RequestMapping(value = "/facturas/{page}", method = RequestMethod.GET)
	public String list(@PathVariable Integer page, Model model) {
		page = page == null || page < 1 ? 0 : page - 1;
		Page<Facturas> pages = facturaService.getFacturasByPages(new PageRequest(page, PAGE_SIZE));
		Pager pager = new Pager(pages.getTotalPages(), pages.getNumber(), BUTTONS_TO_SHOW);

		model.addAttribute("facturas", pages);
		model.addAttribute("pager", pager);
		return "facturas";
	}

	// @RequestMapping("factura/{id}")
	// public String showFactura(@PathVariable Integer id, Model model){
	// model.addAttribute("factura", facturaService.getFacturaById(id));
	// return "verFactura";
	// }

	@RequestMapping("factura/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		model.addAttribute("modo", "edicion");
		model.addAttribute("clientes", crudService.listAllClientes());
		model.addAttribute("factura", facturaService.getFacturaById(id));
		return "formFactura";
	}

	@RequestMapping("factura/new")
	public String newFactura(Model model) {
		model.addAttribute("modo", "alta");
		model.addAttribute("clientes", crudService.listAllClientes());
		model.addAttribute("factura", new Facturas());
		return "formFactura";
	}

	@RequestMapping(value = "factura", method = RequestMethod.POST)
	public String saveFactura(@Valid Facturas factura) {
		System.err.println("ACA");
		facturaService.saveFactura(factura);
		return "redirect:/factura/" + factura.getId();
	}

	@RequestMapping("factura/delete/{id}")
	public String delete(@PathVariable Integer id) {
		facturaService.deleteFactura(id);
		return "redirect:/facturas";
	}

	

}
