package ttps.spring.dao.implementaciones;

import org.springframework.stereotype.Repository;

import ttps.spring.dao.ValoracionServicioDao;
import ttps.spring.model.ValoracionServicio;

@Repository
public class ValoracionServicioDaoJPA  extends GenericDAOHibernateJPA<ValoracionServicio> implements ValoracionServicioDao {

	public ValoracionServicioDaoJPA() {
		super(ValoracionServicio.class);
	}

}
