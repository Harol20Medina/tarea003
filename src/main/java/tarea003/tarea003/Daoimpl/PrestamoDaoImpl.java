package tarea003.tarea003.Daoimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Component;

import tarea003.tarea003.Constantes;
import tarea003.tarea003.Dao.Todo;
import tarea003.tarea003.Entity.Prestamo;

@Component
public class PrestamoDaoImpl implements Todo<Prestamo> {
	
	@Autowired
	private DataSource dataSource;

	@Override
	public int create(Prestamo t) {
		
		NamedParameterJdbcTemplate named = new NamedParameterJdbcTemplate(dataSource);
		GeneratedKeyHolder llaveRecuperar = new GeneratedKeyHolder();
		
		String query = "INSERT INTO prestamo(fecha_pres, fecha_dev, idempleado, idalumno, estado) VALUES(now(), :fecDev, :idEmpleado, :idAlumno, :estado)";
		
		Map<String, Object> map = new HashMap<>();
		map.put("fecDev", t.getFecDevolucion());
		map.put("idEmpleado", t.getIdEmpleado());
		map.put("idAlumno", t.getIdAlumno());
		map.put("estado", Constantes.PRESTAMO_REALIZADO);
		
		named.update(query, new MapSqlParameterSource(map), llaveRecuperar);
				
		// devueve el id que ha generado la bbdd
		return llaveRecuperar.getKey().intValue();
		
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
