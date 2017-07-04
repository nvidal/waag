package waag.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import waag.domain.usuario.Rol;
import waag.domain.usuario.Usuario;
import waag.repositories.UsuarioRepository;

@Service("UsuarioService")
public class UsuarioService implements UserDetailsService{
	
	@Autowired
	@Qualifier("usuarioRepository")
	private UsuarioRepository usuarioRepository;

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
}
