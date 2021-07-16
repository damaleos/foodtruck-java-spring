package ttps.spring.dao.implementaciones;

import org.springframework.stereotype.Repository;

import ttps.spring.dao.EventoDao;

import ttps.spring.model.Evento;
@Repository
public class EventoDaoJPA extends GenericDAOHibernateJPA<Evento> implements EventoDao {

	public EventoDaoJPA() {
		super(Evento.class);
	}

}
