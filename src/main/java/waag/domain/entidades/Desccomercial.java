package waag.domain.entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the desccomercial database table.
 * 
 */
@Entity
@NamedQuery(name = "Desccomercial.findAll", query = "SELECT d FROM Desccomercial d")
public class Desccomercial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer iddescripcion;

	private String descripcion;

	private String ncm;

	public Desccomercial() {
	}

	public Integer getIddescripcion() {
		return this.iddescripcion;
	}

	public void setIddescripcion(Integer iddescripcion) {
		this.iddescripcion = iddescripcion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNcm() {
		return this.ncm;
	}

	public void setNcm(String ncm) {
		this.ncm = ncm;
	}

}