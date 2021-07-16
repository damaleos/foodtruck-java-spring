package ttps.spring.dao;

import ttps.spring.model.UsuarioFoodTruck;

public interface UsuarioFoodTruckDao extends GenericDao<UsuarioFoodTruck>{

	public UsuarioFoodTruck getUsuarioPorUsername (String username);
	
	public UsuarioFoodTruck getUsuarioPorFoodTruck (long idFoodTruck);
}
