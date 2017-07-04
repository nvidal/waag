package waag.domain.entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the receptorias database table.
 * 
 */
@Entity
@Table(name = "receptorias")
@NamedQuery(name = "Receptoria.findAll", query = "SELECT r FROM Receptoria r")
public class Receptoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "RECEPTORIAS_IDRECEPTORIA_GENERATOR", sequenceName = "RECEPTORIAS_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RECEPTORIAS_IDRECEPTORIA_GENERATOR")
	private Integer idreceptoria;

	private String receptoria;

	public Receptoria() {
	}

	public Integer getIdreceptoria() {
		return this.idreceptoria;
	}

	public void setIdreceptoria(Integer idreceptoria) {
		this.idreceptoria = idreceptoria;
	}

	public String getReceptoria() {
		return this.receptoria;
	}

	public void setReceptoria(String receptoria) {
		this.receptoria = receptoria;
	}

}