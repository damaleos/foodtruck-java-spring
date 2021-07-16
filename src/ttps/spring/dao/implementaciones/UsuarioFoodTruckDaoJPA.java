package ttps.spring.dao.implementaciones;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import ttps.spring.dao.UsuarioFoodTruckDao;
import ttps.spring.model.UsuarioFoodTruck;

@Repository
public class UsuarioFoodTruckDaoJPA extends GenericDAOHibernateJPA<UsuarioFoodTruck> implements UsuarioFoodTruckDao {

	public UsuarioFoodTruckDaoJPA() {
		super(UsuarioFoodTruck.class);
	}

	@Override
	public UsuarioFoodTruck getUsuarioPorUsername(String username) {
		Query consulta = this.getEntityManager().createQuery("select e from "+ getPersistentClass().getSimpleName() + " e where e.idUsuario = :username");
		consulta.setParameter("username", username);
		return consulta.getResultList().isEmpty()? null : (UsuarioFoodTruck) consulta.getSingleResult();
	}

	@Override
	public UsuarioFoodTruck getUsuarioPorFoodTruck(long idFoodTruck) {
		Query consulta = this.getEntityManager().createQuery("select e from "+ getPersistentClass().getSimpleName() + " as e join e.foodTruckers as ft where ft.id = :idFoodTruck");
		consulta.setParameter("idFoodTruck", idFoodTruck);
		return consulta.getResultList().isEmpty()? null : (UsuarioFoodTruck) consulta.getSingleResult();
	}
}
