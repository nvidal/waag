package waag.domain.entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the encargados database table.
 * 
 */
@Entity
@Table(name = "encargados")
@NamedQuery(name = "Encargado.findAll", query = "SELECT e FROM Encargado e")
public class Encargado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "ENCARGADOS_SEQ_GENERATOR", sequenceName = "ENCARGADOS_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ENCARGADOS_SEQ_GENERATOR")
	private Integer idencargado;

	private String iniciales;

	private String nombre;

	public Encargado() {
	}

	public Integer getIdencargado() {
		return this.idencargado;
	}

	public void setIdencargado(Integer idencargado) {
		this.idencargado = idencargado;
	}

	public String getIniciales() {
		return this.iniciales;
	}

	public void setIniciales(String iniciales) {
		this.iniciales = iniciales;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}