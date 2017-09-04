package waag.domain.entidades;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.validator.constraints.NotBlank;

/**
 * The persistent class for the unidadcomercial database table.
 * 
 */
@Entity
@NamedQuery(name = "Unidadcomercial.findAll", query = "SELECT u FROM Unidadcomercial u")
public class Unidadcomercial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "UNIDADCOMERCIAL_SEQ_GENERATOR", sequenceName = "UNIDADCOMERCIAL_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UNIDADCOMERCIAL_SEQ_GENERATOR")
	private Integer idunidad;

	private String codaduana;

	private String codmgap;

	private String unidadcomercial;

	public Unidadcomercial() {
	}

	public Integer getIdunidad() {
		return this.idunidad;
	}

	public void setIdunidad(Integer idunidad) {
		this.idunidad = idunidad;
	}

	public String getCodaduana() {
		return this.codaduana;
	}

	public void setCodaduana(String codaduana) {
		this.codaduana = codaduana;
	}

	public String getCodmgap() {
		return this.codmgap;
	}

	public void setCodmgap(String codmgap) {
		this.codmgap = codmgap;
	}

	@NotBlank(message = "Ingresa un nombre")
	public String getUnidadcomercial() {
		return this.unidadcomercial;
	}

	public void setUnidadcomercial(String unidadcomercial) {
		this.unidadcomercial = unidadcomercial;
	}

}