package waag.domain.entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the bultos database table.
 * 
 */
@Entity
@Table(name = "bultos")
@NamedQuery(name = "Bulto.findAll", query = "SELECT b FROM Bulto b")
public class Bulto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "BULTOS_IDBULTO_GENERATOR", sequenceName = "BULTOS_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BULTOS_IDBULTO_GENERATOR")
	private Integer idbulto;

	private String bultoaduana;

	private String bultosaman;

	private String tipo;

	public Bulto() {
	}

	public Integer getIdbulto() {
		return this.idbulto;
	}

	public void setIdbulto(Integer idbulto) {
		this.idbulto = idbulto;
	}

	public String getBultoaduana() {
		return this.bultoaduana;
	}

	public void setBultoaduana(String bultoaduana) {
		this.bultoaduana = bultoaduana;
	}

	public String getBultosaman() {
		return this.bultosaman;
	}

	public void setBultosaman(String bultosaman) {
		this.bultosaman = bultosaman;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}