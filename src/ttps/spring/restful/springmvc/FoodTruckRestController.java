package ttps.spring.restful.springmvc;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ttps.spring.model.FoodTruck;
import ttps.spring.model.TipoServicio;
import ttps.spring.model.UsuarioFoodTruck;

@RestController
@RequestMapping(value = "/foodtrucks", produces = MediaType.APPLICATION_JSON_VALUE)
public class FoodTruckRestController {
	
	@Autowired
	private FoodTruckService foodTruckService;
	
	/*
	 * Alta de Food Trucks con todos los atributos definidos en el modelo
	 */
	@PutMapping("/crear/{id}")
	public ResponseEntity<Void> crearFoodTruck(@PathVariable("id") long id, @RequestBody FoodTruckDTO foodTruck) {
		UsuarioFoodTruck usuario = foodTruckService.getUsuarioFoodTruckPorId(id);
		if (usuario == null) {
			System.out.println("El usuario no existe");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		foodTruckService.crearFoodTruck(usuario, foodTruck);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	/*
	 * Listado de todos los Food Trucks de un Food Trucker particular.
	 */
	@GetMapping("/{id}")
	public ResponseEntity<List<FoodTruckDTO>> getFoodTrucksPorUsuarioFT(@PathVariable("id") long id) {
		System.out.println("Listando food trucks para " + id);
		List<FoodTruck> foodTrucks = foodTruckService.getTodosLosFoodTrucksPorUsuarioFT(id);
		List<FoodTruckDTO> foodtrucksDTO = foodTrucks.stream().map(ft -> new FoodTruckDTO(ft)).collect(Collectors.toList());
		return new ResponseEntity<List<FoodTruckDTO>>(foodtrucksDTO, HttpStatus.OK);
	}
	
	/*
	 * Listado de todos los Food Trucks de un Food Trucker particular.
	 */
	@GetMapping("/tiposervicios")
	public ResponseEntity<List<TipoServicio>> getTipoServicioList() {
		System.out.println("Listando tipos de servicios");
		List<TipoServicio> tiposServicios = foodTruckService.getTodosLosTiposDeServicios();
		return new ResponseEntity<List<TipoServicio>>(tiposServicios, HttpStatus.OK);
	}
	
	/*
	 * Borrado de Food Truck
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<FoodTruck> deleteFoodTruck(@PathVariable("id") long id) {
		// buscar usuario y borrarlo el food truck de su lista.
		System.out.println("Obteniendo y eliminando foodTruck " + id);
		UsuarioFoodTruck user = foodTruckService.getUsuarioFoodTruckPorFoodTruck(id);
		if (user == null) {
			System.out.println("No es posible eliminar, no se encuentra el usuario con id " + id);
			return new ResponseEntity<FoodTruck>(HttpStatus.NOT_FOUND);
		}
		foodTruckService.borrarFoodTruck(user, id);
		return new ResponseEntity<FoodTruck>(HttpStatus.NO_CONTENT);
	}
	
	/*
	 * Actualización de un Food Truck
	 */
	@PutMapping("/actualizar/{id}")
	public ResponseEntity<FoodTruck> updateFoodTruck(@PathVariable("id") long id, @RequestBody FoodTruckDTO foodTruck) {
		System.out.println("Actualizando el usuario " + id);

		FoodTruck currentFoodTruck = foodTruckService.getFoodTruckPorId(id);

		if (currentFoodTruck == null) {
			System.out.println("User with id " + id + " not found");
			return new ResponseEntity<FoodTruck>(HttpStatus.NOT_FOUND);
		}
		

		foodTruckService.actualizarFoodTruck(currentFoodTruck, foodTruck);
		return new ResponseEntity<FoodTruck>(currentFoodTruck, HttpStatus.OK);
	 }
}
