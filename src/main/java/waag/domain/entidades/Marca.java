package waag.domain.entidades;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.validator.constraints.NotBlank;

/**
 * The persistent class for the marcas database table.
 * 
 */
@Entity
@Table(name = "marcas")
@NamedQuery(name = "Marca.findAll", query = "SELECT m FROM Marca m")
public class Marca implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "MARCAS_IDMARCA_GENERATOR", sequenceName = "MARCAS_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MARCAS_IDMARCA_GENERATOR")
	private Integer idmarca;

	private String marca;

	public Marca() {
	}

	public Integer getIdmarca() {
		return this.idmarca;
	}

	public void setIdmarca(Integer idmarca) {
		this.idmarca = idmarca;
	}

	@NotBlank(message = "Ingresa una marca")
	@Column(nullable=false)
	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

}