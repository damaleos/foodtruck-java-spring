package ttps.spring.dao.implementaciones;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import ttps.spring.dao.UsuarioEventoDao;
import ttps.spring.model.UsuarioEvento;

@Repository("usuarioEventoDaoJPA")
public class UsuarioEventoDaoJPA extends GenericDAOHibernateJPA<UsuarioEvento> implements UsuarioEventoDao {

	public UsuarioEventoDaoJPA() {
		super(UsuarioEvento.class);
	}
	
	@Override
	public UsuarioEvento getUsuarioPorUsername(String username) {
		Query consulta = this.getEntityManager().createQuery("select e from "+ getPersistentClass().getSimpleName() + " e where e.idUsuario = :username");
		consulta.setParameter("username", username);
		return consulta.getResultList().isEmpty()? null : (UsuarioEvento) consulta.getSingleResult();
	}

}
