package AplicacionPaquete;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;
import Actividades.*;
import Complementarios.*;
import LearningPaths.*;
import Usuarios.*;
import Utilidad.*;



public class Aplicacion {
	
	private ArrayList<LearningPath> listaLearningPaths;
	
	private ArrayList<Actividad> listaActividades;
	
	private ArrayList<Usuario> listaUsuarios;
	
	
	public Aplicacion() {
		this.listaLearningPaths = new ArrayList<LearningPath>();
		this.listaActividades = new ArrayList<Actividad>();
		this.listaUsuarios = new ArrayList<Usuario>();
	}
	
	public void addActividad(Actividad laActividad) {
		this.listaActividades.add(laActividad);
	}
	
	public void removeActividad(Actividad laActividad) {
		this.listaActividades.remove(laActividad);
	}
	
	public void addLP(LearningPath elLP) {
		this.listaLearningPaths.add(elLP);
	}
	
	public void removeLP(LearningPath elLP) {
		this.listaLearningPaths.remove(elLP);
	}
	
	public void addUsuario(Usuario user) {
		this.listaUsuarios.add(user);
	}
	
	public void removeUsuario(Usuario user) {
		this.listaUsuarios.remove(user);
	}

	public ArrayList<LearningPath> getListaLearningPaths() {
		return listaLearningPaths;
	}

	public void setListaLearningPaths(ArrayList<LearningPath> listaLearningPaths) {
		this.listaLearningPaths = listaLearningPaths;
	}

	public ArrayList<Actividad> getListaActividades() {
		return listaActividades;
	}

	public void setListaActividades(ArrayList<Actividad> listaActividades) {
		this.listaActividades = listaActividades;
	}

	public ArrayList<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}
	
	public void cargarPersistencia(ManagerID manager) {
		   try {
		        // Ruta correcta al archivo de usuarios
		        File archivoUsuarios = new File("./archivosPersistencia/UsuariosPer.txt");

		        if (archivoUsuarios.exists()) {
		            BufferedReader br = new BufferedReader(new FileReader(archivoUsuarios));
		            String linea;

		            while ((linea = br.readLine()) != null) {
		                // Ignorar líneas vacías o con solo espacios
		                if (linea.trim().isEmpty()) {
		                    continue; // Saltar a la siguiente línea
		                }

		                // Dividir la línea por ":"
		                String[] partes = linea.split(":");

		                // Validar el tipo de usuario en la primera parte
		                String tipoUsuario = partes[0].trim();

		                try {
		                    if (tipoUsuario.equalsIgnoreCase("Estudiante")) {
		                        // Validar que haya al menos 5 partes para Estudiante
		                        if (partes.length < 5) {
		                            System.err.println("Formato incorrecto para Estudiante en la línea: " + linea);
		                            continue;
		                        }

		                        // Procesar estudiante
		                        int id = Integer.parseInt(partes[1].trim());
		                        String nombreUsuario = partes[2].trim();
		                        String contraseña = partes[3].trim();

		                        // Convertir los intereses en una lista
		                        String[] interesesArray = partes[4].split(",");
		                        ArrayList<String> intereses = new ArrayList<>();
		                        for (String interes : interesesArray) {
		                            if (!interes.trim().isEmpty()) {
		                                intereses.add(interes.trim());
		                            }
		                        }

		                        // Crear instancia de Estudiante y agregarla a la lista
		                        Estudiante estudiante = new Estudiante(id, nombreUsuario, contraseña, intereses);
		                        this.listaUsuarios.add(estudiante);
		                        manager.añadirIDUsuario(estudiante);

		                    } else if (tipoUsuario.equalsIgnoreCase("Profesor")) {
		                        // Validar que haya al menos 4 partes para Profesor
		                        if (partes.length < 4) {
		                            System.err.println("Formato incorrecto para Profesor en la línea: " + linea);
		                            continue;
		                        }

		                        // Procesar profesor
		                        int id = Integer.parseInt(partes[1].trim());
		                        String nombreUsuario = partes[2].trim();
		                        String contraseña = partes[3].trim();

		                        // Crear instancia de Profesor y agregarla a la lista
		                        Profesor profesor = new Profesor(id, nombreUsuario, contraseña);
		                        this.listaUsuarios.add(profesor);
		                        manager.añadirIDUsuario(profesor);

		                    } else {
		                        System.err.println("Tipo de usuario no reconocido en la línea: " + linea);
		                    }
		                } catch (NumberFormatException e) {
		                    System.err.println("Error al convertir el ID a número en la línea: " + linea);
		                } catch (Exception e) {
		                    System.err.println("Error al procesar la línea: " + linea);
		                }
		            }

		            br.close();
		        } else {
		            System.err.println("Archivo de usuarios no encontrado en: " + archivoUsuarios.getAbsolutePath());
		        }
		    } catch (Exception e) {
		        System.err.println("Error al cargar la persistencia: " + e.getMessage());
		        e.printStackTrace();
		    }
		
	}
	
	
	
	
	
	

}
