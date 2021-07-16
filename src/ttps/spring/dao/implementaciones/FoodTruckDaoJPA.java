package ttps.spring.dao.implementaciones;

import org.springframework.stereotype.Repository;

import ttps.spring.dao.FoodTruckDao;
import ttps.spring.model.FoodTruck;

@Repository
public class FoodTruckDaoJPA extends GenericDAOHibernateJPA<FoodTruck> implements FoodTruckDao {

		public FoodTruckDaoJPA() {
			super(FoodTruck.class);
		}

}
