package ttps.spring.restful.springmvc;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ttps.spring.dao.FoodTruckDao;
import ttps.spring.dao.TipoServicioDao;
import ttps.spring.dao.UsuarioFoodTruckDao;
import ttps.spring.model.FoodTruck;
import ttps.spring.model.TipoServicio;
import ttps.spring.model.UsuarioFoodTruck;

@Service("foodTruckService")
public class FoodTruckService {

	@Autowired
	private FoodTruckDao foodTruckDaoJPA;
	
	@Autowired
	private TipoServicioDao tipoServicioJPA;
	
	@Autowired
	private UsuarioFoodTruckDao usuarioFoodTruckDaoJPA;
	
	public FoodTruckService() {
		super();
	}
	
	@Transactional
	public List<TipoServicio> getTodosLosTiposDeServicios() {
		return tipoServicioJPA.getAllInstances();
	}
	
	@Transactional
	public UsuarioFoodTruck getUsuarioFoodTruckPorId(long id) {
		UsuarioFoodTruck usuario = usuarioFoodTruckDaoJPA.get(id);
		usuario.getFoodTruckers().size();
		return usuario;
	}
	
	@Transactional
	public void crearFoodTruck(UsuarioFoodTruck usuario, FoodTruckDTO foodTruckDTO) {
		
		TipoServicio tipoServicio = tipoServicioJPA.get(Long.valueOf(foodTruckDTO.getTipoServicio()));
		
		FoodTruck foodTruck = new FoodTruck(); 
		foodTruck.setNombre(foodTruckDTO.getNombre());
		foodTruck.setDescripcion(foodTruckDTO.getDescripcion());
		foodTruck.setTipoServicio(tipoServicio);
		foodTruck.setUrl(foodTruckDTO.getUrl());
		foodTruck.setWhatsapp(foodTruckDTO.getWhatsapp());
		foodTruck.setTwitter(foodTruckDTO.getTwitter());
		foodTruck.setInstagram(foodTruckDTO.getInstagram());
		
		UsuarioFoodTruck usuario2 = usuarioFoodTruckDaoJPA.get(usuario.getId());
		usuario2.getFoodTruckers().size();
		usuario2.getFoodTruckers().add(foodTruck);
		this.usuarioFoodTruckDaoJPA.save(usuario2);
	}
	
	@Transactional
	public List<FoodTruck> getTodosLosFoodTrucksPorUsuarioFT(long idFoodTrucker) {
		UsuarioFoodTruck usuario = usuarioFoodTruckDaoJPA.get(idFoodTrucker);
		usuario.getFoodTruckers().size();
		return usuario.getFoodTruckers();
	}
	
	@Transactional
	public UsuarioFoodTruck getUsuarioFoodTruckPorFoodTruck (long idFoodTruck) {
		UsuarioFoodTruck usuario = usuarioFoodTruckDaoJPA.getUsuarioPorFoodTruck(idFoodTruck);
		usuario.getFoodTruckers().size();
		return usuario;
	}
	
	public void borrarFoodTruck(UsuarioFoodTruck usuario, long idFoodTruck) {
		Iterator<FoodTruck> i = usuario.getFoodTruckers().iterator();
		while(i.hasNext()) {     
			FoodTruck ft = i.next();     
		    System.out.println(ft);
		    if (idFoodTruck == ft.getId()) {
		        i.remove();
		    } 
		}
		usuarioFoodTruckDaoJPA.update(usuario);
	}
	
	public FoodTruck getFoodTruckPorId(long idFoodTruck) {
		return this.foodTruckDaoJPA.get(idFoodTruck);
	}
	
	public void actualizarFoodTruck(FoodTruck foodTruck, FoodTruckDTO foodTruckDTO) {
		TipoServicio tipoServicio = tipoServicioJPA.get(Long.valueOf(foodTruckDTO.getTipoServicio()));
		foodTruck.setDescripcion(foodTruckDTO.getDescripcion());
		foodTruck.setInstagram(foodTruckDTO.getInstagram());
		foodTruck.setNombre(foodTruckDTO.getNombre());
		foodTruck.setTipoServicio(tipoServicio);
		foodTruck.setTwitter(foodTruckDTO.getTwitter());
		foodTruck.setUrl(foodTruckDTO.getUrl());
		foodTruck.setWhatsapp(foodTruckDTO.getWhatsapp());
		this.foodTruckDaoJPA.update(foodTruck);
		
	}
}
