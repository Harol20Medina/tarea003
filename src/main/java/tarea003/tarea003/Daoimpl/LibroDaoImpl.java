package tarea003.tarea003.Daoimpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import tarea003.tarea003.Dao.Todo;
import tarea003.tarea003.Entity.Libro;

@Component
public class LibroDaoImpl implements Todo<Libro> {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int create(Libro t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Libro t) {
		return 0;
	}
	
	public int updateEstado(int idLibro, int estadoIn) {
		String query = "UPDATE libro SET estado = " + estadoIn + " WHERE idlibro = " + idLibro;
		return jdbcTemplate.update(query);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Libro read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Libro> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> readAll2() {
		// TODO Auto-generated method stub
		return null;
	}

}
