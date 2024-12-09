package Actividades;

import java.time.Duration;
import java.util.*;

public class Encuesta extends Actividad {

	private String estado;
	
	private ArrayList<String> preguntasAbiertas;
	
	private ArrayList<String> respuestas;
	
	public Encuesta (int ID, String titulo, String descripcion, String objetivos, String dificultad,
			Duration duracionEsperada, int IDcreador, ArrayList<String> preguntas){
		super(ID, titulo, descripcion, objetivos, dificultad,duracionEsperada, IDcreador);
		this.estado = "Enviada";
		this.tipo = "Encuesta";
		this.preguntasAbiertas = preguntas;
		this.respuestas = new ArrayList<String>();
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

	public ArrayList<String> getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(ArrayList<String> respuestas) {
		this.respuestas = respuestas;
	}
	
	
	
}
