package waag.components;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;


import waag.domain.model.UsuarioModel;
import waag.domain.usuario.EnumRoles;
import waag.domain.usuario.Rol;
import waag.domain.usuario.Usuario;

@Component("usuarioConverter")
public class UsuarioConverter implements Converter<Usuario, UsuarioModel>{

	public Usuario convertUsuarioModelToUsuario(UsuarioModel model){
		Usuario usuario = new Usuario();
		if(model != null){
			usuario.setUsername(model.getUsername());
			BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
			usuario.setPassword(pe.encode(model.getPassword()));
			usuario.setEmail(model.getEmail());
			usuario.setEnable(model.isEnable());
//			Set<Rol> roles = new HashSet<Rol>();
//			roles.add(new Rol(usuario, EnumRoles.ADMIN.getRol()));
//			usuario.setRoles(roles);
		}
		
		return usuario;
	}
	
	public UsuarioModel convertUsuarioToUsuarioModel(Usuario usuario){
		UsuarioModel model = new UsuarioModel();
		if(usuario != null){
			model.setUsername(usuario.getUsername());
			model.setPassword(null);
			model.setEmail(usuario.getEmail());
			model.setEnable(usuario.isEnable());
			//model.setRoles(roles);
		}
		
		return model;
	}

	@Override
	public UsuarioModel convert(Usuario usuario) {
		return convertUsuarioToUsuarioModel(usuario);
	}
}
