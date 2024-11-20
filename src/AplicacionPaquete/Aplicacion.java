package AplicacionPaquete;

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

}
