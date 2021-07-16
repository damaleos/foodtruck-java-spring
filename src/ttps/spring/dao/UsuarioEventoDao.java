package ttps.spring.dao;

import ttps.spring.model.UsuarioEvento;

public interface UsuarioEventoDao extends GenericDao<UsuarioEvento>{

	
	public UsuarioEvento getUsuarioPorUsername (String username);

}
