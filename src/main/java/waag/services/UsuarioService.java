package waag.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import waag.components.FacturaConverter;
import waag.components.UsuarioConverter;
import waag.domain.entidades.Destino;
import waag.domain.entidades.Factura;
import waag.domain.model.FacturaModel;
import waag.domain.model.UsuarioModel;
import waag.domain.usuario.Rol;
import waag.domain.usuario.Usuario;
import waag.exceptions.SaveWaagException;
import waag.repositories.UsuarioRepository;

@Service("UsuarioService")
public class UsuarioService implements UserDetailsService{
	
	private static final Log LOG = LogFactory.getLog(UsuarioService.class);
	
	
	@Autowired
	@Qualifier("usuarioRepository")
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private UsuarioConverter usuarioConverter;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByUsername(username);
		List<GrantedAuthority> authorities = buildAuthorities(usuario.getRoles());
		return buildUser(usuario, authorities);
	}

	private User buildUser(Usuario usuario, List<GrantedAuthority> authorities){
		return new User(usuario.getUsername(), usuario.getPassword(), usuario.isEnable(),
				true, true, true, authorities);
	}
	
	private List<GrantedAuthority> buildAuthorities( Set<Rol> roles){
		List<GrantedAuthority> res = new ArrayList<GrantedAuthority>();
		if (roles != null)
			for(Rol r: roles){
				res.add(new SimpleGrantedAuthority(r.getRol()));
			}
		return res;
	}
	
	public UsuarioModel saveUsuario(UsuarioModel model) throws SaveWaagException{
		Usuario usuario = null;
		try{
			usuario = usuarioRepository.save(usuarioConverter.convertUsuarioModelToUsuario(model));
		}catch(ConstraintViolationException ex){
			LOG.error("Ocurrió un error al grabar: "+ex.getMessage()+ " "+ex.getCause());
			throw new SaveWaagException("Ya existe un usuario con ese username: "+ex.getMessage());
		}
		catch(Exception ex){
			LOG.error("Ocurrió un error al grabar: "+ex.getMessage()+ " "+ex.getCause());
			throw new SaveWaagException("Ocurrió un error al grabar: "+ex.getMessage());
		}
		return usuarioConverter.convertUsuarioToUsuarioModel(usuario);
	}
	
	public Iterable<UsuarioModel> listAllUsuarios() {
		LOG.info("listAllUsuarios");
		Iterable<Usuario> usuarios = usuarioRepository.findAll();
		List<UsuarioModel> models = new ArrayList<UsuarioModel>();
		for(Usuario u : usuarios){
			models.add(usuarioConverter.convertUsuarioToUsuarioModel(u));
		}
		return models;
	}
	
	public void deleteUsuario(String username) throws SaveWaagException{
		Usuario usuario = usuarioRepository.findByUsername(username);
		if (usuario == null ){
			throw new SaveWaagException("El usuario "+username+" no se encuentra.");
		}
		else
			usuarioRepository.delete(usuario);
	}
	
	public UsuarioModel getUsuario(String username) throws SaveWaagException{
		Usuario usuario = usuarioRepository.findByUsername(username);
		if (usuario == null ){
			throw new SaveWaagException("El usuario "+username+" no se encuentra.");
		}
		else
			return usuarioConverter.convertUsuarioToUsuarioModel(usuario);
	}
}
