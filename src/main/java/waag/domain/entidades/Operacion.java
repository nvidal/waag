package waag.domain.entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the operaciones database table.
 * 
 */
@Entity
@Table(name = "operaciones")
@NamedQuery(name = "Operacion.findAll", query = "SELECT o FROM Operacion o")
public class Operacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "OPERACIONES_CODIGO_GENERATOR", sequenceName = "OPERACIONES_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OPERACIONES_CODIGO_GENERATOR")
	private Integer codigo;

	private String operacion;

	public Operacion() {
	}

	public Integer getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getOperacion() {
		return this.operacion;
	}

	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}

	public String toString() {
		return this.operacion;
	}

}