package waag.controllers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
		return "destinos";
	}
	@RequestMapping(value = "/destinos/{page}", method = RequestMethod.GET)
	public String listDestinosByPage(@PathVariable Integer page, Model model) {
		page = page == null || page < 1 ? 0 : page - 1;
		Page<Destino> pages = crudService.listAllDestinosByPage(new PageRequest(page, PAGE_SIZE));
		Pager pager = new Pager(pages.getTotalPages(), pages.getNumber(), BUTTONS_TO_SHOW);

		model.addAttribute("destinos", pages);
		model.addAttribute("pager", pager);
		model.addAttribute("destino", new Destino());
		return "destinos";
	}
	@RequestMapping("destino/{id}")
	public String showDestino(@PathVariable Integer id, Model model) {
		model.addAttribute("destino", crudService.getDestinoById(id));
		return "verDestino";
	}
	@RequestMapping("destino/edit/{id}")
	public String editDestino(@PathVariable Integer id, Model model) {
		model.addAttribute("destino", crudService.getDestinoById(id));
		return "formDestino";
	}
	@RequestMapping("destino/new")
	public String newDestino(Model model) {
		model.addAttribute("destino", new Destino());
		return "formDestino";
	}
	@RequestMapping(value = "destino", method = RequestMethod.POST)
	public String saveDestino(Destino destino) {
		crudService.saveDestino(destino);
		// return "redirect:/destino/" + destino.getId();
		return "redirect:/destinos";
	}
	@RequestMapping("destino/delete/{id}")
	public String deleteDestino(@PathVariable Integer id) {
		crudService.deleteDestino(id);
		return "redirect:/destinos";
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
		return "verBuque";
	}
	@RequestMapping("buque/edit/{id}")
	public String editBuque(@PathVariable Integer id, Model model) {
		model.addAttribute("buque", crudService.getBuqueById(id));
		return "formBuque";
	}
	@RequestMapping("buque/new")
	public String newBuque(Model model) {
		model.addAttribute("buque", new Buque());
		return "formBuque";
	}
	@RequestMapping(value = "buque", method = RequestMethod.POST)
	public String saveBuque(Buque buque) {
		crudService.saveBuque(buque);
		// return "redirect:/destino/" + destino.getId();
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
		return "verBulto";
	}
	@RequestMapping("bulto/edit/{id}")
	public String editBulto(@PathVariable Integer id, Model model) {
		model.addAttribute("bulto", crudService.getBultoById(id));
		return "formBulto";
	}
	@RequestMapping(value = "bulto", method = RequestMethod.PUT)
	public String editBulto(Bulto bulto) {
		crudService.saveBulto(bulto);
		return "redirect:/bultos";
	}
	@RequestMapping("bulto/new")
	public String newBulto(Model model) {
		model.addAttribute("bulto", new Bulto());
		return "formBulto";
	}
	@RequestMapping(value = "bulto", method = RequestMethod.POST)
	public String saveBulto(Bulto bulto) {
		crudService.saveBulto(bulto);
		// return "redirect:/destino/" + destino.getId();
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
		return "clientes";
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
		return "clientes";
	}
	@RequestMapping(value = "cliente", method = RequestMethod.POST)
	public String saveCliente(Cliente cliente) {
		crudService.saveCliente(cliente);
		// return "redirect:/destino/" + destino.getId();
		return "redirect:/clientes";
	}
	@RequestMapping("cliente/delete/{id}")
	public String deleteCliente(@PathVariable Integer id) {
		crudService.deleteCliente(id);
		return "redirect:/clientes";
	}
	@RequestMapping("cliente/{id}")
	public String showCliente(@PathVariable Integer id, Model model) {
		model.addAttribute("cliente", crudService.getClienteById(id));
		return "verCliente";
	}
	@RequestMapping("cliente/edit/{id}")
	public String editCliente(@PathVariable Integer id, Model model) {
		model.addAttribute("cliente", crudService.getClienteById(id));
		return "formCliente";
	}

	// +++ COMISIONISTA +++
	@RequestMapping(value = "/comisionistas", method = RequestMethod.GET)
	public String listComisionistas(Model model) {
		Page<Comisionista> pages = crudService.listAllComisionistasByPage(new PageRequest(0, PAGE_SIZE));
		Pager pager = new Pager(pages.getTotalPages(), pages.getNumber(), BUTTONS_TO_SHOW);

		model.addAttribute("comisionistas", pages);
		model.addAttribute("pager", pager);
		model.addAttribute("comisionista", new Cliente());
		return "comisionista";
	}
	@RequestMapping(value = "/comisionistas/{page}", method = RequestMethod.GET)
	public String listComisionistasByPage(@PathVariable Integer page, Model model) {
		page = page == null || page < 1 ? 0 : page - 1;
		Page<Comisionista> pages = crudService.listAllComisionistasByPage(new PageRequest(page, PAGE_SIZE));
		Pager pager = new Pager(pages.getTotalPages(), pages.getNumber(), BUTTONS_TO_SHOW);

		model.addAttribute("comisionistas", pages);
		model.addAttribute("pager", pager);
		model.addAttribute("comisionista", new Cliente());
		return "comisionista";
	}
	@RequestMapping(value = "comisionista", method = RequestMethod.POST)
	public String saveComisionista(Comisionista comisionista) {
		crudService.saveComisionista(comisionista);
		// return "redirect:/destino/" + destino.getId();
		return "redirect:/comisionistas";
	}
	@RequestMapping("comisionista/delete/{id}")
	public String deleteComisionista(@PathVariable Integer id) {
		crudService.deleteComisionista(id);
		return "redirect:/comisionistas";
	}
	@RequestMapping("comisionista/{id}")
	public String showComisionista(@PathVariable Integer id, Model model) {
		model.addAttribute("comisionista", crudService.getComisionistaById(id));
		return "verComisionista";
	}
	@RequestMapping("comisionista/edit/{id}")
	public String editComisionista(@PathVariable Integer id, Model model) {
		model.addAttribute("comisionista", crudService.getComisionistaById(id));
		return "formComisionista";
	}
}
