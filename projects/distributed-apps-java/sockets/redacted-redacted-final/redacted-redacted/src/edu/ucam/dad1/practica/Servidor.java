package edu.ucam.dad1.practica;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import edu.ucam.domain.*;

public class Servidor {
	public static final int puerto1 = 5000;
	private ArrayList<HiloServidor> hilos = new ArrayList<HiloServidor>();
	private int contador = 5000;
	
	public void ejecutar() {
		ServerSocket serverSocket = null;
		ServerSocket serverSocketD = null;
		try {
			serverSocket = new ServerSocket(puerto1);
			while(true) {
				System.out.println("Estableciendo conexion...");
				Socket socket = serverSocket.accept();
				
				//Para el socket de comandos
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
				
				pw.println("Conexión establecida."); pw.flush();
				
				HiloServidor hiloServidor = new HiloServidor(br, pw, this);
				hiloServidor.start();
				
				hilos.add(hiloServidor);
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			if(serverSocket != null) {
				try {
					serverSocket.close();
				}
				catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public int getNumHilos() {
		return hilos.size();
	}
	
	public synchronized int obtenerNumPuerto() {
		return ++contador;
	}
	
	public void borrarHiloLista(HiloServidor h) {
		hilos.remove(h);
	}
	public static void main(String[] args) {
		(new Servidor()).ejecutar();
	}

}
