package Actividades;

import java.time.Duration;
import java.util.*;

public class QuizBool extends Actividad {
	
	private int puntajeMinAprobar;
	
	private ArrayList<PreguntaBool> preguntas; 
	
	public QuizBool(int ID, String titulo, String descripcion, String objetivos, String dificultad,Duration duracionEsperada,int IDcreador, int puntajeMin, ArrayList preguntas) {
		
		super(ID, titulo, descripcion, objetivos, dificultad,duracionEsperada, IDcreador);
		this.puntajeMinAprobar = puntajeMin;
		
		this.preguntas = preguntas;
		this.tipo = "QuizBool";
		
	}

	public int getPuntajeMinAprobar() {
		return puntajeMinAprobar;
	}

	public void setPuntajeMinAprobar(int puntajeMinAprobar) {
		this.puntajeMinAprobar = puntajeMinAprobar;
	}

	public ArrayList<PreguntaBool> getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(ArrayList<PreguntaBool> preguntas) {
		this.preguntas = preguntas;
	}

}
