package ttps.spring.dao.implementaciones;

import org.springframework.stereotype.Repository;

import ttps.spring.dao.TipoServicioDao;
import ttps.spring.model.TipoServicio;

@Repository
public class TipoServicioDaoJPA extends GenericDAOHibernateJPA<TipoServicio> implements TipoServicioDao {

	public TipoServicioDaoJPA() {
		super(TipoServicio.class);
	}

}
