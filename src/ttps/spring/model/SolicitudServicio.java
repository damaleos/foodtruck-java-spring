package ttps.spring.model;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="solicitud_servicio")
public class SolicitudServicio {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Enumerated(EnumType.STRING)
	private EstadoSolicitud estado;
	
	@Column(name="valoracion_habilitada")
	private boolean valoracionHabilitada;
	
	//@JoinColumn(name = "FK_SS_FOOD_TRUKER", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
	private UsuarioFoodTruck foodTrucker;
	
	//@JoinColumn(name = "FK_SS_EVENTO", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Evento evento;
	
	@OneToOne(mappedBy = "servicio", cascade = CascadeType.ALL)
	private ValoracionServicio valoracion;
	
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public EstadoSolicitud getEstado() {
		return estado;
	}
	public void setEstado(EstadoSolicitud estado) {
		this.estado = estado;
	}
	public boolean isValoracionHabilitada() {
		return valoracionHabilitada;
	}
	public void setValoracionHabilitada(boolean valoracionHabilitada) {
		this.valoracionHabilitada = valoracionHabilitada;
	}
	public UsuarioFoodTruck getFoodTrucker() {
		return foodTrucker;
	}
	public void setFoodTrucker(UsuarioFoodTruck foodTrucker) {
		this.foodTrucker = foodTrucker;
	}
	public Evento getEvento() {
		return evento;
	}
	public void setEvento(Evento evento) {
		this.evento = evento;
	}
	public ValoracionServicio getValoracion() {
		return valoracion;
	}
	public void setValoracion(ValoracionServicio valoracion) {
		this.valoracion = valoracion;
	}
	
	
}
