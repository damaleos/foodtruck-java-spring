package ttps.spring.restful.springmvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ttps.spring.model.TipoUsuario;
import ttps.spring.model.Usuario;
import ttps.spring.model.UsuarioEvento;
import ttps.spring.model.UsuarioFoodTruck;

@RestController
@RequestMapping(value = "/usuarios", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class UsuarioRestController {

	@Autowired
	private UsuarioService usuarioService;
	

	@GetMapping
	public ResponseEntity<List<UsuarioEvento>> getTodosLosUsuariosEvento() {
		List<UsuarioEvento> users = usuarioService.getTodosLosUsuariosEvento();
		if(users.isEmpty()){
			return new ResponseEntity<List<UsuarioEvento>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<UsuarioEvento>>(users, HttpStatus.OK);
	}
	
	/*
	 * Obtención de datos del usuario
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> getUsuario(@PathVariable("id") long id) {
		Usuario user = usuarioService.getUsuarioPorId(id);
		if (user == null) {
			System.out.println("Usuario con id " + id + " no encontrado");
			return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Usuario>(user, HttpStatus.OK);
	}

	/*
	 * Registración de usuario nuevo
	 */
//	@PostMapping(path = "/registracionFoodTruck", consumes = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<Void> registrarNuevoUsuario(@RequestBody UsuarioFoodTruck user) {
//		System.out.println("Creando el usuario " + user.getIdUsuario());
//		if (usuarioService.existeUsuario(user.getIdUsuario())) {
//			System.out.println("Ya existe un usuario con nombre " + user.getIdUsuario());
//			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//		}
//		user.setTipo(TipoUsuario.FOOD_TUCKER);
//		usuarioService.crearUsuario(user);
//		return new ResponseEntity<Void>(HttpStatus.CREATED);
//	}
	
	/*
	 * Registración de usuario nuevo
	 */
//	@PostMapping(path = "/registracionEvento", consumes = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<Void> registrarNuevoUsuario(@RequestBody UsuarioEvento user) {
//		System.out.println("Creando el usuario " + user.getIdUsuario());
//		if (usuarioService.existeUsuario(user.getIdUsuario())) {
//			System.out.println("Ya existe un usuario con nombre " + user.getIdUsuario());
//			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//		}
//		user.setTipo(TipoUsuario.ORG_EVENTOS);
//		usuarioService.crearUsuario(user);
//		return new ResponseEntity<Void>(HttpStatus.CREATED);
//	}
	
	@PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> registrarNuevoUsuario(@RequestBody UsuarioDTO user) {
		System.out.println("Creando el usuario " + user.getIdUsuario());
		if (usuarioService.existeUsuario(user.getIdUsuario())) {
			System.out.println("Ya existe un usuario con nombre " + user.getIdUsuario());
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		if (TipoUsuario.FOOD_TUCKER.name().equals(user.getTipo())) {
			UsuarioFoodTruck usuarioFoodTruck = new UsuarioFoodTruck(user);
			usuarioService.crearUsuario(usuarioFoodTruck);
		}else {
			UsuarioEvento usuarioevento = new UsuarioEvento(user);
			usuarioService.crearUsuario(usuarioevento);
		}
		return new ResponseEntity<Void>(HttpStatus.CREATED);		
	}
	
	/*
	 * Actualización de usuario
	 */
//	@PutMapping("/usuarioFoodTruck/{id}")
//	public ResponseEntity<Usuario> actualizarUsuario(@PathVariable("id") long id, @RequestBody UsuarioFoodTruck user) {
//		System.out.println("Actualizando el usuarioFoodTruck " + id);
//
//		Usuario currentUser = usuarioService.getUsuarioPorId(id);
//
//		if (currentUser == null || !TipoUsuario.FOOD_TUCKER.equals(currentUser.getTipo())) {
//			System.out.println("User with id " + id + " not found");
//			return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
//		}
//		currentUser.setEmail(user.getEmail());
//		currentUser.setPassword(user.getPassword());
//
//		usuarioService.actualizarUsuario(currentUser);
//		return new ResponseEntity<Usuario>(currentUser, HttpStatus.OK);
//	 }
	
	/*
	 * Actualización de usuario
	 */
//	@PutMapping("/usuarioEvento/{id}")
//	public ResponseEntity<Usuario> actualizarUsuario(@PathVariable("id") long id, @RequestBody UsuarioEvento user) {
//		System.out.println("Actualizando el usuarioEvento " + id);
//
//		Usuario currentUser = usuarioService.getUsuarioPorId(id);
//
//		if (currentUser == null || !TipoUsuario.ORG_EVENTOS.equals(currentUser.getTipo())) {
//			System.out.println("User with id " + id + " not found");
//			return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
//		}
//		currentUser.setEmail(user.getEmail());
//		currentUser.setPassword(user.getPassword());
//
//		usuarioService.actualizarUsuario(currentUser);
//		return new ResponseEntity<Usuario>(currentUser, HttpStatus.OK);
//	 }
	
	@PutMapping("/{id}")
	public ResponseEntity<UsuarioDTO> actualizarUsuario(@PathVariable("id") long id, @RequestBody UsuarioDTO user) {
		System.out.println("Actualizando el usuarioEvento " + id);

		Usuario currentUser = usuarioService.getUsuarioPorId(id);

		if (currentUser == null) {
			System.out.println("User with id " + id + " not found");
			return new ResponseEntity<UsuarioDTO>(HttpStatus.NOT_FOUND);
		}
		currentUser.setEmail(user.getEmail());
		currentUser.setPassword(user.getPassword());

		usuarioService.actualizarUsuario(currentUser);
		return new ResponseEntity<UsuarioDTO>(new UsuarioDTO(currentUser), HttpStatus.OK);
	 }

	/*
	 * Login del sistema debe responder a los perfiles de usuarios definidos en su prototipo 
	 */
	@PostMapping(path = "/login")
	public ResponseEntity<UsuarioDTO> login(@RequestBody LoginForm login) {
		System.out.println("Login " + login.getUsername() + " - " + login.getPassword());
		Usuario usuario = usuarioService.getUsuarioPorUsername(login.getUsername());
		if (usuario != null && usuario.getPassword().equals(login.getPassword())) {
			System.out.println("Login Aceptado");
			return new ResponseEntity<UsuarioDTO>(new UsuarioDTO(usuario), HttpStatus.ACCEPTED);
		} else {
			System.out.println("Login Password o Usuario incorrecto");
			return new ResponseEntity<UsuarioDTO>(new UsuarioDTO(), HttpStatus.CONFLICT); //Código de respuesta 409
		}
	}
	
	public UsuarioService getUsuarioService() {
		return usuarioService;
	}


	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	
}
