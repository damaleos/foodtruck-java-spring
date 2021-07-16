package ttps.spring.dao.implementaciones;

import org.springframework.stereotype.Repository;

import ttps.spring.dao.SolicitudServicioDao;
import ttps.spring.model.SolicitudServicio;

@Repository
public class SolicitudServicioDaoJPA extends GenericDAOHibernateJPA<SolicitudServicio> implements SolicitudServicioDao {

	public SolicitudServicioDaoJPA() {
		super(SolicitudServicio.class);
	}

}
