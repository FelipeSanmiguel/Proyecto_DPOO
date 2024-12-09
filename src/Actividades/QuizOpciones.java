package Actividades;

import java.time.Duration;
import java.util.ArrayList;
import Actividades.*;

public class QuizOpciones extends Actividad {
	
	private int puntajeMinAprobar;
	
	private ArrayList<PreguntaOpciones> preguntas; 
	
	public QuizOpciones(int ID, String titulo, String descripcion, String objetivos, String dificultad,Duration duracionEsperada, int IDcreador, int puntajeMin, ArrayList<PreguntaOpciones>  preguntas) {
		
		super(ID, titulo, descripcion, objetivos, dificultad,duracionEsperada, IDcreador);
		this.puntajeMinAprobar = puntajeMin;
		
		this.preguntas = preguntas;
		this.tipo = "QuizOpcion";
		
	}

	public int getPuntajeMinAprobar() {
		return puntajeMinAprobar;
	}

	public void setPuntajeMinAprobar(int puntajeMinAprobar) {
		this.puntajeMinAprobar = puntajeMinAprobar;
	}

	public ArrayList<PreguntaOpciones> getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(ArrayList<PreguntaOpciones> preguntas) {
		this.preguntas = preguntas;
	}

}
