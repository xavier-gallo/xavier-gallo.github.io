package edu.ucam.dad1.practica;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import edu.ucam.domain.*;

public class Cliente {
	public static final int puerto1 = 5000;
	private String nombre;
	private String id;
	
	public void ejecutar() {
		try {
			System.out.println("Estableciendo conexión con el servidor...");
			Socket socket = new Socket("127.0.0.1", puerto1);
			
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			System.out.println("El servidor dice: " + br.readLine());
			
			String lineaCliente = "", respuesta = "";
			String partes[] = lineaCliente.split(" ");
			String partes2[];
			Scanner teclado = new Scanner(System.in);
			
			while(!"salir".equals(respuesta)) {
				System.out.println("");
				lineaCliente = teclado.nextLine();
				partes = lineaCliente.split(" ");
				
				pw.println(lineaCliente); pw.flush();
				respuesta = br.readLine();
				partes2 = respuesta.split(" ");
				if(!respuesta.equals("salir")) {
					System.out.println(respuesta);
				}
				if("PREOK".equals(partes2[0])) {
					//Creamos el socket de datos
					Socket socketDatos = new Socket(partes2[2], Integer.parseInt(partes2[3]));
					ObjectOutputStream oos = new ObjectOutputStream(socketDatos.getOutputStream());
					ObjectInputStream ois = new ObjectInputStream(socketDatos.getInputStream());
					switch(partes[1]) {
					case "ADDTIT":
						//Creamos la nueva titulacion
						Titulacion crearT = new Titulacion();
						System.out.println("Escribe el nombre de la titulacion: ");
						nombre = teclado.nextLine();
						System.out.println("Escribe la ID de la titulación: ");
						id = teclado.nextLine();
						crearT.setNombre(nombre); crearT.setId(id);
						//Mandamos la titulacion por el canal de datos
						oos.writeObject(crearT);
						oos.flush();
						System.out.println(br.readLine());
						break;
					case "GETTIT":
						//Recibimos la titulacion por el canal de datos
						Titulacion recibirT = (Titulacion)ois.readObject();
						System.out.println(br.readLine());
						break;
					case "LISTTIT":
						//Recibimos la lista de titulaciones por el canal de datos
						ArrayList<Titulacion> listaT = (ArrayList<Titulacion>)ois.readObject();
						for(Titulacion t : listaT) {
							System.out.println(t.getNombre());
						}
						System.out.println(br.readLine());
						break;
						
					case "ADDASIG":
						//Creamos la nueva asignatura
						Asignatura crearA = new Asignatura();
						System.out.println("Escribe el nombre de la asignatura: ");
						nombre = teclado.nextLine();
						System.out.println("Escribe la ID de la asignatura: ");
						id = teclado.nextLine();
						System.out.println("Escribe los creditos: ");
						int creditos = Integer.parseInt(teclado.nextLine());
						crearA.setNombre(nombre); crearA.setId(id); crearA.setCreditos(creditos);
						//Mandamos la asignatura por el canal de datos
						oos.writeObject(crearA);
						oos.flush();
						System.out.println(br.readLine());
						break;
						
					case "GETASIG":
						//Recibimos la asignatura por el canal de datos
						Asignatura recibirA = (Asignatura)ois.readObject();
						System.out.println(br.readLine());
						break;
						
					case "LISTASIG":
						//Recibimos la lista de asignaturas por el canal de datos
						ArrayList<Asignatura> listaA = (ArrayList<Asignatura>)ois.readObject();
						for(Asignatura a : listaA) {
							System.out.println(a.getNombre());
						}
						System.out.println(br.readLine());
						break;
						
					case "ADDMATRICULA":
						//Creamos la nueva matricula
						Matricula crearM = new Matricula();
						System.out.println("Escribe la ID de la matricula: ");
						id = teclado.nextLine();
						crearM.setId(id);
						//Creamos un alumno para la matricula
						Alumno alum = new Alumno();
						System.out.println("Escribe el DNI del alumno: ");
						alum.setDni(teclado.nextLine());
						crearM.setAlumno(alum);
						//Mandamos la matricula por el canal de datos
						oos.writeObject(crearM);
						oos.flush();
						System.out.println(br.readLine());
						break;
						
					case "UPDATEMATRICULA":
						//Creamos la matricula para actualizar
						Matricula updateM = new Matricula();
						System.out.println("Escribe la ID de la matricula a actualizar: ");
						id = teclado.nextLine();
						updateM.setId(id);
						//Mandamos la matricula por el canal de datos
						oos.writeObject(updateM);
						oos.flush();
						System.out.println(br.readLine());
						break;
						
					case "GETMATRICULA":
						//Recibimos la matricula por el canal de datos
						Matricula recibirM = (Matricula)ois.readObject();
						System.out.println(br.readLine());
						break;
						
					case "LISTASIGFROMTIT":
						//Recibimos los datos por el canal de datos
						Object datos = ois.readObject();
						System.out.println(br.readLine());
						break;
					}
				}
			}
			
			System.out.println("OK " + partes[0] + " 201 bye.");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		(new Cliente()).ejecutar();
	}

}