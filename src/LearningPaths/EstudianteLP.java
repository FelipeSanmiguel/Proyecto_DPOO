package LearningPaths;

import Actividades.*;
import java.util.*;
import Usuarios.*;

public class EstudianteLP {
	
	private int elEstudianteID;
	
	private int leaningPathID;
	
	private double progreso;
	
	private ArrayList<BloqueLP> actividadesCompletadas;
	
	
	public EstudianteLP(Estudiante elEstudiante, LearningPath elLP){
		this.elEstudianteID = elEstudiante.getID();
		this.leaningPathID = elLP.getID();
		this.progreso = 0;
		this.actividadesCompletadas = new ArrayList<BloqueLP>();
		
	}

	public int getElEstudianteID() {
		return elEstudianteID;
	}

	public void setElEstudiante(int elEstudianteID) {
		this.elEstudianteID = elEstudianteID;
	}

	public double getProgreso() {
		return progreso;
	}

	public void setProgreso(double progreso) {
		this.progreso = progreso;
	}

	public ArrayList<BloqueLP> getActividadesCompletadas() {
		return actividadesCompletadas;
	}

	public void setActividadesCompletadas(ArrayList<BloqueLP> actividadesCompletadas) {
		this.actividadesCompletadas = actividadesCompletadas;
	}
	
	public void añadirActividadCompleta(BloqueLP actividad) {
		actividadesCompletadas.add(actividad);
	}

}
