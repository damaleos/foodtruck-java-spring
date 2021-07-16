package ttps.spring.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T> {
	
	public T update(T entity);
	public void delete(T entity);
	public T delete(Serializable id);
	public boolean exist(Serializable id);
	public T save(T entity);
	public T get(Serializable id);
	public List<T> getAllInstances ();
	 
}
