package waag.domain.entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the comisionistas database table.
 * 
 */
@Entity
@Table(name = "comisionistas")
@NamedQuery(name = "Comisionista.findAll", query = "SELECT c FROM Comisionista c")
public class Comisionista implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "COMISIONISTAS_IDCOMISIONISTA_GENERATOR", sequenceName = "COMISIONISTAS_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMISIONISTAS_IDCOMISIONISTA_GENERATOR")
	private Integer idcomisionista;

	private String comisionista;

	public Comisionista() {
	}

	public Integer getIdcomisionista() {
		return this.idcomisionista;
	}

	public void setIdcomisionista(Integer idcomisionista) {
		this.idcomisionista = idcomisionista;
	}

	public String getComisionista() {
		return this.comisionista;
	}

	public void setComisionista(String comisionista) {
		this.comisionista = comisionista;
	}

}