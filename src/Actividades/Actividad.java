package Actividades;

import java.util.*;
import java.time.*;
import Complementarios.*;
import java.math.*;

public abstract class Actividad {
	
	int ID;
	
	String titulo;
	
	String descripcion;
	
	String objetivos;
	
	String dificultad;
	
	Duration duracionEsperada;
	
	int resultado;
	
	Boolean completada;
	
	String tipo;
	
	int IDcreador;
	
	double rating;
	
	ArrayList<Reseña> reseñas;
	
	public Actividad(int ID, String titulo, String descripcion, String objetivos, String dificultad,
			Duration duracionEsperada, int IDcreador) {
		this.ID = ID;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.objetivos = objetivos;
		this.dificultad = dificultad;
		this.duracionEsperada = duracionEsperada;
		this.resultado = 0;
		this.completada = false;
		this.rating = -1;
		this.reseñas = new ArrayList<Reseña>();
		this.IDcreador = IDcreador;
		
	}
	
	public int getIDCreador() {
		return this.IDcreador;
	}
	
	public int getID() {
		return this.ID;
	}
	
	public String getTitulo() {
		return this.titulo;
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}
	
	public String getObjetivos() {
		return this.objetivos;
	}
	
	public String getDificultad() {
		return this.dificultad;
	}
	
	public Duration getDuracionEsperada() {
		return this.duracionEsperada;
	}
	
	public int getResultado() {
		return this.resultado;
	}

	public Boolean getCompletada() {
		return completada;
	}

	public void setCompletada(Boolean completada) {
		this.completada = completada;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setObjetivos(String objetivos) {
		this.objetivos = objetivos;
	}

	public void setDificultad(String dificultad) {
		this.dificultad = dificultad;
	}

	public void setDuracionEsperada(Duration duracionEsperada) {
		this.duracionEsperada = duracionEsperada;
	}

	public void setResultado(int resultado) {
		this.resultado = resultado;
	}
	
	public void añadirReseña(Reseña laReseña) {
		this.reseñas.add(laReseña);
		double promedioRating = 0;
		for(Reseña iterReseña:this.reseñas) {
			promedioRating = promedioRating+ iterReseña.getRating();
		}
		promedioRating = promedioRating/this.reseñas.size();
		promedioRating = Math.round(promedioRating*100);
		promedioRating = promedioRating/100;
		this.rating = promedioRating;
		
	}
	
	
	public void quitarReseña(int IDcreador) {
		for(Reseña iterReseña:this.reseñas) {
			if(iterReseña.getIDcreador() == IDcreador) {
				this.reseñas.remove(iterReseña);
			}
		}
		
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getIDcreador() {
		return IDcreador;
	}

	public void setIDcreador(int iDcreador) {
		IDcreador = iDcreador;
	}
	
	
}
