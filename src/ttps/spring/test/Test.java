package ttps.spring.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ttps.spring.dao.FoodTruckDao;
import ttps.spring.dao.FotoDao;
import ttps.spring.dao.TipoEventoDao;
import ttps.spring.dao.TipoServicioDao;
import ttps.spring.dao.UsuarioEventoDao;
import ttps.spring.dao.UsuarioFoodTruckDao;
import ttps.spring.dao.implementaciones.DaoFactory;
import ttps.spring.model.FoodTruck;
import ttps.spring.model.Foto;
import ttps.spring.model.TipoEvento;
import ttps.spring.model.TipoServicio;
import ttps.spring.model.TipoUsuario;
import ttps.spring.model.UsuarioEvento;
import ttps.spring.model.UsuarioFoodTruck;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();

		//registra una o más componentes que serán procesadas
		ctx.register(ttps.spring.config.PersistenceConfig.class);
		//Busca clases anotadas en el paquete base pasado por parámetro
		ctx.scan("ttps");
		ctx.refresh();
		
		/*
		TipoEventoDao tipoEventoDAO = ctx.getBean("tipoEventoDaoJPA", TipoEventoDao.class);
		System.out.println(tipoEventoDAO.getAllInstances());
		
		TipoEvento tipoEvento = new TipoEvento();
		tipoEvento.setNombre("Festival4");
    	tipoEventoDAO.save(tipoEvento);
    	
    	tipoEvento.setNombre("FestivalUpdate");
    	tipoEventoDAO.update(tipoEvento);
    	
    	TipoEvento objBorrado = new TipoEvento();
    	objBorrado.setNombre("testborrar");
    	tipoEventoDAO.save(objBorrado);
    	
    	tipoEventoDAO.delete(objBorrado);
    	
    	System.out.println(tipoEventoDAO.get(tipoEvento.getId()).getNombre());
    	*/
    	
    	/*UsuarioEventoDao usuarioEventoDao = ctx.getBean("usuarioEventoDaoJPA", UsuarioEventoDao.class);
    	UsuarioEvento obj3 = new UsuarioEvento();
    	obj3.setIdUsuario("pepe");
    	obj3.setEmail("pepe@pepe.com");
    	obj3.setNombreComercial("El Pepe");
    	obj3.setPassword("1234");
    	obj3.setTipo(TipoUsuario.ORG_EVENTOS);
    	usuarioEventoDao.save(obj3);
    	*/
    	TipoServicioDao dao2 = ctx.getBean("tipoServicioDaoJPA", TipoServicioDao.class);
    	TipoServicio obj2 = new TipoServicio();
    	obj2.setNombre("Servicio1");
    	dao2.save(obj2);
    	
    	
    	UsuarioFoodTruckDao dao4 = ctx.getBean("usuarioFoodTruckDaoJPA", UsuarioFoodTruckDao.class);
    	UsuarioFoodTruck obj4 = new UsuarioFoodTruck();
    	obj4.setIdUsuario("pepe333");
    	obj4.setEmail("pepe@pepe.com");
    	obj4.setPassword("1234");
    	obj4.setTipo(TipoUsuario.FOOD_TUCKER);
    	obj4.setNombreContacto("Sebastian");
    	//obj4.setDescripcion("asdasdasdasd");
    	dao4.save(obj4);
    	
    	
    	
    	FoodTruckDao dao6 = ctx.getBean("foodTruckDaoJPA", FoodTruckDao.class);
    	FoodTruck obj6 = new FoodTruck();
    	obj6.setNombre("Tacos Bell2");
    	obj6.setUrl("asdasdasdasd");
    	obj6.setTipoServicio(obj2);
    	dao6.save(obj6);
    	
    	obj4.getFoodTruckers().add(obj6);
    	dao4.update(obj4);
	}

}
