package waag.controllers;

import java.util.Date;

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
import waag.domain.entidades.Bulto;
import waag.domain.entidades.Buque;
import waag.domain.entidades.Cliente;
import waag.domain.entidades.Comisionista;
import waag.domain.entidades.Destino;
import waag.domain.entidades.Factura;
import waag.domain.model.FacturaModel;
import waag.services.CRUDService;

@Controller
public class CRUDController {

	private static final Log LOG = LogFactory.getLog(CRUDController.class);
	
	private static final int PAGE_SIZE = 10;
	private static final int BUTTONS_TO_SHOW = 5;

	@Autowired
	private CRUDService crudService;

	// +++ DESTINO +++
	@RequestMapping(value = "/destinos", method = RequestMethod.GET)
	public String listDestinos(Model model) {
		Page<Destino> pages = crudService.listAllDestinosByPage(new PageRequest(0, PAGE_SIZE));
		Pager pager = new Pager(pages.getTotalPages(), pages.getNumber(), BUTTONS_TO_SHOW);

		model.addAttribute("destinos", pages);
		model.addAttribute("pager", pager);
		model.addAttribute("destino", new Destino());
		return ViewConstant.DESTINOS;
	}
	@RequestMapping(value = "/destinos/{page}", method = RequestMethod.GET)
	public String listDestinosByPage(@PathVariable Integer page, Model model) {
		page = page == null || page < 1 ? 0 : page - 1;
		Page<Destino> pages = crudService.listAllDestinosByPage(new PageRequest(page, PAGE_SIZE));
		Pager pager = new Pager(pages.getTotalPages(), pages.getNumber(), BUTTONS_TO_SHOW);

		model.addAttribute("destinos", pages);
		model.addAttribute("pager", pager);
		model.addAttribute("destino", new Destino());
		return ViewConstant.DESTINOS;
	}
	@RequestMapping("destino/{id}")
	public String showDestino(@PathVariable Integer id, Model model) {
		model.addAttribute("destino", crudService.getDestinoById(id));
		return ViewConstant.DESTINOS+ " :: modalEdit";
	}
	@RequestMapping(value = "destino", method = RequestMethod.POST)
	public String saveDestino(@Valid @ModelAttribute("destino") Destino destino, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()){
			LOG.error("Errores al crear destino");
			for(ObjectError o : bindingResult.getAllErrors()){
				LOG.error("> "+o.getObjectName()+" "+o.getDefaultMessage());
			}
			//TODO
			return "redirect:/"+ViewConstant.DESTINOS;
		}
		crudService.saveDestino(destino);
		return "redirect:/"+ViewConstant.DESTINOS;
	}
	@RequestMapping("destino/delete/{id}")
	public String deleteDestino(@PathVariable Integer id) {
		crudService.deleteDestino(id);
		return "redirect:/"+ViewConstant.DESTINOS;
	}

	// +++ BUQUE +++
	@RequestMapping(value = "/buques", method = RequestMethod.GET)
	public String listBuques(Model model) {
		Page<Buque> pages = crudService.listAllBuquesByPage(new PageRequest(0, PAGE_SIZE));
		Pager pager = new Pager(pages.getTotalPages(), pages.getNumber(), BUTTONS_TO_SHOW);

		model.addAttribute("buques", pages);
		model.addAttribute("pager", pager);
		model.addAttribute("buque", new Buque());
		return "buques";
	}
	@RequestMapping(value = "/buques/{page}", method = RequestMethod.GET)
	public String listBuquesByPage(@PathVariable Integer page, Model model) {
		page = page == null || page < 1 ? 0 : page - 1;
		Page<Buque> pages = crudService.listAllBuquesByPage(new PageRequest(page, PAGE_SIZE));
		Pager pager = new Pager(pages.getTotalPages(), pages.getNumber(), BUTTONS_TO_SHOW);

		model.addAttribute("buques", pages);
		model.addAttribute("pager", pager);
		model.addAttribute("buque", new Buque());
		return "buques";
	}
	@RequestMapping("buque/{id}")
	public String showBuque(@PathVariable Integer id, Model model) {
		model.addAttribute("buque", crudService.getBuqueById(id));
		return "buques :: modalEdit";
	}
	@RequestMapping(value = "buque", method = RequestMethod.POST)
	public String saveBuque(@Valid @ModelAttribute("buque") Buque buque, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()){
			LOG.error("Errores al crear buque");
			for(ObjectError o : bindingResult.getAllErrors()){
				LOG.error("> "+o.getObjectName()+" "+o.getDefaultMessage());
			}
			//TODO
			return ViewConstant.BUQUES;
		}
		crudService.saveBuque(buque);
		return "redirect:/buques";
	}
	@RequestMapping("buque/delete/{id}")
	public String deleteBuque(@PathVariable Integer id) {
		crudService.deleteBuque(id);
		return "redirect:/buques";
	}

	// +++ BULTOS +++
	@RequestMapping(value = "/bultos", method = RequestMethod.GET)
	public String listBultos(Model model) {
		LOG.info("/bultos/");
		Page<Bulto> pages = crudService.listAllBultosByPage(new PageRequest(0, PAGE_SIZE));
		Pager pager = new Pager(pages.getTotalPages(), pages.getNumber(), BUTTONS_TO_SHOW);

		model.addAttribute("bultos", pages);
		model.addAttribute("pager", pager);
		model.addAttribute("bulto", new Bulto());
		return ViewConstant.BULTOS;
	}
	@RequestMapping(value = "/bultos/{page}", method = RequestMethod.GET)
	public String listBultosByPage(@PathVariable Integer page, Model model) {
		LOG.info("/bultos/{"+page+"}");
		page = page == null || page < 1 ? 0 : page - 1;
		Page<Bulto> pages = crudService.listAllBultosByPage(new PageRequest(page, PAGE_SIZE));
		Pager pager = new Pager(pages.getTotalPages(), pages.getNumber(), BUTTONS_TO_SHOW);

		model.addAttribute("bultos", pages);
		model.addAttribute("pager", pager);
		model.addAttribute("bulto", new Bulto());
		return ViewConstant.BULTOS;
	}
	@RequestMapping("bulto/{id}")
	public String showBulto(@PathVariable Integer id, Model model) {
		model.addAttribute("bulto", crudService.getBultoById(id));
		return "bultos :: modalEdit";
	}
	@RequestMapping(value = "bulto", method = RequestMethod.POST)
	public String saveBulto(@Valid @ModelAttribute("bulto") Bulto bulto, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()){
			LOG.error("Errores al crear bulto");
			for(ObjectError o : bindingResult.getAllErrors()){
				LOG.error("> "+o.getObjectName()+" "+o.getDefaultMessage());
			}
			//TODO
			return "redirect:/"+ViewConstant.BULTOS;
		}
		
		crudService.saveBulto(bulto);
		return "redirect:/bultos";
	}
	@RequestMapping("bulto/delete/{id}")
	public String deleteBulto(@PathVariable Integer id) {
		crudService.deleteBulto(id);
		return "redirect:/bultos";
	}

	// +++ CLIENTE +++
	@RequestMapping(value = "/clientes", method = RequestMethod.GET)
	public String listClientes(Model model) {
		LOG.info("/clientes/");
		Page<Cliente> pages = crudService.listAllClientesByPage(new PageRequest(0, PAGE_SIZE));
		Pager pager = new Pager(pages.getTotalPages(), pages.getNumber(), BUTTONS_TO_SHOW);

		model.addAttribute("clientes", pages);
		model.addAttribute("pager", pager);
		model.addAttribute("cliente", new Cliente());
		return ViewConstant.CLIENTES;
	}
	@RequestMapping(value = "/clientes/{page}", method = RequestMethod.GET)
	public String listClientesByPage(@PathVariable Integer page, Model model) {
		LOG.info("/clientes/{"+page+"}");
		page = page == null || page < 1 ? 0 : page - 1;
		Page<Cliente> pages = crudService.listAllClientesByPage(new PageRequest(page, PAGE_SIZE));
		Pager pager = new Pager(pages.getTotalPages(), pages.getNumber(), BUTTONS_TO_SHOW);

		model.addAttribute("clientes", pages);
		model.addAttribute("pager", pager);
		model.addAttribute("cliente", new Cliente());
		return ViewConstant.CLIENTES;
	}
	@RequestMapping(value = "cliente", method = RequestMethod.POST)
	public String saveCliente(@Valid @ModelAttribute("cliente") Cliente cliente, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()){
			LOG.error("Errores al crear cliente");
			for(ObjectError o : bindingResult.getAllErrors()){
				LOG.error("> "+o.getObjectName()+" "+o.getDefaultMessage());
			}
			//TODO
			return "redirect:/"+ViewConstant.CLIENTES;
		}
		crudService.saveCliente(cliente);
		return "redirect:/"+ViewConstant.CLIENTES;
	}
	@RequestMapping("cliente/{id}")
	public String showCliente(@PathVariable Integer id, Model model) {
		model.addAttribute("cliente", crudService.getClienteById(id));
		return ViewConstant.CLIENTES+" :: modalEdit";
	}
	@RequestMapping("cliente/delete/{id}")
	public String deleteCliente(@PathVariable Integer id) {
		crudService.deleteCliente(id);
		return "redirect:/"+ViewConstant.CLIENTES;
	}

	// +++ COMISIONISTA +++
	@RequestMapping(value = "/comisionistas", method = RequestMethod.GET)
	public String listComisionistas(Model model) {
		Page<Comisionista> pages = crudService.listAllComisionistasByPage(new PageRequest(0, PAGE_SIZE));
		Pager pager = new Pager(pages.getTotalPages(), pages.getNumber(), BUTTONS_TO_SHOW);

		model.addAttribute("comisionistas", pages);
		model.addAttribute("pager", pager);
		model.addAttribute("comisionista", new Cliente());
		return ViewConstant.COMISIONISTA;
	}
	@RequestMapping(value = "/comisionistas/{page}", method = RequestMethod.GET)
	public String listComisionistasByPage(@PathVariable Integer page, Model model) {
		page = page == null || page < 1 ? 0 : page - 1;
		Page<Comisionista> pages = crudService.listAllComisionistasByPage(new PageRequest(page, PAGE_SIZE));
		Pager pager = new Pager(pages.getTotalPages(), pages.getNumber(), BUTTONS_TO_SHOW);

		model.addAttribute("comisionistas", pages);
		model.addAttribute("pager", pager);
		model.addAttribute("comisionista", new Cliente());
		return ViewConstant.COMISIONISTA;
	}
	@RequestMapping(value = "comisionista", method = RequestMethod.POST)
	public String saveComisionista(@Valid @ModelAttribute("comisionista") Comisionista comisionista, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()){
			LOG.error("Errores al crear comisionista");
			for(ObjectError o : bindingResult.getAllErrors()){
				LOG.error("> "+o.getObjectName()+" "+o.getDefaultMessage());
			}
			//TODO
			return "redirect:/"+ViewConstant.COMISIONISTA;
		}
		crudService.saveComisionista(comisionista);
		return "redirect:/"+ViewConstant.COMISIONISTA;
	}
	@RequestMapping("comisionista/{id}")
	public String showComisionista(@PathVariable Integer id, Model model) {
		model.addAttribute("comisionista", crudService.getComisionistaById(id));
		return ViewConstant.COMISIONISTA+" :: modalEdit";
	}
	@RequestMapping("comisionista/delete/{id}")
	public String deleteComisionista(@PathVariable Integer id) {
		crudService.deleteComisionista(id);
		return "redirect:/"+ViewConstant.COMISIONISTA;
	}
}
