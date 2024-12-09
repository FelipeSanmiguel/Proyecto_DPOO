package Controllers;

import Usuarios.*;
import LearningPaths.*;
import AplicacionPaquete.*;
import Utilidad.*;
import Complementarios.*;

import java.util.ArrayList;

import Actividades.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ControllerEstudiante {
	
	private Estudiante usuarioActual;

	public ControllerEstudiante() {
		
	}
	
	public boolean usuarioExiste(String user, Aplicacion sistema) {
		ArrayList<Usuario> listaUsuarios = sistema.getListaUsuarios();
		
		boolean existe = false;
		for(Usuario iter: listaUsuarios) {
			if(iter.getNombreUsuario().equals(user)) {
				existe = true;
			}
		}
		return existe;
	}
	
	public boolean seleccionarUsuario(String user, String password,Aplicacion sistema) {
		
		boolean existe = usuarioExiste(user,sistema);
		
		if(existe) {
			ArrayList<Usuario> listaUsuarios = sistema.getListaUsuarios();
			
			
			for(Usuario iter: listaUsuarios) {
					if(iter.getContraseña().equals(password) && iter.getClass() == Estudiante.class) {
						this.usuarioActual = (Estudiante) iter;
						return true;
					}
				}
			return false;
		 
		}
		else return false;
		
	}
	
	public boolean crearUsuario(String nombreUsuario, String contraseña, ArrayList<String> intereses, ManagerID manager, Aplicacion sistema) {
	    if (nombreUsuario == null || contraseña == null || intereses == null || usuarioExiste(nombreUsuario, sistema)) {
	        return false; 
	    }

	    
	    int ID = manager.crearIDUsuario();

	    
	    Usuario nuevoUsuario = new Estudiante(ID, nombreUsuario, contraseña, intereses);
	    sistema.addUsuario(nuevoUsuario);

	    try (BufferedWriter bw = new BufferedWriter(new FileWriter("./archivosPersistencia/UsuariosPer.txt", true))) {
	        
	        String interesesStr = String.join(",", intereses);
	        String newUserLine = "Estudiante:" + ID + ":" + nombreUsuario + ":" + contraseña + ":" + interesesStr;

	        
	        bw.write(newUserLine);
	        bw.newLine(); 
	    } catch (IOException e) {
	        System.err.println("Error writing to persistence file: " + e.getMessage());
	        return false; 
	    }
	   

	    return true;
	}

	public boolean registrarseEnLP(int IDlp, Aplicacion sistema) {
		
		for(LearningPath iter:sistema.getListaLearningPaths()) {
			if(iter.getID() == IDlp) {
				EstudianteLP nuevoEstudiante = new EstudianteLP(this.usuarioActual,iter);
				iter.añadirEstudiante(nuevoEstudiante);
				return true;
			}
		}
		
		return false;
	}
	
	public boolean crearReseñaLP(int IDlp, String texto, int rating, Aplicacion sistema ) {
		
		for(LearningPath iter:sistema.getListaLearningPaths()) {
			if(iter.getID() == IDlp) {
				int IDuser = this.usuarioActual.getID(); 
				Reseña nuevaReseña = new Reseña(texto, rating, IDuser);
				iter.añadirReseña(nuevaReseña);
				return true;
			}
		}
		
		return true;
	}
	
	public boolean crearReseñaActividad(int IDac, String texto, int rating, Aplicacion sistema ) {
		
		for(Actividad iter:sistema.getListaActividades()) {
			if(iter.getID() == IDac) {
				int IDuser = this.usuarioActual.getID(); 
				Reseña nuevaReseña = new Reseña(texto, rating, IDuser);
				iter.añadirReseña(nuevaReseña);
				return true;
			}
		}
		
		return false;
	}
	
	
	
	public Usuario getUsuarioActual() {
		return usuarioActual;
	}
	
	public ArrayList<String> verInteresesUsuario(){
		return this.usuarioActual.getIntereses();
	}
}






