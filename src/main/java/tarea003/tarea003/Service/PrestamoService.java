package tarea003.tarea003.Service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tarea003.tarea003.Constantes;
import tarea003.tarea003.Dao.Todo;
import tarea003.tarea003.Daoimpl.DetalleDaoImpl;
import tarea003.tarea003.Daoimpl.LibroDaoImpl;
import tarea003.tarea003.Daoimpl.PrestamoDaoImpl;
import tarea003.tarea003.Entity.Prestamo;

@Service
public class PrestamoService implements Todo<Prestamo> {
	
	@Autowired
	private PrestamoDaoImpl prestamoDao;
	
	@Autowired
	private DetalleDaoImpl detalleDao;
	
	@Autowired
	private LibroDaoImpl libroDao;

	@Override
	@Transactional //  en caso de que haya un error le hace rollback y si no le hace commit
	public int create(Prestamo t) {
		
		int idGenerado = prestamoDao.create(t);
		
		t.getDetalles().forEach( detalle -> {
			
			// cramos el detalle del prestamo
			detalle.setIdPrestamo(idGenerado);
			detalleDao.create(detalle);
			
			// actualizamos el estado de los libro
			libroDao.updateEstado(detalle.getIdLibro(), Constantes.LIBRO_PRESTADO);
			
		});
		
		return idGenerado;
	}

	@Override
	public int update(Prestamo t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Prestamo read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Prestamo> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> readAll2() {
		// TODO Auto-generated method stub
		return null;
	}

}
