package waag.controllers;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import waag.constants.ViewConstant;
import waag.domain.model.UsuarioModel;
import waag.exceptions.SaveWaagException;
import waag.services.UsuarioService;

@Controller
public class LoginController {
	
	private static final Log LOG = LogFactory.getLog(LoginController.class);
	
	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/login")
	public String showLoginForm(Model model, 
			@RequestParam(name="error", required = false) String error,
			@RequestParam(name="logout", required = false) String logout){
		LOG.info("Metodo login "+error+" "+logout);
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		model.addAttribute("usuario", new UsuarioModel());
		return "login";
	}
	
	@GetMapping({ "/loginsuccess"})
	public String loginCheck(){
		LOG.info("Metodo loginCheck");
		return "redirect:/";
	}
	
	@GetMapping("/registrar")
	public String showRegistrarForm(Model model, 
			@RequestParam(name="error", required = false) String error){
		LOG.info("Metodo registrar "+error);
		model.addAttribute("error", error);
		model.addAttribute("usuario", new UsuarioModel());
		//model.addAttribute("confirmacion", "");
		//model.addAttribute("errorConfirmacion", null);
		return "registrar";
	}
	
	@RequestMapping(value = "/registrar", method = RequestMethod.POST)
	public String registrarUsuario(@ModelAttribute("usuario") @Valid UsuarioModel usuario,BindingResult bindingResult, Model model){
		if(bindingResult.hasErrors()){
			LOG.error("Errores al crear usuario");
			for(ObjectError o : bindingResult.getAllErrors()){
				LOG.error("> "+o.getObjectName()+" "+o.getDefaultMessage());
			}
			UsuarioModel u = usuarioService.getUsuario(usuario.getUsername());
			if (u!=null){
				model.addAttribute("msjRegistro", "Ya existe un usuario con ese nombre.");
			}
			return "registrar";
		}
		try {
			usuario.setEnable(true);
			usuarioService.saveUsuario(usuario);
			model.addAttribute("msj", "Usuario registrado con éxito.");
		} catch (SaveWaagException ex) {
			model.addAttribute("msjRegistro", ex.getMessage());
			return "registrar";
		}
		return "login";
	}
}
