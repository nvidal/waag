package waag.domain.usuario;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "roles", uniqueConstraints = @UniqueConstraint(columnNames = { "rol", "username" }))
public class Rol {

	@Id
	@SequenceGenerator(name = "ROLES_IDROL_GENERATOR", sequenceName = "ROLES_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROLES_IDROL_GENERATOR")
	private Integer idRol;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="username", nullable = false)
	private Usuario usuario;

	@Column(nullable = false)
	private String rol;
	
	

	public Rol(Usuario usuario, String rol) {
		super();
		this.usuario = usuario;
		this.rol = rol;
	}

	public Integer getIdRol() {
		return idRol;
	}

	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
	
	

}
