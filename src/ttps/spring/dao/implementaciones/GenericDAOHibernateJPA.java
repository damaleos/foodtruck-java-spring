package ttps.spring.dao.implementaciones;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import ttps.spring.dao.GenericDao;

@Transactional
public class GenericDAOHibernateJPA<T> implements GenericDao<T>{

	private EntityManager entityManager;
	
	@PersistenceContext
	public void setEntityManager(EntityManager em){
		this.entityManager = em;
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	 
	protected Class<T> persistentClass;
	
	public GenericDAOHibernateJPA(Class<T> clase) {
		this.persistentClass = clase;
	}

	@Override
	public T update(T entity) {
		this.getEntityManager().merge(entity);
		return entity;
	}

	@Override
	public void delete(T entity) {
		this.getEntityManager().remove(this.getEntityManager().merge(entity));
	}

	@Override
	public T delete(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exist(Serializable id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T save(T entity) {
		this.getEntityManager().persist(entity);
		return entity;
	}

	@Override
	public T get(Serializable id) {
		Query consulta = this.getEntityManager().createQuery("select e from "+ getPersistentClass().getSimpleName() + " e where e.id = :id " );
		consulta.setParameter("id", id);
		return consulta.getResultList().isEmpty()? null : (T) consulta.getSingleResult();
	}

	@Override
	public List<T> getAllInstances() {
		Query consulta = this.getEntityManager().createQuery("select e from "+ getPersistentClass().getSimpleName() + " e");
		return (List<T>)consulta.getResultList();
	}

	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	public void setPersistentClass(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}
	
	

	
}
