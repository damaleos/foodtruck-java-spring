package ttps.spring.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="evento")
public class Evento {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="fecha")
	private Date fecha;
	
	@Column(name="cod_postal")
	private String codPostal;
	
	@Column(name="provincia")
	private String provincia;
	
	@Column(name="geolocalizacion")
	private String geolocalizacion;
	
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private TipoEvento tipoEvento;
	
	@Column(name="telefono")
	private String telefono;
	
	@Column(name="email")
	private String email;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Enumerated(EnumType.STRING)
	private FormaPago formaPago;
	
	//@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	//@JoinColumn(name = "FK_COORDINADOR", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
	private UsuarioEvento coordinador;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "evento")
	private List<SolicitudServicio> solicitudes;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getCodPostal() {
		return codPostal;
	}
	public void setCodPostal(String codPostal) {
		this.codPostal = codPostal;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getGeolocalizacion() {
		return geolocalizacion;
	}
	public void setGeolocalizacion(String geolocalizacion) {
		this.geolocalizacion = geolocalizacion;
	}
	public TipoEvento getTipoEvento() {
		return tipoEvento;
	}
	public void setTipoEvento(TipoEvento tipoEvento) {
		this.tipoEvento = tipoEvento;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public FormaPago getFormaPago() {
		return formaPago;
	}
	public void setFormaPago(FormaPago formaPago) {
		this.formaPago = formaPago;
	}
	public UsuarioEvento getCoordinador() {
		return coordinador;
	}
	public void setCoordinador(UsuarioEvento coordinador) {
		this.coordinador = coordinador;
	}
	public List<SolicitudServicio> getSolicitudes() {
		return solicitudes;
	}
	public void setSolicitudes(List<SolicitudServicio> solicitudes) {
		this.solicitudes = solicitudes;
	}
	
	

}
