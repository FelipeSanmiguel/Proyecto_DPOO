package LearningPaths;

import java.util.*;

import Actividades.*;
import Usuarios.*;

public class BloqueLP {
	
	private ArrayList<BloqueLP> prerequisitos;
	
	private ArrayList<BloqueLP> recomendacionesExitosos;
	
	private ArrayList<BloqueLP> recomendacionesFallidos;
	
	private Boolean completado;
	
	private String resultado;
	
	private Actividad actividadLP;
	
	private boolean obligatorio;
	
	private ArrayList<Estudiante> listaEstudiantes;
	
	public BloqueLP(Actividad laActividad, ArrayList<BloqueLP> prerequisitos) {
		this.completado = false;
		this.prerequisitos = new ArrayList<BloqueLP>();
		this.recomendacionesExitosos = new ArrayList<BloqueLP>();
		this.recomendacionesExitosos = new ArrayList<BloqueLP>();
		this.actividadLP = laActividad;
		this.listaEstudiantes = new ArrayList<Estudiante>();
	}
	
	public void añadirPrerequisito(BloqueLP prerequisito) {
		if(this.prerequisitos.contains(prerequisito) == false) {
			this.prerequisitos.add(prerequisito);
		}
		
	}

	
	public void quitarPrerequisito(BloqueLP prerequisito) {
		
		if(this.recomendacionesFallidos.contains(prerequisito)) {
			this.recomendacionesFallidos.remove(prerequisito);
		}
	
}
	
	public void añadirRecomendacionExitoso(BloqueLP recomendacion) {
		if(!this.recomendacionesExitosos.contains(recomendacion)) {
			this.recomendacionesExitosos.add(recomendacion);
		}
		
	}
	
	public void quitarRecomendacionExitoso(BloqueLP recomendacion) {
		
			if(this.recomendacionesExitosos.contains(recomendacion)) {
				this.recomendacionesExitosos.remove(recomendacion);
			}
		
	}
	
	public void añadirRecomendacionFallido(BloqueLP recomendacion) {
		if(!this.recomendacionesFallidos.contains(recomendacion)) {
			this.recomendacionesFallidos.add(recomendacion);
		}
		
	}
	
	public void quitarRecomendacion(BloqueLP recomendacion) {
		
			if(this.recomendacionesFallidos.contains(recomendacion)) {
				this.recomendacionesFallidos.remove(recomendacion);
			}
		
	}
	
	public void añadirEstudiante(Estudiante estudiante) {
		this.listaEstudiantes.add(estudiante);
	}
	
	public void quitarEstudiante(int IDestudiante) {
		for(Estudiante iter:this.listaEstudiantes) {
			if(iter.getID() == IDestudiante) {
				this.listaEstudiantes.remove(iter);
			}
		}
	}

	public Boolean getCompletado() {
		return completado;
	}

	public void setCompletado(Boolean completado) {
		this.completado = completado;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public ArrayList<BloqueLP> getPrerequisitos() {
		return prerequisitos;
	}

	public ArrayList<BloqueLP> getRecomendacionesExitosos() {
		return recomendacionesExitosos;
	}

	public ArrayList<BloqueLP> getRecomendacionesFallidos() {
		return recomendacionesFallidos;
	}

	public Actividad getActividadLP() {
		return actividadLP;
	}

	public ArrayList<Estudiante> getListaEstudiantes() {
		return listaEstudiantes;
	}

}
