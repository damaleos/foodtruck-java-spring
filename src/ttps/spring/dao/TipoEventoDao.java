package ttps.spring.dao;

import java.util.List;


import ttps.spring.model.TipoEvento;

public interface TipoEventoDao extends GenericDao<TipoEvento>{

	public List<TipoEvento> getTodosLosTiposDeEventos();
	
	
}
