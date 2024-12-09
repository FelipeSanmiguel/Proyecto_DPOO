package Actividades;

import java.util.Date;
import java.time.*;

public class Tarea extends Actividad {
	private String estado;
	
	public Tarea(int ID, String titulo, String descripcion, String objetivos, String dificultad,Duration duracionEsperada, int IDcreador) {
		
		super(ID, titulo, descripcion, objetivos, dificultad,duracionEsperada, IDcreador);
		this.estado = "Enviada";
		this.tipo = "Tarea";
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}