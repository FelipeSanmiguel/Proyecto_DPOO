package Actividades;

import java.time.Duration;
import java.util.*;

public class Encuesta extends Actividad {

	String estado;
	
	ArrayList<String> preguntasAbiertas;
	
	public Encuesta (int ID, String titulo, String descripcion, String objetivos, String dificultad,
			Duration duracionEsperada, int IDcreador, ArrayList<String> preguntas){
		super(ID, titulo, descripcion, objetivos, dificultad,duracionEsperada, IDcreador);
		this.estado = "Enviada";
		this.tipo = "Encuesta";
		this.preguntasAbiertas = preguntas;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public ArrayList<String> getPreguntasAbiertas() {
		return preguntasAbiertas;
	}

	public void setPreguntasAbiertas(ArrayList<String> preguntasAbiertas) {
		this.preguntasAbiertas = preguntasAbiertas;
	}
	
	
	
}
