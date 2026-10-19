package edu.ucam.dad1.universidad;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.List;

import edu.ucam.domain.*;

public class Universidad extends UnicastRemoteObject implements IUniversidad{
	
	public HashMap<String, Titulacion> titulaciones = new HashMap<String, Titulacion>();
	public HashMap<String, Asignatura> asignaturas = new HashMap<String, Asignatura>();
	public HashMap<String, Matricula> matriculas = new HashMap<String, Matricula>();
	
	public Universidad() throws RemoteException{
		super();
	}

	@Override
	public boolean autenticacion(String usuario, String password) throws RemoteException {
		return usuario.equals("admin") && password.equals("admin");
	}

	//Titulaciones
	@Override
	public boolean addTit(Titulacion t) throws RemoteException {
		if(titulaciones.containsKey(t.getId())) {
			return false;
		}
		titulaciones.put(t.getId(), t);
		return true;
	}

	@Override
	public boolean updateTit(String id, String nombre) throws RemoteException {
		Titulacion t = titulaciones.get(id);
		if(t == null) return false;
		
		t.setNombre(nombre);
		return true;
	}

	@Override
	public Titulacion getTit(String id) throws RemoteException {
		Titulacion t = titulaciones.get(id);
		if(t == null) {
			return null;
		}
		else {
			return t;
		}
	}

	@Override
	public boolean removeTit(String id) throws RemoteException {
		Titulacion t = titulaciones.get(id);
		if(t == null) return false;
		
		titulaciones.remove(id);
		return true;
	}

	@Override
	public List<String> listTit() throws RemoteException {
		List<String> lista = new ArrayList<String>();
		
		if(titulaciones.isEmpty()) return null;
		for(Titulacion t: titulaciones.values()) {
			lista.add(t.getNombre());
		}
		return lista;
	}

	@Override
	public int countTit() throws RemoteException {
		return titulaciones.size();
	}

	//Asignaturas
	@Override
	public boolean addAsig(Asignatura a) throws RemoteException {
		if(asignaturas.containsKey(a.getId())) {
			return false;
		}
		asignaturas.put(a.getId(), a);
		return true;
	}

	@Override
	public Asignatura getAsig(String id) throws RemoteException {
		Asignatura a = asignaturas.get(id);
		if(a == null) {
			return null;
		}
		else {
			return a;
		}
	}

	@Override
	public boolean removeAsig(String id) throws RemoteException {
		Asignatura a = asignaturas.get(id);
		if(a == null) return false;
		
		asignaturas.remove(id);
		
		for(Titulacion t : titulaciones.values()) {
			t.removeAsignatura(asignaturas.get(id));
		}
		return true;
	}

	@Override
	public List<String> listAsig() throws RemoteException {
		List<String> lista = new ArrayList<String>();
		if(asignaturas.isEmpty()) return null;
		
		for(Asignatura a : asignaturas.values()) {
			lista.add(a.getNombre());
		}
		return lista;
	}

	@Override
	public boolean addAsig2Tit(String idTit, String idAsig) throws RemoteException {
		Titulacion t = titulaciones.get(idTit);
		if(t == null) return false;
		if(asignaturas.get(idAsig) == null) return false;
		
		t.addAsignatura(asignaturas.get(idAsig));
		return true;
		
	}

	@Override
	public boolean removeAsigFromTit(String idTit, String idAsig) throws RemoteException {
		Titulacion t = titulaciones.get(idTit);
		if(t == null) return false;
		if(asignaturas.get(idAsig) == null) return false;
		
		t.removeAsignatura(asignaturas.get(idAsig));
		return true;
	}

	@Override
	public List<String> listaAsigFromTit(String id) throws RemoteException {
		List<String> lista = new ArrayList<String>();
		
		Titulacion t = titulaciones.get(id);
		if(t == null) return null;
		
		for(Asignatura a : t.getAsignaturas()) {
			lista.add(a.getNombre());
		}
		return lista;
	}

	//Matriculas
	@Override
	public boolean addMatricula(Matricula m) throws RemoteException {
		if(matriculas.containsKey(m.getId())) {
			return false;
		}
		matriculas.put(m.getId(), m);
		return true;
	}

	@Override
	public boolean updateMatricula(String id, Alumno al) throws RemoteException {
		Matricula m = matriculas.get(id);
		if(m == null) return false;
		
		m.setAlumno(al);
		return true;
	}

	@Override
	public Matricula getMatricula(String id) throws RemoteException {
		Matricula m = matriculas.get(id);
		if(m == null) {
			return null;
		}
		else {
			return m;
		}
	}

	@Override
	public boolean removeMatricula(String id) throws RemoteException {
		if(matriculas.get(id) == null) return false;
		matriculas.remove(id);
		return true;
	}	
}
