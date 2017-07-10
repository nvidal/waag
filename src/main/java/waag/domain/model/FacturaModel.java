package waag.domain.model;

import java.util.Date;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import waag.domain.entidades.Bulto;
import waag.domain.entidades.Buque;
import waag.domain.entidades.Cliente;
import waag.domain.entidades.Compvend;
import waag.domain.entidades.Desccomercial;
import waag.domain.entidades.Destino;
import waag.domain.entidades.Encargado;
import waag.domain.entidades.Estado;
import waag.domain.entidades.Marca;
import waag.domain.entidades.Mediotransporte;
import waag.domain.entidades.Mercaderia;
import waag.domain.entidades.Operacion;
import waag.domain.entidades.Receptoria;
import waag.domain.entidades.Unidadcomercial;

public class FacturaModel {

	private Integer id;
	@NotNull
	@Size(min=1)
	private String facturaNro;
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fecha;
	private Float bultos;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date eta; //DATE
	private String formapago;
	private String importe; //TODO
	private Float kilosbrutos;
	private Float kilosnetos;
	private String neg;
	private String observaciones;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date recibodocdef; //DATE
	@Column(name = "si_no")
	private String siNo;
	private String tipocarga;
	private Float tonsemb;
	private Float tonsneg;
	private Float valorfob;
	
	//Mantenimientos
	private Bulto bulto;
	private Buque buque;
	private Operacion operacion;
	private Cliente cliente;
	private Compvend compvend;
	private Desccomercial descripcion;
	private Destino destino;
	private Encargado encargado;
	private Estado estado;
	private Marca marca;
	private Mediotransporte medio;
	private Mercaderia mercaderia;
	private Receptoria receptoria;
	private Unidadcomercial unidad;

	public FacturaModel() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFacturaNro() {
		return facturaNro;
	}

	public void setFacturaNro(String facturaNro) {
		this.facturaNro = facturaNro;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Float getBultos() {
		return bultos;
	}

	public void setBultos(Float bultos) {
		this.bultos = bultos;
	}

	public Date getEta() {
		return eta;
	}

	public void setEta(Date eta) {
		this.eta = eta;
	}

	public String getFormapago() {
		return formapago;
	}

	public void setFormapago(String formapago) {
		this.formapago = formapago;
	}

	public String getImporte() {
		return importe;
	}

	public void setImporte(String importe) {
		this.importe = importe;
	}

	public Float getKilosbrutos() {
		return kilosbrutos;
	}

	public void setKilosbrutos(Float kilosbrutos) {
		this.kilosbrutos = kilosbrutos;
	}

	public Float getKilosnetos() {
		return kilosnetos;
	}

	public void setKilosnetos(Float kilosnetos) {
		this.kilosnetos = kilosnetos;
	}

	public String getNeg() {
		return neg;
	}

	public void setNeg(String neg) {
		this.neg = neg;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Date getRecibodocdef() {
		return recibodocdef;
	}

	public void setRecibodocdef(Date recibodocdef) {
		this.recibodocdef = recibodocdef;
	}

	public String getSiNo() {
		return siNo;
	}

	public void setSiNo(String siNo) {
		this.siNo = siNo;
	}

	public String getTipocarga() {
		return tipocarga;
	}

	public void setTipocarga(String tipocarga) {
		this.tipocarga = tipocarga;
	}

	public Float getTonsemb() {
		return tonsemb;
	}

	public void setTonsemb(Float tonsemb) {
		this.tonsemb = tonsemb;
	}

	public Float getTonsneg() {
		return tonsneg;
	}

	public void setTonsneg(Float tonsneg) {
		this.tonsneg = tonsneg;
	}

	public Float getValorfob() {
		return valorfob;
	}

	public void setValorfob(Float valorfob) {
		this.valorfob = valorfob;
	}

	public Bulto getBulto() {
		return bulto;
	}

	public void setBulto(Bulto bulto) {
		this.bulto = bulto;
	}

	public Buque getBuque() {
		return buque;
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
