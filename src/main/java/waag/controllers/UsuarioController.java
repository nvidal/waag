package waag.controllers;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import waag.domain.model.UsuarioModel;
import waag.exceptions.SaveWaagException;
import waag.services.UsuarioService;

@Controller
public class UsuarioController {

	private static final Log LOG = LogFactory.getLog(UsuarioController.class);
	
	@Autowired
	private UsuarioService usuarioService;
	
	
	@RequestMapping(value = "/usuarios", method = RequestMethod.GET)
	public String listUsuarios(Model model) {
		Iterable<UsuarioModel> usuarios = usuarioService.listAllUsuarios();

		model.addAttribute("usuarios", usuarios);
		model.addAttribute("usuario", new UsuarioModel());
		return "usuarios";
	}
	
	@RequestMapping(value = "/usuario/{username}", method = RequestMethod.GET)
	public String getUsuario(@PathVariable String username, Model model) {
			UsuarioModel usuario = usuarioService.getUsuario(username);
			if (usuario == null){
				model.addAttribute("resMsj", "No se encontró el usuario "+username);
				return "redirect:/usuarios";
			}
			model.addAttribute("usuario", usuario);
			return "usuarios :: modalEdit";	
	}
	
	@RequestMapping(value = "usuario", method = RequestMethod.POST)
	public String saveUsuario(@Valid @ModelAttribute("usuario") UsuarioModel usuario, BindingResult bindingResult, Model model){//UsuarioModel usuario) {
		try {
			usuario.setEnable(true);
			usuarioService.saveUsuario(usuario);
			model.addAttribute("resultado", "OK");
			model.addAttribute("resMsj", "Usuario creado con éxito.");
		} catch (SaveWaagException ex) {
			model.addAttribute("resultado", "ERROR");
			model.addAttribute("resMsj", ex.getMessage());
		}
		return "redirect:/usuarios";
	}
	
	@RequestMapping("usuario/delete/{username}")
	public String deleteUsuario(@PathVariable String username, Model model) {
		try {
			usuarioService.deleteUsuario(username);
			Iterable<UsuarioModel> usuarios = usuarioService.listAllUsuarios();
			model.addAttribute("usuarios", usuarios);
			model.addAttribute("resultado", 1);
			model.addAttribute("resMsj", "Usuario eliminado con éxito.");
		} catch (SaveWaagException ex) {
			model.addAttribute("resultado", 0);
			model.addAttribute("resMsj", ex.getMessage());
		}
		return "redirect:/usuarios";
	}
	
}
