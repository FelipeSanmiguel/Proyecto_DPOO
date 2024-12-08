package Usuarios;

import java.util.*;
import LearningPaths.*;


public class Estudiante extends Usuario{
	
	private ArrayList<String> intereses;
	 
	private ArrayList<EstudianteLP> listaProgresoLPs;
	
	public Estudiante(int ID, String nombreUsuario, String contraseña, ArrayList<String> intereses) {
		super(ID, nombreUsuario, contraseña);
		this.intereses = intereses;
		this.tipoUsuario = "Estudiante";
		this.listaProgresoLPs = new ArrayList<EstudianteLP>();
		
	}

	public ArrayList<String> getIntereses() {
		return intereses;
	}

	public void setIntereses(ArrayList<String> intereses) {
		this.intereses = intereses;
	}
	
	public void addInteres(String interes) {
		this.intereses.add(interes);
	}
	
	public void removeInteres(String interes) {
		this.intereses.remove(interes);
	}

	public ArrayList<EstudianteLP> getListaProgresoLPs() {
		return listaProgresoLPs;
	}
	
	public void añadirEstudianteLP(EstudianteLP elEst) {
		this.listaProgresoLPs.add(elEst);
		
	}

}
