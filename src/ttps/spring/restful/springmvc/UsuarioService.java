package ttps.spring.restful.springmvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ttps.spring.dao.UsuarioEventoDao;
import ttps.spring.dao.UsuarioFoodTruckDao;
import ttps.spring.model.TipoUsuario;
import ttps.spring.model.Usuario;
import ttps.spring.model.UsuarioEvento;
import ttps.spring.model.UsuarioFoodTruck;

@Service("usuarioService")
public class UsuarioService {
	
	@Autowired
	private UsuarioEventoDao usuarioEventoDaoJPA;
	@Autowired
	private UsuarioFoodTruckDao usuarioFoodTruckDaoJPA;
	
	public UsuarioService() {
		super();
	}
	
	public List<UsuarioEvento> getTodosLosUsuariosEvento() {
		return usuarioEventoDaoJPA.getAllInstances();
		
	}
	
	public Usuario getUsuarioPorId(long id) {
		Usuario u = usuarioEventoDaoJPA.get(id);
		if (u == null) {
			u = usuarioFoodTruckDaoJPA.get(id);
		}
		return u;
	}
	
	public void actualizarUsuario (Usuario usuario) {
		if (TipoUsuario.FOOD_TUCKER.equals(usuario.getTipo())) {
			usuarioFoodTruckDaoJPA.update((UsuarioFoodTruck) usuario);
		}else {
			usuarioEventoDaoJPA.update((UsuarioEvento) usuario);
		}
	}

	public boolean existeUsuario(String username) {
		return getUsuarioPorUsername(username) != null;
	}
	
	public Usuario getUsuarioPorUsername(String username) {
		Usuario u = usuarioEventoDaoJPA.getUsuarioPorUsername(username);
		if (u == null) {
			u = usuarioFoodTruckDaoJPA.getUsuarioPorUsername(username);
		}
		return u;
	}
	
	public void crearUsuario (Usuario usuario) {
		if (TipoUsuario.ORG_EVENTOS.equals(usuario.getTipo())) {
			usuarioEventoDaoJPA.save((UsuarioEvento) usuario);
		} else {
			usuarioFoodTruckDaoJPA.save((UsuarioFoodTruck) usuario);
		}
	}
}
