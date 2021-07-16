package ttps.spring.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="foto")
public class Foto {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "idx", length = 10, precision =0) 
	private int index;
	
	@Column(name="nombre")
	private String nombre;
	
	//@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	//@JoinColumn(name = "FK_PROPIETARIO", nullable = false)
    /*@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private UsuarioFoodTruck propietario;
*/
	@Column(name="dato")
	private String dato;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
/*	public UsuarioFoodTruck getPropietario() {
		return propietario;
	}
	public void setPropietario(UsuarioFoodTruck propietario) {
		this.propietario = propietario;
	}*/
	public String getDato() {
		return dato;
	}
	public void setDato(String dato) {
		this.dato = dato;
	}
	
	
}
