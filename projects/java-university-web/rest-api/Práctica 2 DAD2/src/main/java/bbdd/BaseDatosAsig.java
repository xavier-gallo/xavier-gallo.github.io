package bbdd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import beans.Asignatura;
import exceptions.ApiException;

public class BaseDatosAsig {
	private static Map <String, Asignatura> asignaturas = new HashMap<String, Asignatura>();
	
	public static Asignatura getAsig(String id) throws ApiException {
		Asignatura a = new Asignatura();
		if(asignaturas.containsKey(id)) {
			a = asignaturas.get(id);
			return a;
		}
		throw new ApiException( "La asignatura no existe", 404);
	}
	
	public static boolean insertarAsig(Asignatura a) throws ApiException{
		if(!asignaturas.containsKey(a.getId())) {
			asignaturas.put(a.getId(), a);
			return true;
		}
		throw new ApiException( "La asignatura ya existe", 409);
	}
	
	public static boolean borrarAsig(String id) throws ApiException {
		if(asignaturas.containsKey(id)) {
			asignaturas.remove(id);
			return true;
		}
		throw new ApiException( "La asignatura no existe", 404);
	}
	
	public static boolean modificarAsig(Asignatura a) throws ApiException{
		if(asignaturas.containsKey(a.getId())) {
			asignaturas.put(a.getId(), a);
			return true;
		}
		throw new ApiException( "La asignatura no existe", 404);
	}
	
	public static List<Asignatura> listar(){
		List<Asignatura> lista = new ArrayList<Asignatura>();
		for(Asignatura a : asignaturas.values()) {
			lista.add(a);
		}
		return lista;
	}
}
