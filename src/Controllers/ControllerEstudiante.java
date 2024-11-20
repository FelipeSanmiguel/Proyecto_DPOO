package Controllers;

import Usuarios.*;
import LearningPaths.*;
import AplicacionPaquete.*;
import Utilidad.*;
import Complementarios.*;

import java.util.ArrayList;

import Actividades.*;

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
			
			ArrayList<Estudiante> listaEstudiantes = new ArrayList<Estudiante>();
			
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
	
	public boolean crearUsuario(String nombreUsuario, String contraseña, ArrayList<String> intereses,ManagerID manager,Aplicacion sistema) {
		
		if(usuarioExiste(nombreUsuario,sistema)) {
			return false;
		}
		
		else {
			int ID = manager.crearIDUsuario();
			Usuario nuevoUsuario = new Estudiante(ID, nombreUsuario, contraseña,intereses);
			sistema.addUsuario(nuevoUsuario);
			return true;
		}
		
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
	
	
	
	public Usuario getUsuarioActual() {
		return usuarioActual;
	}
	
	public ArrayList<String> verInteresesUsuario(){
		return this.usuarioActual.getIntereses();
	}
}






