package waag.domain.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * The persistent class for the destinos database table.
 * 
 */
@Entity
@Table(name = "destinos")
@NamedQuery(name = "Destino.findAll", query = "SELECT d FROM Destino d")
public class Destino implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "destinos_seq", sequenceName = "destinos_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "destinos_seq")
	private Integer iddestino;

	private String ciudad;

	private String codaduana;

	private String codigo;

	private String formulaa;

	private String pais;
	
	private Date fechaBaja;

	public Destino() {
	}

	public Integer getIddestino() {
		return this.iddestino;
	}

	public void setIddestino(Integer iddestino) {
		this.iddestino = iddestino;
	}
	@NotBlank(message = "Ingresa una ciudad")
	@Column(nullable=false)
	public String getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getCodaduana() {
		return this.codaduana;
	}

	public void setCodaduana(String codaduana) {
		this.codaduana = codaduana;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getFormulaa() {
		return this.formulaa;
	}

	public void setFormulaa(String formulaa) {
		this.formulaa = formulaa;
	}

	@NotBlank(message = "Ingresa un pais")
	public String getPais() {
		return this.pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public Date getFechaBaja() {
		return fechaBaja;
	}

	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}
}