package ttps.spring.dao.implementaciones;

import java.util.Date;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ttps.spring.dao.EventoDao;
import ttps.spring.dao.FotoDao;
import ttps.spring.dao.SolicitudServicioDao;
import ttps.spring.dao.TipoEventoDao;
import ttps.spring.dao.TipoServicioDao;
import ttps.spring.dao.UsuarioEventoDao;
import ttps.spring.dao.UsuarioFoodTruckDao;
import ttps.spring.dao.ValoracionServicioDao;
import ttps.spring.model.EstadoSolicitud;
import ttps.spring.model.Evento;
import ttps.spring.model.FormaPago;
import ttps.spring.model.Foto;
import ttps.spring.model.SolicitudServicio;
import ttps.spring.model.TipoEvento;
import ttps.spring.model.TipoServicio;
import ttps.spring.model.TipoUsuario;
import ttps.spring.model.UsuarioEvento;
import ttps.spring.model.UsuarioFoodTruck;
import ttps.spring.model.ValoracionServicio;

public class JPATest {
	
    private static final EntityManagerFactory emFactoryObj;
    private static final String PERSISTENCE_UNIT_NAME = "JPADemo";  
 
    static {
        emFactoryObj = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }
 
    // This Method Is Used To Retrieve The 'EntityManager' Object
    public static EntityManager getEntityManager() {
        return emFactoryObj.createEntityManager();
    }
 
    public static void main(String[] args) {
    	
    	TipoEventoDao dao = DaoFactory.getTipoEventoDAO();
    	TipoEvento obj = new TipoEvento();
    	obj.setNombre("Festival1");
    	dao.save(obj);
    	
    	TipoEvento obj0 = new TipoEvento();
    	obj0.setNombre("Festival2");
    	dao.save(obj0);
    	
    	System.out.println("Creacion - TipoEvento");
    	
    	obj0.setNombre("FestivalUpdate");
    	dao.update(obj0);
    	
    	System.out.println("Update - TipoEvento");
    	
    	
    	System.out.println("Get All Instances - TipoEvento: " + dao.getAllInstances().size());
    	
    	TipoEvento objBorrado = new TipoEvento();
    	objBorrado.setNombre("testborrar");
    	dao.save(objBorrado);
    	
    	dao.delete(objBorrado);
    	
    	System.out.println("Borrado - TipoEvento");
    	
    	
    	TipoServicioDao dao2 = DaoFactory.getTipoServicioDAO();
    	TipoServicio obj2 = new TipoServicio();
    	obj2.setNombre("Servicio1");
    	dao2.save(obj2);
    	
    	System.out.println("Creacion - TipoServicio");
    	
    	UsuarioEventoDao dao3 = DaoFactory.getUsuarioEventoDAO();
    	UsuarioEvento obj3 = new UsuarioEvento();
    	obj3.setIdUsuario("pepe");
    	obj3.setEmail("pepe@pepe.com");
    	obj3.setNombreComercial("El Pepe");
    	obj3.setPassword("1234");
    	obj3.setTipo(TipoUsuario.ORG_EVENTOS);
    	dao3.save(obj3);
    	
    	System.out.println("Creacion - UsuarioEvento");
    	
    	UsuarioFoodTruckDao dao4 = DaoFactory.getUsuarioFoodTruckDAO();
    	UsuarioFoodTruck obj4 = new UsuarioFoodTruck();
    	obj4.setIdUsuario("pepe");
    	obj4.setEmail("pepe@pepe.com");
    	obj4.setPassword("1234");
    	obj4.setTipo(TipoUsuario.FOOD_TUCKER);
    	//obj4.setDescripcion("asdasdasdasd");
    	//obj4.setTipoServicio(obj2);
    	dao4.save(obj4);
    	
    	System.out.println("Creacion - UsuarioFoodTruck");
    	
    	EventoDao dao5 = DaoFactory.getEventoDAO();
    	Evento obj5 = new Evento();
    	obj5.setCodPostal("1888");
    	obj5.setCoordinador(obj3);
    	obj5.setDescripcion("Evento Test");
    	obj5.setEmail("fiestaloca@unlp.com.ar");
    	obj5.setFecha(new Date());
    	obj5.setFormaPago(FormaPago.CONSUMIDOR);
    	obj5.setGeolocalizacion("65554545454545454");
    	obj5.setProvincia("Buenos Aires");
    	obj5.setTelefono("52555555");
    	obj5.setTipoEvento(obj);
    	dao5.save(obj5);
    	
    	System.out.println("Creacion - Evento");
    	
    	FotoDao dao6 = DaoFactory.getFotoDAO();
    	Foto obj6 = new Foto();
    	obj6.setIndex(1);
    	obj6.setNombre("Logo");
    	//obj6.setPropietario(obj4);
    	obj6.setDato("ruta");
    	dao6.save(obj6);
    	
    	//obj4.getFotos().add(obj6);
    	dao4.update(obj4);
    	
    	Foto obj6_ = new Foto();
    	obj6_.setIndex(2);
    	obj6_.setNombre("OtraFoto");
    	//obj6_.setPropietario(obj4);
    	obj6_.setDato("ruta");
    	dao6.save(obj6_);
    	
    	obj4 = dao4.get(obj4.getId());
    	//obj4.getFotos().add(obj6_);
    	dao4.update(obj4);
    	
    	System.out.println("Creacion - Foto");
    	
    	UsuarioFoodTruck usuario = dao4.get(obj4.getId());

    	//System.out.println("Fotos del propietario: " + usuario.getFotos().size());
    	
    	//usuario.getFotos().remove(0);
    	dao4.update(usuario);
    	
    	System.out.println("Borrado de foto en coleccion");
    	
    	//System.out.println("Fotos del propietario: " + dao4.get(obj4.getId()).getFotos().size());
    	
    	SolicitudServicioDao dao7 = DaoFactory.getSolicitudServicioDAO();
    	SolicitudServicio obj7 = new SolicitudServicio();
    	obj7.setEstado(EstadoSolicitud.PENDIENTE);
    	obj7.setEvento(obj5);
    	obj7.setFoodTrucker(obj4);
    	dao7.save(obj7);
    	
    	System.out.println("Creacion - SolicitudServicio");
    	
    	obj7.setEstado(EstadoSolicitud.ACEPTADO);
    	obj7.setValoracionHabilitada(true);
    	dao7.update(obj7);
    	
    	System.out.println("Update - SolicitudServicio");
    	
    	ValoracionServicioDao dao8 = DaoFactory.getValoracionServicioDAO();
    	ValoracionServicio obj8 = new ValoracionServicio();
    	obj8.setServicio(obj7);
    	obj8.setCalidadPrecio(1);
    	dao8.save(obj8);
    	
    	System.out.println("Creacion - ValoracionServicio");
    	
        /*EntityManager entityMgr = getEntityManager();
        entityMgr.getTransaction().begin();
 
        TipoEvento obj = new TipoEvento();
        obj.setNombre("Festival");
        entityMgr.persist(obj);
 
        entityMgr.getTransaction().commit();
 
        entityMgr.clear();*/
        System.out.println("Record Successfully Inserted In The Database");
    }

}
