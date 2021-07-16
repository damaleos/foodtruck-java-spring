package ttps.spring.dao.implementaciones;

import ttps.spring.dao.EventoDao;

import ttps.spring.dao.FotoDao;
import ttps.spring.dao.SolicitudServicioDao;
import ttps.spring.dao.TipoEventoDao;
import ttps.spring.dao.TipoServicioDao;
import ttps.spring.dao.UsuarioEventoDao;
import ttps.spring.dao.UsuarioFoodTruckDao;
import ttps.spring.dao.ValoracionServicioDao;

public class DaoFactory {

	public static TipoEventoDao getTipoEventoDAO() {
		return new TipoEventoDaoJPA();
	}
	
	public static EventoDao getEventoDAO() {
		return new EventoDaoJPA();
	}
	
	public static FotoDao getFotoDAO() {
		return new FotoDaoJPA();
	}
	
	public static SolicitudServicioDao getSolicitudServicioDAO() {
		return new SolicitudServicioDaoJPA();
	}
	
	public static TipoServicioDao getTipoServicioDAO() {
		return new TipoServicioDaoJPA();
	}
	
	public static UsuarioEventoDao getUsuarioEventoDAO() {
		return new UsuarioEventoDaoJPA();
	}
	
	public static UsuarioFoodTruckDao getUsuarioFoodTruckDAO() {
		return new UsuarioFoodTruckDaoJPA();
	}
	
	public static ValoracionServicioDao getValoracionServicioDAO() {
		return new ValoracionServicioDaoJPA();
	}
	

}
