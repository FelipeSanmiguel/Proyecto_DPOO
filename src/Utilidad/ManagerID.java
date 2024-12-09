package Utilidad;

import java.util.*;
import Usuarios.*;
import Actividades.*;

public class ManagerID {
	
	
	private ArrayList<Integer> IDsUsuarios;
	
	private ArrayList<Integer> IDsActividades;
	
	private ArrayList<Integer> IDsLearningPaths;
	
	public ManagerID() {
		this.IDsUsuarios = new ArrayList<Integer>();
		this.IDsActividades = new ArrayList<Integer>();
		this.IDsLearningPaths = new ArrayList<Integer>();
	}

	
	public ArrayList<Integer> getIDsUsuarios(){
		return this.IDsUsuarios;
	}
	
	public int crearIDUsuario() {
		
		int variableID;
		if (IDsUsuarios.size() != 0) {
			variableID = IDsUsuarios.getLast();
			variableID++;
			this.IDsUsuarios.add(variableID);
			this.IDsUsuarios.sort(null);
		}
		else {
			variableID = 0;
			this.IDsUsuarios.add(variableID);
		}
		
		
		return variableID;
	}
	
	
	public int crearIDActividad() {
		
		int variableID;
		if (IDsActividades.size() != 0) {
			variableID = IDsActividades.getLast();
			variableID++;
			this.IDsActividades.add(variableID);
			this.IDsActividades.sort(null);
		}
		else {
			variableID = 0;
			this.IDsActividades.add(variableID);
		}
		
		
		return variableID;
	}
	
	public int crearIDLP() {
		
		int variableID;
		if (IDsLearningPaths.size() != 0) {
			variableID = IDsLearningPaths.getLast();
			variableID++;
			this.IDsLearningPaths.add(variableID);
			this.IDsLearningPaths.sort(null);
		}
		else {
			variableID = 0;
			this.IDsLearningPaths.add(variableID);
		}
		
		
		return variableID;
	}
	
	public void añadirIDUsuario(Usuario user) {
		int variableID;
		variableID = user.getID();
		IDsUsuarios.add(variableID);
	}
	
	public void añadirIDActividad(Actividad activ) {
		int variableID;
		variableID = activ.getID();
		IDsActividades.add(variableID);
	}
	
	/*
	 * TODO
	 */
	public void añadirIDLP() {
		
	}
	
	
	
	
	
	
	
	
}
