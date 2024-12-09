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
import java.time.Duration;
import java.io.*;



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

	        // Cargar actividades
	        cargarActividades("./archivosPersistencia/ActividadesPer", manager);

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
	                    if (tipoUsuario.equals("Estudiante")) { // Comparación exacta con "Estudiante"
	                        // Validar que haya al menos 4 partes (ID, nombre, contraseña) para un estudiante
	                        if (partes.length < 4) {
	                            System.err.println("Formato incorrecto para Estudiante en la línea: " + linea);
	                            continue;
	                        }

	                        // Procesar estudiante
	                        int id = Integer.parseInt(partes[1].trim());
	                        String nombreUsuario = partes[2].trim();
	                        String contraseña = partes[3].trim();

	                        // Manejar intereses si están presentes
	                        ArrayList<String> intereses = new ArrayList<>();
	                        if (partes.length > 4) {
	                            String[] interesesArray = partes[4].split(",");
	                            for (String interes : interesesArray) {
	                                if (!interes.trim().isEmpty()) {
	                                    intereses.add(interes.trim());
	                                }
	                            }
	                        }

	                        // Crear instancia de Estudiante y agregarla a la lista
	                        Estudiante estudiante = new Estudiante(id, nombreUsuario, contraseña, intereses);
	                        this.listaUsuarios.add(estudiante);
	                        manager.añadirIDUsuario(estudiante);

	                    } else if (tipoUsuario.equals("Profesor")) { // Comparación exacta con "Profesor"
	                        // Validar que haya al menos 4 partes (ID, nombre, contraseña) para un profesor
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
	                    e.printStackTrace();
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

	
	public void cargarActividades(String rutaArchivo, ManagerID manager) {
	    try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
	        String linea;
	        Actividad actividadActual = null;

	        while ((linea = reader.readLine()) != null) {
	            linea = linea.trim();

	            if (!linea.startsWith("-")) {
	                /*
	                 *  Lee la actividad
	                 */
	                String[] partes = linea.split(":");
	                int ID = Integer.parseInt(partes[0]);
	                String tipo = partes[1];
	                String titulo = partes[2];
	                String descripcion = partes[3];
	                String objetivos = partes[4];
	                String dificultad = partes[5];
	                Duration duracion = Duration.parse(partes[6]);
	                int IDcreador = Integer.parseInt(partes[7]);
	                double rating = Double.parseDouble(partes[8]);
	                boolean completada = Boolean.parseBoolean(partes[9]);

	                if (tipo.equals("Encuesta")) {
	                    actividadActual = new Encuesta(ID, titulo, descripcion, objetivos, dificultad, duracion, IDcreador, new ArrayList<>());
	                } else if (tipo.equals("Examen")) {
	                    actividadActual = new Examen(ID, titulo, descripcion, objetivos, dificultad, duracion, IDcreador, new ArrayList<>());
	                } else if (tipo.equals("Tarea")) {
	                    actividadActual = new Tarea(ID, titulo, descripcion, objetivos, dificultad, duracion, IDcreador);
	                } else if (tipo.equals("QuizBool")) {
	                    actividadActual = new QuizBool(ID, titulo, descripcion, objetivos, dificultad, duracion, IDcreador, 0, new ArrayList<>());
	                } else if (tipo.equals("QuizOpcion")) {
	                    actividadActual = new QuizOpciones(ID, titulo, descripcion, objetivos, dificultad, duracion, IDcreador, 0, new ArrayList<>());
	                } else if (tipo.equals("RevisarRecurso")) {
	                    actividadActual = new RevisarRecurso(ID, titulo, descripcion, objetivos, dificultad, duracion, IDcreador, "");
	                }

	                if (actividadActual != null) {
	                    actividadActual.setRating((int) rating);
	                    actividadActual.setCompletada(completada);
	                    listaActividades.add(actividadActual);

	                    /*
	                     *  poner el ID en el manager
	                     */
	                    manager.añadirIDActividad(actividadActual);
	                }
	            } 
	            else {
	                // Leer atributos específicos de la actividad actual
	                String[] partes = linea.substring(2).split(":");
	                String clave = partes[0];
	                String valor = partes[1];

	                if (actividadActual instanceof Encuesta) {
	                    Encuesta encuesta = (Encuesta) actividadActual;
	                    if (clave.equals("Estado")) {
	                        encuesta.setEstado(valor);
	                    } else if (clave.equals("Pregunta")) {
	                        encuesta.getPreguntasAbiertas().add(valor);
	                    } else if (clave.equals("Respuesta")) {
	                        encuesta.getRespuestas().add(valor);
	                    }
	                } else if (actividadActual instanceof QuizBool) {
	                    QuizBool quizBool = (QuizBool) actividadActual;
	                    if (clave.equals("PuntajeMin")) {
	                        quizBool.setPuntajeMinAprobar(Integer.parseInt(valor));
	                    } else if (clave.equals("Pregunta")) {
	                        String[] preguntaPartes = valor.split(":");
	                        String texto = preguntaPartes[0];
	                        String explicacion = preguntaPartes[1];
	                        boolean verdadero = Boolean.parseBoolean(preguntaPartes[2]);
	                        quizBool.getPreguntas().add(new PreguntaBool(texto, explicacion, verdadero));
	                    }
	                } else if (actividadActual instanceof QuizOpciones) {
	                    QuizOpciones quizOpciones = (QuizOpciones) actividadActual;
	                    if (clave.equals("PuntajeMin")) {
	                        quizOpciones.setPuntajeMinAprobar(Integer.parseInt(valor));
	                    } else if (clave.equals("Pregunta")) {
	                        PreguntaOpciones pregunta = new PreguntaOpciones(valor, "", new ArrayList<>());
	                        quizOpciones.getPreguntas().add(pregunta);
	                    } else if (clave.equals("Opcion")) {
	                        String[] opcionPartes = valor.split(":");
	                        String textoOpcion = opcionPartes[0];
	                        boolean correcta = Boolean.parseBoolean(opcionPartes[1]);
	                        PreguntaOpciones ultimaPregunta = quizOpciones.getPreguntas().get(quizOpciones.getPreguntas().size() - 1);
	                        ultimaPregunta.getOpciones().add(new Opcion(textoOpcion, correcta));
	                    }
	                } else if (actividadActual instanceof RevisarRecurso) {
	                    RevisarRecurso revisarRecurso = (RevisarRecurso) actividadActual;
	                    if (clave.equals("Link")) {
	                        revisarRecurso.setLinkRecurso(valor);
	                    }
	                }
	            }
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }


	}
	
	public void actualizarPersistencia() {
	    String rutaUsuarios = "./archivosPersistencia/UsuariosPer";
	    String rutaActividades = "./archivosPersistencia/ActividadesPer.txt";
	    String rutaLearningPaths = "./archivosPersistencia/PersistenciaLP.txt";

	    
	    actualizarPersistenciaUsuarios(rutaUsuarios);
	    //actualizarPersistenciaActividades(rutaActividades);
	    //actualizarPersistenciaLearningPaths(rutaLearningPaths);

	    System.out.println("Persistencia actualizada correctamente.");
	}
	
	
	
	private void actualizarPersistenciaUsuarios(String rutaUsuarios) {
	    try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaUsuarios))) {
	        for (Usuario usuario : listaUsuarios) {
	            if (usuario instanceof Estudiante) {
	                Estudiante estudiante = (Estudiante) usuario;
	                StringBuilder linea = new StringBuilder();
	                linea.append("Estudiante:").append(estudiante.getID()).append(":")
	                        .append(estudiante.getNombreUsuario()).append(":")
	                        .append(estudiante.getContraseña()).append(":");

	                // Add interests
	                if (!estudiante.getIntereses().isEmpty()) {
	                    for (String interes : estudiante.getIntereses()) {
	                        linea.append(interes).append(",");
	                    }
	                    linea.deleteCharAt(linea.length() - 1); // Remove last comma
	                }

	                writer.write(linea.toString());
	                writer.newLine();
	            } else if (usuario instanceof Profesor) {
	                Profesor profesor = (Profesor) usuario;
	                writer.write("Profesor:" + profesor.getID() + ":" + profesor.getNombreUsuario() + ":" + profesor.getContraseña());
	                writer.newLine();
	            }
	        }
	    } catch (IOException e) {
	        System.err.println("Error updating user persistence: " + e.getMessage());
	        e.printStackTrace();
	    }
	}
	
	
	
}
