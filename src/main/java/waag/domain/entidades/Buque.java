package waag.domain.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * The persistent class for the buques database table.
 * 
 */
@Entity
@Table(name = "buques")
@NamedQuery(name = "Buque.findAll", query = "SELECT b FROM Buque b")
public class Buque implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "BUQUES_IDBUQUE_GENERATOR", sequenceName = "BUQUES_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BUQUES_IDBUQUE_GENERATOR")
	private Integer idbuque;

	@Column(name = "buque")
	private String nombre;
	
	private Date fechaBaja;

	public Buque() {
	}

	public Integer getIdbuque() {
		return this.idbuque;
	}

	public void setIdbuque(Integer idbuque) {
		this.idbuque = idbuque;
	}

	@NotBlank(message = "Ingresa un nombre")
	@Column(nullable=false)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public Date getFechaBaja() {
		return fechaBaja;
	}

	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

}