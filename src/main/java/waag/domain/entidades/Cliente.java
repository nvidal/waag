package waag.domain.entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the clientes database table.
 * 
 */
@Entity
@Table(name = "clientes")
@NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "CLIENTES_IDCLIENTE_GENERATOR", sequenceName = "CLIENTES_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLIENTES_IDCLIENTE_GENERATOR")
	private Integer idcliente;

	private String direccion;

	private String exportador;

	private String fax;

	private String nromercantil;

	private String ruc;

	private String tel;

	public Cliente() {
	}

	public Integer getIdcliente() {
		return this.idcliente;
	}

	public void setIdcliente(Integer idcliente) {
		this.idcliente = idcliente;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getExportador() {
		return this.exportador;
	}

	public void setExportador(String exportador) {
		this.exportador = exportador;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getNromercantil() {
		return this.nromercantil;
	}

	public void setNromercantil(String nromercantil) {
		this.nromercantil = nromercantil;
	}

	public String getRuc() {
		return this.ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

}