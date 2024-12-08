package Controllers;

import Usuarios.*;
import LearningPaths.*;
import AplicacionPaquete.*;
import Utilidad.*;

import java.util.*;

import Actividades.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

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
					if(iter.getContraseña().equals(password) && iter.getClass() == Profesor.class) {
						this.usuarioActual = (Profesor) iter;
						return true;
					}
				}
			return false;
		 
		}
		else return false;
		
	}
	
	public boolean crearUsuario(String nombreUsuario, String contraseña, ManagerID manager, Aplicacion sistema) {
	    if (usuarioExiste(nombreUsuario, sistema)) {
	        return false;
	    }

	    
	    int ID = manager.crearIDUsuario();

	    
	    Usuario nuevoUsuario = new Profesor(ID, nombreUsuario, contraseña);
	    sistema.addUsuario(nuevoUsuario);

	    
	    try (BufferedWriter bw = new BufferedWriter(new FileWriter("./archivosPersistencia/UsuariosPer.txt", true))) {
	        
	        String newUserLine = "Profesor:" + ID + ":" + nombreUsuario + ":" + contraseña;

	        
	        bw.write(newUserLine);
	        bw.newLine(); 
	    } catch (IOException e) {
	        System.err.println("Error writing to persistence file: " + e.getMessage());
	        return false; 
	    }

	    return true;
	}
	
	public void crearLP(String titulo,String descripcion,String objetivos,String dificultad,ManagerID manager,Aplicacion sistema) {
		int nuevoIDLP = manager.crearIDLP();
		LearningPath nuevoLP = new LearningPath(nuevoIDLP, titulo, descripcion, objetivos, dificultad);
		usuarioActual.añadirLP(nuevoLP);
		sistema.addLP(nuevoLP);
	}
	

	
	
	
	
}
