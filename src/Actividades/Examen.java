package Actividades;

import java.time.Duration;
import java.util.*;

public class Examen extends Actividad{
	
	private ArrayList preguntas;
	
	public Examen(int ID, String titulo, String descripcion, String objetivos, String dificultad,Duration duracionEsperada,int IDcreador,ArrayList listaPreguntas) {
		super(ID, titulo, descripcion, objetivos, dificultad,duracionEsperada, IDcreador);
		
		this.tipo = "Examen";
		this.preguntas = listaPreguntas;
		
	}

	public ArrayList getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(ArrayList preguntas) {
		this.preguntas = preguntas;
	}
}
