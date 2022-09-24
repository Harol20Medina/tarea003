package tarea003.tarea003.Daoimpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import tarea003.tarea003.Constantes;
import tarea003.tarea003.Dao.Todo;
import tarea003.tarea003.Entity.Detalle;

@Component
public class DetalleDaoImpl implements Todo<Detalle>{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int create(Detalle t) {
		String query = "INSERT INTO detalle(idlibro, idprestamo, estado) VALUES(?,?,?)";
		
		return jdbcTemplate.update(query, t.getIdLibro(), t.getIdPrestamo(), Constantes.PRESTAMO_REALIZADO);
	}

	@Override
	public int update(Detalle t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Detalle read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Detalle> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> readAll2() {
		// TODO Auto-generated method stub
		return null;
	}

}
