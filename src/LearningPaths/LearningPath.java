package LearningPaths;

import java.time.*;
import java.util.*;
import Complementarios.*;
import Usuarios.*;
import Actividades.*;


public class LearningPath {
	
	int ID;
	
	String titulo;
	
	String descripcion;
	
	String objetivos;
	
	String dificultad;
	
	Duration duracionEsperada;
	
	double rating = -1;
	
	LocalDateTime fechaCreacion;
	
	LocalDateTime fechaEdicion;
	
	int version = 1;
	
	ArrayList<Reseña> listaReseñas = new ArrayList<Reseña>();
	
	ArrayList<BloqueLP> listaBloques = new ArrayList<BloqueLP>();
	
	ArrayList<EstudianteLP> listaEstudiantes = new ArrayList<EstudianteLP>();
	
	public LearningPath(int ID, String titulo,String descripcion,String objetivos,String dificultad) {
		this.ID = ID;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.objetivos = objetivos;
		this.dificultad = dificultad;
		this.fechaCreacion = LocalDateTime.now();
		
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
		this.version++;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
		this.version++;
	}

	public String getObjetivos() {
		return objetivos;
	}

	public void setObjetivos(String objetivos) {
		this.objetivos = objetivos;
		this.version++;
	}

	public String getDificultad() {
		return dificultad;
	}

	public void setDificultad(String dificultad) {
		this.dificultad = dificultad;
		this.version++;
	}

	public Duration getDuracionEsperada() {
		return duracionEsperada;
	}

	public void setDuracionEsperada(Duration duracionEsperada) {
		this.duracionEsperada = duracionEsperada;
		this.version++;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
		this.version++;
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
		this.version++;
	}

	public LocalDateTime getFechaEdicion() {
		return fechaEdicion;
	}

	public void setFechaEdicion(LocalDateTime fechaEdicion) {
		this.fechaEdicion = fechaEdicion;
		this.version++;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
		this.version++;
	}

	public ArrayList<Reseña> getListaReseñas() {
		return listaReseñas;
	}

	public void setListaReseñas(ArrayList<Reseña> listaReseñas) {
		this.listaReseñas = listaReseñas;
	}

	public ArrayList<BloqueLP> getListaBloques() {
		return listaBloques;
	}

	public void setListaBloques(ArrayList<BloqueLP> listaBloques) {
		this.listaBloques = listaBloques;
	}

	public ArrayList<EstudianteLP> getListaEstudiantes() {
		return listaEstudiantes;
	}

	public void setListaEstudiantes(ArrayList<EstudianteLP> listaEstudiantes) {
		this.listaEstudiantes = listaEstudiantes;
	}
	
	public void añadirReseña(Reseña laReseña) {
		this.listaReseñas.add(laReseña);
		double promedioRating = 0;
		for(Reseña iterReseña:this.listaReseñas) {
			promedioRating = promedioRating+ iterReseña.getRating();
		}
		promedioRating = promedioRating/this.listaReseñas.size();
		promedioRating = Math.round(promedioRating*100);
		promedioRating = promedioRating/100;
		this.rating = promedioRating;
		
	}
	
	public void quitarReseña(int IDcreador) {
		for(Reseña iterReseña:this.listaReseñas) {
			if(iterReseña.getIDcreador() == IDcreador) {
				this.listaReseñas.remove(iterReseña);
			}
		}
		
	}
	
	/*
	 * TODO
	 */
	public void añadirBloque(BloqueLP bloque) {
		if(!this.listaBloques.contains(bloque)) {
			this.listaBloques.add(bloque);
		}
		
	}
	
	public void quitarBloque(BloqueLP bloque) {
		if(this.listaBloques.contains(bloque)) {
			this.listaBloques.remove(bloque);
		}
		
	}
	
	public void añadirEstudiante(EstudianteLP elEstudiente) {
		if(!this.listaEstudiantes.contains(elEstudiente)) {
			this.listaEstudiantes.add(elEstudiente);
		}
		
	}
	
	public void quitarBloque(EstudianteLP elEstudiente) {
		if(this.listaEstudiantes.contains(elEstudiente)) {
			this.listaEstudiantes.remove(elEstudiente);
		}
		
	}
	
	
	
	
	

}
