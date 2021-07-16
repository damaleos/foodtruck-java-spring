package ttps.spring.dao.implementaciones;

import org.springframework.stereotype.Repository;

import ttps.spring.dao.FotoDao;

import ttps.spring.model.Foto;

@Repository
public class FotoDaoJPA extends GenericDAOHibernateJPA<Foto> implements FotoDao {

	public FotoDaoJPA() {
		super(Foto.class);
	}

}
