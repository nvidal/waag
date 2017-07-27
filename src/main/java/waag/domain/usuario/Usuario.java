package waag.domain.usuario;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {

	@Id
	@Column(name = "username", unique = true, nullable = false, length = 50)
	private String username;
	
	@Column(name = "password", nullable = false, length = 65)
	private String password;

	private String email;
	private boolean enable;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "usuario", cascade=CascadeType.PERSIST)
	private Set<Rol> roles = new HashSet<Rol>();

	public Usuario() {
	}

	public Usuario(String username, String password, String email, boolean enable, Set<Rol> roles) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.enable = enable;
		this.roles = roles;
	}

	public Usuario(String username, String password, String email, boolean enable) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.enable = enable;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public Set<Rol> getRoles() {
		return roles;
	}

	public void setRoles(Set<Rol> roles) {
		this.roles = roles;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
