package edu.ucam.dad1.universidad;

import java.rmi.RemoteException;
import java.util.List;

import edu.ucam.domain.*;

public interface IUniversidad extends java.rmi.Remote{
	public boolean autenticacion(String usuario, String password) throws RemoteException;
	
	public boolean addTit(Titulacion t) throws RemoteException;
	public boolean updateTit(String id, String nombre) throws RemoteException;
	public Titulacion getTit(String id) throws RemoteException;
	public boolean removeTit(String id) throws RemoteException;
	public List<String> listTit() throws RemoteException;
	public int countTit() throws RemoteException;
	
	public boolean addAsig(Asignatura a) throws RemoteException;
	public Asignatura getAsig(String id) throws RemoteException;
	public boolean removeAsig(String id) throws RemoteException;
	public List<String> listAsig() throws RemoteException;
	public boolean addAsig2Tit(String idTit, String idAsig) throws RemoteException;
	public boolean removeAsigFromTit(String idTit, String idAsig) throws RemoteException;
	public List<String> listaAsigFromTit(String id) throws RemoteException;
	
	public boolean addMatricula(Matricula m) throws RemoteException;
	public boolean updateMatricula(String id, Alumno al) throws RemoteException;
	public Matricula getMatricula(String id) throws RemoteException;
	public boolean removeMatricula(String id) throws RemoteException;
}
