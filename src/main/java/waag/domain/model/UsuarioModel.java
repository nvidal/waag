package waag.domain.model;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import waag.domain.usuario.EnumRoles;

public class UsuarioModel {

	@NotBlank(message = "Ingresa un nombre")
	private String username;
	@NotBlank(message = "Ingresa un password")
	@Size(min=6, message="El password es muy corto")
	private String password;
	@NotBlank(message = "Ingresa un email")
	private String email;
	private boolean enable;
	private Set<EnumRoles> roles = new HashSet<EnumRoles>();

	
	public UsuarioModel() {
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
	public Set<EnumRoles> getRoles() {
		return roles;
	}
	public void setRoles(Set<EnumRoles> roles) {
		this.roles = roles;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

		
}
