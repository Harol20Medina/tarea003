package tarea003.tarea003.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tarea003.tarea003.Constantes;
import tarea003.tarea003.Entity.Prestamo;
import tarea003.tarea003.Service.PrestamoService;

@RestController
@RequestMapping("/api/prestamo")
// www.harol-code.com/api/prestamo
public class PrestamoController {
	
	@Autowired
	private PrestamoService prestamoService;
	
	@GetMapping("/saludar")
	// www.harol-code.com/api/prestamo/saludar
	public String hola() {
		return "chanchito feliz";
	}
	
	@PostMapping("/crear")
	public ResponseEntity<?> prestar(@RequestBody Prestamo prestamo) {
		
		int idCreadoPorBD = 0;
		
		// validar que el alumno no tenga mas de 2 libros
		if (prestamo.getDetalles().size() > Constantes.MAX_LIBROS) {
			return new ResponseEntity<String>("Usted no puede llevar mas de 2 libros!", HttpStatus.BAD_REQUEST);
		}
		
		try {
			// crear el prestamo
			idCreadoPorBD = prestamoService.create(prestamo);			
		} catch (Exception e) {
			return new ResponseEntity<String>("Oops, pasó algo inesperado!! " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}		
		
		// decirle q todo esta OK
		prestamo.setIdPrestamo(idCreadoPorBD);
		
		return new ResponseEntity<Prestamo>(prestamo, HttpStatus.CREATED);
		
	}
	
	/*
	 * GEt -> para llamados o devolver algo
	 * POST -> para crear o logear
	 * PUT | PATCH -> para actulizar
	 * DELETE -> para eliminar
	 */
	@PutMapping("/devolver")
	public ResponseEntity< ? > devolver(@RequestBody Prestamo prestamo) { // si quieres solo el id o todo el objeto
		
		// VERIFICAR SI LOS LIBROS EXISTEN
		
		// ACTULIZAR EL PRESTAMOS A ESTRADO 1 CON SUS DETALLES Y A LOS LIBROS
		
		// METER ESA ACTUALZIACON EN UN TRY CATCH
		
		return new ResponseEntity<String>("Libros devueltos!", HttpStatus.OK);
	}

}
