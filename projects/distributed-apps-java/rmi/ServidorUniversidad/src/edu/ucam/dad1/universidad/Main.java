package edu.ucam.dad1.universidad;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import edu.ucam.domain.*;

public class Main {

	public static void main(String[] args) throws RemoteException, MalformedURLException{
		LocateRegistry.createRegistry(1010);
		IUniversidad universidad = new Universidad();
		Naming.rebind("rmi://localhost:1010/ServidorUniversidad", universidad);
		System.out.println("Servidor levantado...");
	}

}
