package waag.domain.entidades;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.validator.constraints.NotBlank;

/**
 * The persistent class for the mediotransporte database table.
 * 
 */
@Entity
@NamedQuery(name = "Mediotransporte.findAll", query = "SELECT m FROM Mediotransporte m")
public class Mediotransporte implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "MEDIOTRANSPORTE_IDMEDIO_GENERATOR", sequenceName = "MEDIOTRANSPORTE_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEDIOTRANSPORTE_IDMEDIO_GENERATOR")
	private Integer idmedio;

	private String ingles;

	private String medio;

	public Mediotransporte() {
	}

	public Integer getIdmedio() {
		return this.idmedio;
	}

	public void setIdmedio(Integer idmedio) {
		this.idmedio = idmedio;
	}

	public String getIngles() {
		return this.ingles;
	}

	public void setIngles(String ingles) {
		this.ingles = ingles;
	}

	@NotBlank(message = "Ingresa un nombre")
	public String getMedio() {
		return this.medio;
	}

	public void setMedio(String medio) {
		this.medio = medio;
	}

}