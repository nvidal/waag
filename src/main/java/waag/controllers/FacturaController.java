package waag.controllers;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import waag.constants.ViewConstant;
import waag.controllers.utils.Pager;
import waag.domain.model.FacturaModel;
import waag.exceptions.SaveWaagException;
import waag.services.CRUDService;
import waag.services.FacturaService;

@Controller
public class FacturaController {

	private static final Log LOG = LogFactory.getLog(FacturaController.class);
	private static final int PAGE_SIZE = 10;
	private static final int BUTTONS_TO_SHOW = 5;

	@Autowired
	private FacturaService facturaService;
	@Autowired
	private CRUDService crudService;


	@RequestMapping(value = "/facturas", method = RequestMethod.GET)
	public String list(Model model) {
		Page<FacturaModel> pages = facturaService.getFacturasByPages(new PageRequest(0, PAGE_SIZE));
		Pager pager = new Pager(pages.getTotalPages(), pages.getNumber(), BUTTONS_TO_SHOW);

		model.addAttribute("facturas", pages);
		model.addAttribute("pager", pager);
		model.addAttribute("activeTab", "facturas");
		return ViewConstant.LIST_FACTURAS;
	}

	@RequestMapping(value = "/facturas/{page}", method = RequestMethod.GET)
	public String list(@PathVariable Integer page, Model model) {
		page = page == null || page < 1 ? 0 : page - 1;
		Page<FacturaModel> pages = facturaService.getFacturasByPages(new PageRequest(page, PAGE_SIZE));
		Pager pager = new Pager(pages.getTotalPages(), pages.getNumber(), BUTTONS_TO_SHOW);

		model.addAttribute("facturas", pages);
		model.addAttribute("pager", pager);
		model.addAttribute("activeTab", "facturas");
		return ViewConstant.LIST_FACTURAS;
	}

	// @RequestMapping("factura/{id}")
	// public String showFactura(@PathVariable Integer id, Model model){
	// model.addAttribute("factura", facturaService.getFacturaById(id));
	// return "verFactura";
	// }

	@RequestMapping("factura/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		model.addAttribute("modo", "edicion");
		model.addAttribute("factura", facturaService.getFacturaById(id));
		cargarValores(model);
		model.addAttribute("activeTab", "formfactura");
		return ViewConstant.FORM_FACTURAS;
	}

	@RequestMapping("factura/ingresar")
	public String newFactura(Model model) {
		model.addAttribute("modo", "alta");
		cargarValores(model);
		model.addAttribute("factura", new FacturaModel());
		model.addAttribute("activeTab", "formfactura");
		return ViewConstant.FORM_FACTURAS;
	}
	
	private void cargarValores(Model model){
		model.addAttribute("clientes", crudService.listAllClientes());
		model.addAttribute("compvends", crudService.listAllCompvends());
		model.addAttribute("operaciones", crudService.listAllOperaciones());
	}

	@RequestMapping(value = "factura", method = RequestMethod.POST)
	public String saveFactura(@Valid @ModelAttribute("factura") FacturaModel factura, BindingResult bindingResult, Model model) {
		LOG.info("POST /factura : "+factura.getFacturaNro());
		if(bindingResult.hasErrors()){
			LOG.error("Errores al validar Factura");
			for(ObjectError o : bindingResult.getAllErrors()){
				LOG.error("> "+o.getObjectName() +" "+o.getDefaultMessage());
			}
			model.addAttribute("modo", "alta");
			model.addAttribute("activeTab", "formfactura");
		}
		else{
			try{
				boolean alta = factura.getId() == null;
				factura = facturaService.saveFactura(factura);
				model.addAttribute("resultado", 1);
				model.addAttribute("factura", factura);
				model.addAttribute("modo", "edicion");
				if(alta){
					model.addAttribute("resMsj", "Factura agregada con éxito.");
				}
				else{
					model.addAttribute("resMsj", "Factura modificada con éxito.");
				}
			}catch(SaveWaagException ex){
				model.addAttribute("resultado", 0);
				model.addAttribute("resMsj", ex.getMessage());
				if (factura.getId()==null){
					model.addAttribute("modo", "alta");
				}
			}
		}
		
		model.addAttribute("activeTab", "formfactura");
		cargarValores(model);
		return ViewConstant.FORM_FACTURAS;
	}

	@RequestMapping("factura/delete/{id}")
	public String delete(@PathVariable Integer id) {
		facturaService.deleteFactura(id);
		return "redirect:/facturas";
	}

	

}
