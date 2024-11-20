package Controllers;

import Usuarios.*;
import LearningPaths.*;
import AplicacionPaquete.*;
import Utilidad.*;

import java.util.*;

import Actividades.*;


public class ControllerProfesor {
	
	private Profesor usuarioActual;
	
	public ControllerProfesor() {
		
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
					if(iter.getContraseña().equals(password) && iter.getTipoUsuario().equals("Profesor")) {
						this.usuarioActual = (Profesor) iter;
						return true;
					}
				}
			return false;
		 
		}
		else return false;
		
	}
	
	public boolean crearUsuario(String nombreUsuario, String contraseña,ManagerID manager,Aplicacion sistema) {
		
		if(usuarioExiste(nombreUsuario,sistema)) {
			return false;
		}
		
		else {
			int ID = manager.crearIDUsuario();
			Usuario nuevoUsuario = new Profesor(ID, nombreUsuario, contraseña);
			sistema.addUsuario(nuevoUsuario);
			return true;
		}
		
	}
	
	public void crearLP(String titulo,String descripcion,String objetivos,String dificultad,ManagerID manager,Aplicacion sistema) {
		int nuevoIDLP = manager.crearIDLP();
		LearningPath nuevoLP = new LearningPath(nuevoIDLP, titulo, descripcion, objetivos, dificultad);
		usuarioActual.añadirLP(nuevoLP);
		sistema.addLP(nuevoLP);
	}
	

	
	
	
	
}
