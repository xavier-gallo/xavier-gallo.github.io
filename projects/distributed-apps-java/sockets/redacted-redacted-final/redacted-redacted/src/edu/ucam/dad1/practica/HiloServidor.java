package edu.ucam.dad1.practica;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import edu.ucam.domain.*;

public class HiloServidor extends Thread{
	private BufferedReader br = null;
	private PrintWriter pw = null;
	private Servidor s = null;
	private ServerSocket serverSocketD = null;
	private boolean usuarioCorrecto;
	private boolean logueado;

	private ArrayList<Titulacion> titulaciones = new ArrayList<>();
	private ArrayList<Asignatura> asignaturas = new ArrayList<>();
	private ArrayList<Matricula> matriculas = new ArrayList<>();

	public HiloServidor(BufferedReader br, PrintWriter pw, Servidor s) {
		this.br = br;
		this.pw = pw;
		this.s = s;
		this.usuarioCorrecto = false;
		this.logueado = false;
	}

	@Override
	public void run() {
		String lineaCliente = "";
		try {
			String partes[];
			String salir = "";
			while(!"salir".equals(salir)) {
				lineaCliente = br.readLine();
				if(lineaCliente.trim().isEmpty()) {
					this.enviarMensaje("Comando no existente.");
					continue;
				}
				partes = lineaCliente.split(" ");
				if(partes.length <= 1) {
					this.enviarMensaje("Comando no existente.");
					continue;
				}
				switch(partes[1]) {
				case "USER":
					if(this.logueado == true) {
						this.enviarMensaje("Ya has iniciado sesion.");
						break;
					}
					if(this.usuarioCorrecto == true) {
						this.enviarMensaje("Ya has introducido el usuario, introduce la contraseña.");
						break;
					}
					if(partes.length <= 2 || partes[2].trim().isEmpty()) {
						this.enviarMensaje("No has introducido el nombre del usuario");
						break;
					}
					if(!"admin".equals(partes[2])) {
						this.enviarMensaje("FAILED " + partes[0] + " 401 Not user.");
					}
					else {
						this.enviarMensaje("OK " + partes[0] + " 202 Envie contraseña.");
						this.usuarioCorrecto = true;
					}
					break;
					
				case "PASS":
					if(this.logueado == true) {
						this.enviarMensaje("Ya has iniciado sesion.");
						break;
					}
					if(this.usuarioCorrecto == false) {
						this.enviarMensaje("Introduce un usuario primero.");
						break;
					}
					if(partes.length <= 2 || partes[2].trim().isEmpty()) {
						this.enviarMensaje("No has introducido la contraseña.");
						break;
					}
					
					if(!"admin".equals(partes[2])) {
						this.enviarMensaje("FAILED " + partes[0] + " 402 Prueba de nuevo.");
					}
					else {
						this.enviarMensaje("OK " + partes[0] + " 203 Welcome admin.");
						this.logueado = true;
					}
					break;
					
				case "SESIONES":
					String sesiones = "Sesiones iniciadas: " + String.valueOf(s.getNumHilos()) + "\n OK " + partes[0] + " 204 bye.";
					this.enviarMensaje(sesiones);
					break;
					
				case "ADDTIT":
					if(logueado == true) {
						try {
							int numPuertoDatos = s.obtenerNumPuerto();
							serverSocketD = new ServerSocket(numPuertoDatos);
							this.enviarMensaje("PREOK " + partes[0] + " 127.0.0.1 " + numPuertoDatos);
							Socket socketDatos = serverSocketD.accept();
							ObjectOutputStream oos = new ObjectOutputStream(socketDatos.getOutputStream());
							ObjectInputStream ois = new ObjectInputStream(socketDatos.getInputStream());
							Titulacion t = (Titulacion) ois.readObject();
							titulaciones.add(t);
							this.enviarMensaje("OK " + partes[0] + " Transferencia terminada.");
						}
						catch(Exception e) {
							e.printStackTrace();
						} 
					}
					else {
						this.enviarMensaje("FAILED " + partes[0] + " No has iniciado sesion.");
					}
					break;
				case "GETTIT":
					if(logueado == true) {
						try {
							int numPuertoDatos = s.obtenerNumPuerto();
							serverSocketD = new ServerSocket(numPuertoDatos);
							this.enviarMensaje("PREOK " + partes[0] + " 127.0.0.1 " + numPuertoDatos);
							Socket socketDatos = serverSocketD.accept();
							ObjectOutputStream oos = new ObjectOutputStream(socketDatos.getOutputStream());
							ObjectInputStream ois = new ObjectInputStream(socketDatos.getInputStream());
							
							Titulacion t = this.getTitulacion(lineaCliente.substring(partes[1].length() + 3));
							if(t == null) {
								oos.writeObject(null);
								this.enviarMensaje("FAILED " + partes[0] + " No existe esa titulacion.");
								break;
							}
							oos.writeObject(t); oos.flush();
							
							
							this.enviarMensaje("OK " + partes[0] + " Transferencia terminada.");
						}
						catch(Exception e) {
							e.printStackTrace();
						} 
					}
					
					else {
						this.enviarMensaje("FAILED " + partes[0] + " No has iniciado sesion.");
					}
					break;
				case "REMOVETIT":
				    if(logueado == true) {
				        Titulacion t = this.getTitulacion(partes[2]);
				        if(t == null) {
				            this.enviarMensaje("FAILED " + partes[0] + " Mensaje error.");
				        } else {
				            titulaciones.remove(t);
				            this.enviarMensaje("OK " + partes[0] + " Eliminado.");
				        }
				    } else {
				        this.enviarMensaje("FAILED " + partes[0] + " No autorizado.");
				    }
				    break;
				case "LISTTIT":
				    if(logueado == true) {
				        try {
				            int puertoDatos = s.obtenerNumPuerto();
				            serverSocketD = new ServerSocket(puertoDatos);
				            this.enviarMensaje("PREOK " + partes[0] + " 127.0.0.1 " + puertoDatos);

				            Socket sd = serverSocketD.accept();
				            ObjectOutputStream oos = new ObjectOutputStream(sd.getOutputStream());
				            oos.writeObject(titulaciones);
				            oos.flush();

				            this.enviarMensaje("OK " + partes[0] + " Transferencia terminada.");
				        } catch(Exception e) {
				            e.printStackTrace();
				        }
				    } else {
				        this.enviarMensaje("FAILED " + partes[0] + " Mensaje error.");
				    }
				    break;
				case "COUNTTIT":
				    if(logueado == true) {
				        this.enviarMensaje("OK " + partes[0] + " " + titulaciones.size());
				    } else {
				        this.enviarMensaje("FAILED " + partes[0] + " Mensaje error.");
				    }
				    break;

				case "ADDASIG":
				    if(logueado == true) {
				        try {
				            int numPuertoDatos = s.obtenerNumPuerto();
				            serverSocketD = new ServerSocket(numPuertoDatos);
				            this.enviarMensaje("PREOK " + partes[0] + " 127.0.0.1 " + numPuertoDatos);

				            Socket socketDatos = serverSocketD.accept();
				            ObjectOutputStream oos = new ObjectOutputStream(socketDatos.getOutputStream());
				            ObjectInputStream ois = new ObjectInputStream(socketDatos.getInputStream());
				            Asignatura a = (Asignatura) ois.readObject();
				            asignaturas.add(a);

				            this.enviarMensaje("OK " + partes[0] + " Transferencia terminada.");
				        }
				        catch(Exception e) {
				            e.printStackTrace();
				        }
				    }
				    else {
				        this.enviarMensaje("FAILED " + partes[0] + " No autorizado.");
				    }
				    break;
				case "GETASIG":
				    if(logueado == true) {
				        try {
				            Asignatura a = this.getAsignatura(partes[2]);
				            if(a == null) {
				                this.enviarMensaje("FAILED " + partes[0] + " No existe esa asignatura.");
				                break;
				            }

				            int numPuertoDatos = s.obtenerNumPuerto();
				            serverSocketD = new ServerSocket(numPuertoDatos);
				            this.enviarMensaje("PREOK " + partes[0] + " 127.0.0.1 " + numPuertoDatos);

				            Socket socketDatos = serverSocketD.accept();
				            ObjectOutputStream oos = new ObjectOutputStream(socketDatos.getOutputStream());
				            oos.writeObject(a);
				            oos.flush();

				            this.enviarMensaje("OK " + partes[0] + " Transferencia terminada.");
				        }
				        catch(Exception e) {
				            e.printStackTrace();
				        }
				    }
				    else {
				        this.enviarMensaje("FAILED " + partes[0] + " No autorizado.");
				    }
				    break;
				    
				case "REMOVEASIG":
					 if(logueado == true) {
					        Asignatura a = this.getAsignatura(partes[2]);
					        if(a == null) {
					            this.enviarMensaje("FAILED " + partes[0] + " Mensaje error.");
					        } else {
					            asignaturas.remove(a);
					            this.enviarMensaje("OK " + partes[0] + " Eliminado.");
					        }
					    } else {
					        this.enviarMensaje("FAILED " + partes[0] + " No autorizado.");
					    }
					break;
					
				case "LISTASIG":
				    if(logueado == true) {
				        try {
				            int puertoDatos = s.obtenerNumPuerto();
				            serverSocketD = new ServerSocket(puertoDatos);
				            this.enviarMensaje("PREOK " + partes[0] + " 127.0.0.1 " + puertoDatos);

				            Socket sd = serverSocketD.accept();
				            ObjectOutputStream oos = new ObjectOutputStream(sd.getOutputStream());
				            oos.writeObject(asignaturas);
				            oos.flush();

				            this.enviarMensaje("OK " + partes[0] + " Transferencia terminada.");
				        } catch(Exception e) {
				            e.printStackTrace();
				        }
				    } else {
				        this.enviarMensaje("FAILED " + partes[0] + " Mensaje error.");
				    }
				    break;
				case "ADDASIG2TIT":
				    if(logueado) {
				        if(partes.length < 4) {
				            enviarMensaje("FAILED " + partes[0] + " Faltan parámetros.");
				            break;
				        }

				        Asignatura a = getAsignatura(partes[2]);
				        Titulacion t = getTitulacion(partes[3]);

				        if(a == null || t == null) {
				            enviarMensaje("FAILED " + partes[0] + " No existe asignatura o titulacion.");
				            break;
				        }

				        t.addAsignatura(a);
				        enviarMensaje("OK " + partes[0] + " Transferencia terminada.");
				    }
				    else enviarMensaje("FAILED " + partes[0] + " No autorizado.");
				    break;


				case "REMOVEASIGFROMTIT":
				    if(logueado) {
				        if(partes.length < 4) {
				            enviarMensaje("FAILED " + partes[0] + " Faltan parámetros.");
				            break;
				        }

				        Titulacion t = getTitulacion(partes[3]);
				        if(t == null) {
				            enviarMensaje("FAILED " + partes[0] + " No existe titulacion.");
				            break;
				        }

				        Asignatura a = t.getAsignatura(partes[2]);
				        if(a == null) {
				            enviarMensaje("FAILED " + partes[0] + " No existe asignatura en titulacion.");
				            break;
				        }

				        t.removeAsignatura(a);
				        enviarMensaje("OK " + partes[0] + " Asignatura eliminada.");
				    }
				    else enviarMensaje("FAILED " + partes[0] + " No autorizado.");
				    break;


				case "LISTASIGFROMTIT":
				    if(logueado) {
				        if(partes.length < 3) {
				            enviarMensaje("FAILED " + partes[0] + " Faltan parámetros.");
				            break;
				        }

				        Titulacion t = getTitulacion(partes[2]);
				        if(t == null) {
				            enviarMensaje("FAILED " + partes[0] + " No existe titulacion.");
				            break;
				        }

				        try {
				            int puerto = s.obtenerNumPuerto();
				            serverSocketD = new ServerSocket(puerto);
				            enviarMensaje("PREOK " + partes[0] + " 127.0.0.1 " + puerto);

				            Socket sd = serverSocketD.accept();
				            ObjectOutputStream oos = new ObjectOutputStream(sd.getOutputStream());
				            oos.writeObject(t.getMatriculas()); 
				            oos.flush();

				            enviarMensaje("OK " + partes[0] + " Transferencia terminada.");
				        } catch(Exception e) {
				            e.printStackTrace();
				        }
				    }
				    else enviarMensaje("FAILED " + partes[0] + " No autorizado.");
				    break;

				case "ADDMATRICULA":
				    if(logueado) {
				        try {
				            int puerto = s.obtenerNumPuerto();
				            serverSocketD = new ServerSocket(puerto);
				            enviarMensaje("PREOK " + partes[0] + " 127.0.0.1 " + puerto);

				            Socket sd = serverSocketD.accept();
				            
				            ObjectOutputStream oos = new ObjectOutputStream(sd.getOutputStream());
				            ObjectInputStream ois = new ObjectInputStream(sd.getInputStream());
				            Matricula m = (Matricula) ois.readObject();

				            matriculas.add(m);

				            enviarMensaje("OK " + partes[0] + " Matricula añadida.");
				        } catch(Exception e) {
				            e.printStackTrace();
				        }
				    } else {
				        enviarMensaje("FAILED " + partes[0] + " No autorizado.");
				    }
				    break;


				case "UPDATEMATRICULA":
				    if(logueado) {
				        try {
				            int puerto = s.obtenerNumPuerto();
				            serverSocketD = new ServerSocket(puerto);
				            enviarMensaje("PREOK " + partes[0] + " 127.0.0.1 " + puerto);

				            Socket sd = serverSocketD.accept();
				            ObjectOutputStream oos = new ObjectOutputStream(sd.getOutputStream());
				            ObjectInputStream ois = new ObjectInputStream(sd.getInputStream());
				            Matricula nueva = (Matricula) ois.readObject();

				            Matricula vieja = getMatricula(nueva.getId());

				            if(vieja == null) {
				                enviarMensaje("FAILED " + partes[0] + " Matricula no encontrada.");
				                break;
				            }

				            matriculas.remove(vieja);
				            matriculas.add(nueva);

				            enviarMensaje("OK " + partes[0] + " Matricula actualizada.");
				        } catch(Exception e) {
				            e.printStackTrace();
				        }
				    } else {
				        enviarMensaje("FAILED " + partes[0] + " No autorizado.");
				    }
				    break;


				case "GETMATRICULA":
				    if(logueado) {
				        if(partes.length < 3) {
				            enviarMensaje("FAILED " + partes[0] + " Faltan parámetros.");
				            break;
				        }

				        Matricula m = getMatricula(partes[2]);

				        if(m == null) {

				            enviarMensaje("FAILED " + partes[0] + " Matricula no encontrada.");
				            break;
				        }

				        try {
				            int puerto = s.obtenerNumPuerto();
				            serverSocketD = new ServerSocket(puerto);
				            enviarMensaje("PREOK " + partes[0] + " 127.0.0.1 " + puerto);

				            Socket sd = serverSocketD.accept();
				            ObjectOutputStream oos = new ObjectOutputStream(sd.getOutputStream());
				            oos.writeObject(m);
				            oos.flush();

				            enviarMensaje("OK " + partes[0] + " Transferencia terminada.");
				        } catch(Exception e) {
				            e.printStackTrace();
				        }
				    } else {
				        enviarMensaje("FAILED " + partes[0] + " No autorizado.");
				    }
				    break;


				case "REMOVEMATRICULA":
				    if(logueado) {
				        if(partes.length < 3) {
				            enviarMensaje("FAILED " + partes[0] + " Faltan parámetros.");
				            break;
				        }

				        Matricula m = getMatricula(partes[2]);

				        if(m == null) {
				            enviarMensaje("FAILED " + partes[0] + " Matricula no encontrada.");
				            break;
				        }

				        matriculas.remove(m);
				        enviarMensaje("OK " + partes[0] + " Matricula eliminada.");
				    } else {
				        enviarMensaje("FAILED " + partes[0] + " No autorizado.");
				    }
				    break;
				case "EXIT":
					s.borrarHiloLista(this);
					this.enviarMensaje("salir");
					salir = "salir";
					break;
				default:
					this.enviarMensaje("Comando no existente.");
					break;
				}
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	public Titulacion getTitulacion(String id) {
		for(Titulacion t : titulaciones) {
			if(t.getId().equals(id)) {
				return t;
			}
		}
		return null;
	}
	public Asignatura getAsignatura(String id) {
	    for(Asignatura a : asignaturas) {
	        if(a.getId().equals(id)) {
	            return a;
	        }
	    }
	    return null;
	}
	public Matricula getMatricula(String id) {
	    for(Matricula m : matriculas) {
	        if(m.getId().equals(id)) {
	            return m;
	        }
	    }
	    return null;
	}


	public void enviarMensaje(String mensaje) {
		pw.println(mensaje); pw.flush();
	}
	
	
}
