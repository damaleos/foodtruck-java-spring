package ttps.spring.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import ttps.spring.restful.springmvc.UsuarioDTO;

@Entity
@Table(name = "usuario_food_truck")
@PrimaryKeyJoinColumn(name = "id")
public class UsuarioFoodTruck extends Usuario {

	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<FoodTruck> foodTruckers;
	
	@Column(name="nombre_contacto")
	private String nombreContacto;
	
	public UsuarioFoodTruck() {
		super();
		this.foodTruckers = new ArrayList<FoodTruck>();
	}
	
	public UsuarioFoodTruck(UsuarioDTO user) {
		super();
		this.setIdUsuario(user.getIdUsuario());
		this.setEmail(user.getEmail());
		this.setPassword(user.getPassword());
		this.setTipo(TipoUsuario.FOOD_TUCKER);
	}

	public List<FoodTruck> getFoodTruckers() {
		return foodTruckers;
	}

	public void setFoodTruckers(List<FoodTruck> foodTruckers) {
		this.foodTruckers = foodTruckers;
	}

	public String getNombreContacto() {
		return nombreContacto;
	}

	public void setNombreContacto(String nombreContacto) {
		this.nombreContacto = nombreContacto;
	}
	
	

}
