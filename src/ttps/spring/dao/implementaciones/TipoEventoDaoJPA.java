package ttps.spring.dao.implementaciones;

import java.util.List;

import org.springframework.stereotype.Repository;

import ttps.spring.dao.TipoEventoDao;
import ttps.spring.model.TipoEvento;

@Repository
public class TipoEventoDaoJPA extends GenericDAOHibernateJPA<TipoEvento> implements TipoEventoDao {

	public TipoEventoDaoJPA() {
		super(TipoEvento.class);
	}

	@Override
	public List<TipoEvento> getTodosLosTiposDeEventos() {
		// TODO Auto-generated method stub
		return null;
	}

}
