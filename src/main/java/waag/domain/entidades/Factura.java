package waag.domain.entidades;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
import java.util.Date;

/**
 * The persistent class for the facturas_aux database table.
 * 
 */
@Entity
@Table(name = "facturas_aux")
@NamedQuery(name = "Facturas.findAll", query = "SELECT f FROM Factura f")
public class Factura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "FACTURAS_SEQ_GENERATOR", sequenceName = "FACTURAS_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FACTURAS_SEQ_GENERATOR")
	private Integer id;

	private Float bultos;

	private Timestamp eta;

	@NotNull
	@Column(name="factura", nullable=false)
	private String facturaNro;

	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fecha;

	private String formapago;

	@ManyToOne
	@JoinColumn(name = "idbulto")
	private Bulto bulto;

	@ManyToOne
	@JoinColumn(name = "idbuque")
	private Buque buque;

	@ManyToOne
	@JoinColumn(name = "cod_operacion")
	private Operacion operacion;

	@ManyToOne
	@JoinColumn(name = "idcliente")
	private Cliente cliente;

	@ManyToOne
	@JoinColumn(name = "idcompvend")
	private Compvend compvend;

	@ManyToOne
	@JoinColumn(name = "iddescripcion")
	private Desccomercial descripcion;

	@ManyToOne
	@JoinColumn(name = "iddestino")
	private Destino destino;

	@ManyToOne
	@JoinColumn(name = "idencargado")
	private Encargado encargado;

	@ManyToOne
	@JoinColumn(name = "idestado")
	private Estado estado;

	@ManyToOne
	@JoinColumn(name = "idmarca")
	private Marca marca;

	@ManyToOne
	@JoinColumn(name = "idmedio")
	private Mediotransporte medio;

	@ManyToOne
	@JoinColumn(name = "idmercaderia")
	private Mercaderia mercaderia;

	@ManyToOne
	@JoinColumn(name = "idreceptoria")
	private Receptoria receptoria;

	@ManyToOne
	@JoinColumn(name = "idunidad")
	private Unidadcomercial unidad;

	private String importe;

	private Float kilosbrutos;

	private Float kilosnetos;

	private String neg;

	private String observaciones;

	private Timestamp recibodocdef;

	@Column(name = "si_no")
	private String siNo;

	private String tipocarga;

	private Float tonsemb;

	private Float tonsneg;

	private Float valorfob;

	public Factura() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Float getBultos() {
		return this.bultos;
	}

	public void setBultos(Float bultos) {
		this.bultos = bultos;
	}

	public Timestamp getEta() {
		return this.eta;
	}

	public void setEta(Timestamp eta) {
		this.eta = eta;
	}

	public String getFacturaNro() {
		return this.facturaNro;
	}

	public void setFacturaNro(String factura) {
		this.facturaNro = factura;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getFormapago() {
		return this.formapago;
	}

	public void setFormapago(String formapago) {
		this.formapago = formapago;
	}

	public String getImporte() {
		return this.importe;
	}

	public void setImporte(String importe) {
		this.importe = importe;
	}

	public Float getKilosbrutos() {
		return this.kilosbrutos;
	}

	public void setKilosbrutos(Float kilosbrutos) {
		this.kilosbrutos = kilosbrutos;
	}

	public Float getKilosnetos() {
		return this.kilosnetos;
	}

	public void setKilosnetos(Float kilosnetos) {
		this.kilosnetos = kilosnetos;
	}

	public String getNeg() {
		return this.neg;
	}

	public void setNeg(String neg) {
		this.neg = neg;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Timestamp getRecibodocdef() {
		return this.recibodocdef;
	}

	public void setRecibodocdef(Timestamp recibodocdef) {
		this.recibodocdef = recibodocdef;
	}

	public String getSiNo() {
		return this.siNo;
	}

	public void setSiNo(String siNo) {
		this.siNo = siNo;
	}

	public String getTipocarga() {
		return this.tipocarga;
	}

	public void setTipocarga(String tipocarga) {
		this.tipocarga = tipocarga;
	}

	public Float getTonsemb() {
		return this.tonsemb;
	}

	public void setTonsemb(Float tonsemb) {
		this.tonsemb = tonsemb;
	}

	public Float getTonsneg() {
		return this.tonsneg;
	}

	public void setTonsneg(Float tonsneg) {
		this.tonsneg = tonsneg;
	}

	public Float getValorfob() {
		return this.valorfob;
	}

	public void setValorfob(Float valorfob) {
		this.valorfob = valorfob;
	}

	public Bulto getBulto() {
		return this.bulto;
	}

	public void setBulto(Bulto bulto) {
		this.bulto = bulto;
	}

	public Buque getBuque() {
		return this.buque;
	}

	public void setBuque(Buque buque) {
		this.buque = buque;
	}

	public Operacion getOperacion() {
		return operacion;
	}

	public void setOperacion(Operacion operacion) {
		this.operacion = operacion;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Compvend getCompvend() {
		return compvend;
	}

	public void setCompvend(Compvend compvend) {
		this.compvend = compvend;
	}

	public Desccomercial getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(Desccomercial descripcion) {
		this.descripcion = descripcion;
	}

	public Destino getDestino() {
		return destino;
	}

	public void setDestino(Destino destino) {
		this.destino = destino;
	}

	public Encargado getEncargado() {
		return encargado;
	}

	public void setEncargado(Encargado encargado) {
		this.encargado = encargado;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Mediotransporte getMedio() {
		return medio;
	}

	public void setMedio(Mediotransporte medio) {
		this.medio = medio;
	}

	public Mercaderia getMercaderia() {
		return mercaderia;
	}

	public void setMercaderia(Mercaderia mercaderia) {
		this.mercaderia = mercaderia;
	}

	public Receptoria getReceptoria() {
		return receptoria;
	}

	public void setReceptoria(Receptoria receptoria) {
		this.receptoria = receptoria;
	}

	public Unidadcomercial getUnidad() {
		return unidad;
	}

	public void setUnidad(Unidadcomercial unidad) {
		this.unidad = unidad;
	}

}