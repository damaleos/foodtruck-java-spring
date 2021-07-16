package ttps.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="valoracion_servicio")
public class ValoracionServicio {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@OneToOne
	//@JoinColumn(name = "FK_VS_SERVICIO", updatable = false, nullable = false)
	private SolicitudServicio servicio;
	
	@Column(name="limpieza")
	private int limpieza;
	
	@Column(name="simpatia")
	private int simpatia;
	
	@Column(name="calidadPrecio")
	private int calidadPrecio;
	
	@Column(name="sabor")
	private int sabor;
	
	@Column(name="diseno")
	private int diseno;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public SolicitudServicio getServicio() {
		return servicio;
	}
	public void setServicio(SolicitudServicio servicio) {
		this.servicio = servicio;
	}
	public int getLimpieza() {
		return limpieza;
	}
	public void setLimpieza(int limpieza) {
		this.limpieza = limpieza;
	}
	public int getSimpatia() {
		return simpatia;
	}
	public void setSimpatia(int simpatia) {
		this.simpatia = simpatia;
	}
	public int getCalidadPrecio() {
		return calidadPrecio;
	}
	public void setCalidadPrecio(int calidadPrecio) {
		this.calidadPrecio = calidadPrecio;
	}
	public int getSabor() {
		return sabor;
	}
	public void setSabor(int sabor) {
		this.sabor = sabor;
	}
	public int getDiseno() {
		return diseno;
	}
	public void setDiseno(int diseno) {
		this.diseno = diseno;
	}

	
	
}
