package waag.domain.entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the compvend database table.
 * 
 */
@Entity
@NamedQuery(name = "Compvend.findAll", query = "SELECT c FROM Compvend c")
public class Compvend implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "COMPVEND_IDCOMPVEND_GENERATOR", sequenceName = "COMPVEND_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMPVEND_IDCOMPVEND_GENERATOR")
	private Integer idcompvend;

	private String cliente;

	private String direccion;

	private String fax;

	private String registrofiscal;

	private String tel;

	public Compvend() {
	}

	public Integer getIdcompvend() {
		return this.idcompvend;
	}

	public void setIdcompvend(Integer idcompvend) {
		this.idcompvend = idcompvend;
	}

	public String getCliente() {
		return this.cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getRegistrofiscal() {
		return this.registrofiscal;
	}

	public void setRegistrofiscal(String registrofiscal) {
		this.registrofiscal = registrofiscal;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

}