package ttps.spring.dao.implementaciones;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MyEntityManagerFactory {

	private static final EntityManagerFactory em = Persistence.createEntityManagerFactory("JPADemo");

	public static EntityManagerFactory getEMF() {
		return em;
	}
}
