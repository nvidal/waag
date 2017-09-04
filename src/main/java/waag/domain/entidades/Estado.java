package waag.domain.entidades;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.validator.constraints.NotBlank;

/**
 * The persistent class for the estados database table.
 * 
 */
@Entity
@Table(name = "estados")
@NamedQuery(name = "Estado.findAll", query = "SELECT e FROM Estado e")
public class Estado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "ESTADOS_SEQ_GENERATOR", sequenceName = "ESTADOS_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ESTADOS_SEQ_GENERATOR")
	private Integer idestado;

	private String estado;

	public Estado() {
	}

	public Integer getIdestado() {
		return this.idestado;
	}

	public void setIdestado(Integer idestado) {
		this.idestado = idestado;
	}

	@NotBlank(message = "Ingresa un nombre de estado")
	@Column(nullable=false)
	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}