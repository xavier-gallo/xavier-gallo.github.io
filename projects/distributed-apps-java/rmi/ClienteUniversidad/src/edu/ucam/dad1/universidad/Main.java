package edu.ucam.dad1.universidad;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.Naming;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.ucam.domain.*;

public class Main {

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException{
		try {
			IUniversidad universidad = (IUniversidad)Naming.lookup("rmi://localhost:1010/ServidorUniversidad");
			System.out.println("Cliente conectado al servidor.");
			Scanner scanner = new Scanner(System.in);
			boolean sesionIniciada = false;
			int opcion = 0, creditos;
			String bufferId, bufferNombre, bufferApellidos, bufferDni, buffer2;
			while(!sesionIniciada) {
				System.out.println("Indique el usuario: ");
				String usuario = scanner.nextLine();
				System.out.println("Indique la contraseña");
				String contraseña = scanner.nextLine();
				if(universidad.autenticacion(usuario, contraseña)) {
					sesionIniciada = true;
					System.out.println("Se ha iniciado la sesión correctamente.");
				}
				else {
					System.out.println("Credenciales incorrectas. No se ha podido iniciar sesión.");
				}
			}
			
			while(opcion != 18) {
				opcion = (new Main()).menu();
				switch(opcion) {
				case 0:
					break;
				case 1:
					Titulacion t = new Titulacion();
					System.out.println("Escribe el nombre de la titulación:");
					bufferNombre = scanner.nextLine();
					System.out.println("Escribe su ID");
					bufferId = scanner.nextLine();
					t.setNombre(bufferNombre);
					t.setId(bufferId);
					if(universidad.addTit(t)) {
						System.out.println("Se ha añadido correctamente.");
					}
					else {
						System.out.println("No se ha podido añadir.");
					}
					break;
				case 2:
					System.out.println("Escribe su ID");
					bufferId = scanner.nextLine();
					System.out.println("¿Cuál será su nuevo nombre?");
					bufferNombre = scanner.nextLine();
					if(universidad.updateTit(bufferId, bufferNombre)) {
						System.out.println("Se ha actualizado correctamente.");
					}
					else {
						System.out.println("No se ha podido actualizar.");
					}
					break;
				case 3:
					System.out.println("Escribe su ID");
					bufferId = scanner.nextLine();
					Titulacion ti = universidad.getTit(bufferId);
					if(ti == null) {
						System.out.println("No existe esa titulación");
						break;
					}
					System.out.println("Titulacion: " + ti.getNombre());
					break;
					
				case 4:
					System.out.println("Escribe su ID");
					bufferId = scanner.nextLine();
					if(universidad.removeTit(bufferId)) {
						System.out.println("Se ha borrado correctamente.");
					}
					else {
						System.out.println("No se ha podido borrar.");
					}
					break;
					
				case 5:
					List<String> titIntroducidas = universidad.listTit();
					if(titIntroducidas == null) {
						System.out.println("No hay titulaciones");
						break;
					}
					for(String s : titIntroducidas) {
						System.out.println(s);
					}
					break;
					
				case 6:
					System.out.println("Número de titulaciones: " + universidad.countTit());
					break;
					
				case 7:
					Asignatura a = new Asignatura();
					System.out.println("Escribe el nombre de la asignatura:");
					bufferNombre = scanner.nextLine();
					System.out.println("Escribe su ID");
					bufferId = scanner.nextLine();
					System.out.println("¿Cuántos creditos vale?");
					creditos = scanner.nextInt();
					a.setCreditos(creditos);
					a.setId(bufferId);
					a.setNombre(bufferNombre);
					if(universidad.addAsig(a)) {
						System.out.println("Se ha añadido correctamente.");
					}
					else {
						System.out.println("No se ha podido añadir.");
					}
					break;
					
				case 8:
					System.out.println("Escribe su ID");
					bufferId = scanner.nextLine();
					Asignatura as= universidad.getAsig(bufferId);
					if(as == null) {
						System.out.println("No existe esa asignatura");
						break;
					}
					System.out.println("Asignatura: " + as.getNombre());
					break;
					
				case 9:
					System.out.println("Escribe su ID");
					bufferId = scanner.nextLine();
					if(universidad.removeAsig(bufferId)) {
						System.out.println("Se ha borrado correctamente.");
					}
					else {
						System.out.println("No se ha podido borrar.");
					}
					break;
					
				case 10:
					List<String> asigIntroducidas = universidad.listAsig();
					if(asigIntroducidas == null) {
						System.out.println("No hay asignaturas");
						break;
					}
					for(String s : asigIntroducidas) {
						System.out.println(s);
					}
					break;
					
				case 11:
					System.out.println("Escribe la ID de la titulación:");
					bufferId = scanner.nextLine();
					System.out.println("Escribe la ID de la asignatura");
					buffer2 = scanner.nextLine();
					if(universidad.addAsig2Tit(bufferId, buffer2)) {
						System.out.println("Se ha añadido correctamente.");
					}
					else {
						System.out.println("No se ha podido añadir.");
					}
					break;
				case 12:
					System.out.println("Escribe la ID de la titulación:");
					bufferId = scanner.nextLine();
					System.out.println("Escribe la ID de la asignatura");
					buffer2 = scanner.nextLine();
					if(universidad.removeAsigFromTit(bufferId, buffer2)) {
						System.out.println("Se ha borrado correctamente.");
					}
					else {
						System.out.println("No se ha podido borrar.");
					}
					break;
					
				case 13:
					System.out.println("Escribe la ID de la titulación:");
					bufferId = scanner.nextLine();
					List<String> asignaturas = universidad.listaAsigFromTit(bufferId);
					if(asignaturas == null || asignaturas.isEmpty()) {
						System.out.println("No existe esa titulación o no tiene asignaturas.");
						break;
					}
					for(String s : asignaturas) {
						System.out.println(s);
					}
					break;
					
				case 14:
					System.out.println("Escibe la ID de la Matricula: ");
					bufferId = scanner.nextLine();
					System.out.println("Escribe el nombre del alumno: ");
					bufferNombre = scanner.nextLine();
					System.out.println("Escribe los apellidos del alumno: ");
					bufferApellidos = scanner.nextLine();
					System.out.println("Escribe el DNI del alumno: ");
					bufferDni = scanner.nextLine();
					Alumno alu = new Alumno();
					alu.setApellidos(bufferApellidos);
					alu.setNombre(bufferNombre);
					alu.setDni(bufferDni);
					Matricula m = new Matricula();
					m.setId(bufferId);
					m.setAlumno(alu);
					if(universidad.addMatricula(m)) {
						System.out.println("Se ha añadido correctamente.");
					}
					else {
						System.out.println("No se ha podido añadir.");
					}
					break;
				case 15:
					System.out.println("Escibe la ID de la Matricula: ");
					bufferId = scanner.nextLine();
					System.out.println("Escribe el nombre del nuevo alumno: ");
					bufferNombre = scanner.nextLine();
					System.out.println("Escribe los apellidos del nuevo alumno: ");
					bufferApellidos = scanner.nextLine();
					System.out.println("Escribe el DNI del nuevo alumno: ");
					bufferDni = scanner.nextLine();
					Alumno alum = new Alumno();
					alum.setApellidos(bufferApellidos);
					alum.setNombre(bufferNombre);
					alum.setDni(bufferDni);
					if(universidad.updateMatricula(bufferId, alum)) {
						System.out.println("Se ha actualizado correctamente.");
					}
					else {
						System.out.println("No se ha podido actualizar.");
					}
					break;
					
				case 16:
					System.out.println("Escribe su ID");
					bufferId = scanner.nextLine();
					Matricula ma= universidad.getMatricula(bufferId);
					if(ma == null) {
						System.out.println("No existe esa Matrícula");
						break;
					}
					System.out.println("Matrícula con ID: " + ma.getId());
					break;
				
				case 17:
					System.out.println("Escribe su ID");
					bufferId = scanner.nextLine();
					if(universidad.removeMatricula(bufferId)) {
						System.out.println("Se ha borrado correctamente.");
					}
					else {
						System.out.println("No se ha podido borrar.");
					}
					break;
				case 18:
					System.out.println("Saliendo del programa.");
					break;
				default:
					System.out.println("No existe esa opción.");
				}
			}
		}
		catch(MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
	}

	public int menu() {
		int opcion;
		Scanner scanner = new Scanner(System.in);
		System.out.println("******Menú*******");
		System.out.println("1) Añadir titulación");
		System.out.println("2) Actualizar titulación");
		System.out.println("3) Get titulación");
		System.out.println("4) Borrar titulación");
		System.out.println("5) Listar titulaciones");
		System.out.println("6) Contar titulaciones");
		System.out.println("7) Añadir asignatura");
		System.out.println("8) Get asignatura");
		System.out.println("9) Borrar asignatura");
		System.out.println("10) Listar asignaturas");
		System.out.println("11) Añadir asignatura a titulación");
		System.out.println("12) Borrar asignatura de titulación");
		System.out.println("13) Listar asignaturas de titulación");
		System.out.println("14) Añadir matricula");
		System.out.println("15) Actualizar matricula");
		System.out.println("16) Get matricula");
		System.out.println("17) Borrar matricula");
		System.out.println("18) Salir");
		System.out.println("Elige una opción: ");
		opcion = scanner.nextInt();
		return opcion;
	}
}
