package waag.domain.entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the mercaderias database table.
 * 
 */
@Entity
@Table(name = "mercaderias")
@NamedQuery(name = "Mercaderia.findAll", query = "SELECT m FROM Mercaderia m")
public class Mercaderia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "MERCADERIAS_SEQ_GENERATOR", sequenceName = "MERCADERIAS_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MERCADERIAS_SEQ_GENERATOR")
	private Integer idmercaderia;

	private String codigomgap;

	private String glosa;

	@Column(name = "glosa_sa")
	private String glosaSa;

	private String mercaderia;

	private String ncm;

	@Column(name = "ncm_dc")
	private String ncmDc;

	private String sa;

	private String variedad;

	public Mercaderia() {
	}

	public Integer getIdmercaderia() {
		return this.idmercaderia;
	}

	public void setIdmercaderia(Integer idmercaderia) {
		this.idmercaderia = idmercaderia;
	}

	public String getCodigomgap() {
		return this.codigomgap;
	}

	public void setCodigomgap(String codigomgap) {
		this.codigomgap = codigomgap;
	}

	public String getGlosa() {
		return this.glosa;
	}

	public void setGlosa(String glosa) {
		this.glosa = glosa;
	}

	public String getGlosaSa() {
		return this.glosaSa;
	}

	public void setGlosaSa(String glosaSa) {
		this.glosaSa = glosaSa;
	}

	public String getMercaderia() {
		return this.mercaderia;
	}

	public void setMercaderia(String mercaderia) {
		this.mercaderia = mercaderia;
	}

	public String getNcm() {
		return this.ncm;
	}

	public void setNcm(String ncm) {
		this.ncm = ncm;
	}

	public String getNcmDc() {
		return this.ncmDc;
	}

	public void setNcmDc(String ncmDc) {
		this.ncmDc = ncmDc;
	}

	public String getSa() {
		return this.sa;
	}

	public void setSa(String sa) {
		this.sa = sa;
	}

	public String getVariedad() {
		return this.variedad;
	}

	public void setVariedad(String variedad) {
		this.variedad = variedad;
	}

}