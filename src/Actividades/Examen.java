package Actividades;

import java.time.Duration;
import java.util.*;

public class Examen extends Actividad{
	
	private ArrayList<String> preguntas;
	
	private ArrayList<String> respuestas;
	
	public Examen(int ID, String titulo, String descripcion, String objetivos, String dificultad,Duration duracionEsperada,int IDcreador,ArrayList<String> listaPreguntas) {
		super(ID, titulo, descripcion, objetivos, dificultad,duracionEsperada, IDcreador);
		
		this.tipo = "Examen";
		this.preguntas = listaPreguntas;
		this.respuestas = new ArrayList<String>();
		
	}

	public ArrayList<String> getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(ArrayList<String> preguntas) {
		this.preguntas = preguntas;
	}

	public ArrayList<String> getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(ArrayList<String> respuestas) {
		this.respuestas = respuestas;
	}
}
