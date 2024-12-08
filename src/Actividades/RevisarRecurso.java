package Actividades;

import java.time.Duration;

public class RevisarRecurso extends Actividad {
	
	private String linkRecurso;
	
	public RevisarRecurso(int ID, String titulo, String descripcion, String objetivos, String dificultad,
			Duration duracionEsperada, int IDcreador, String linkRecurso) 
	{
		super(ID,titulo, descripcion, objetivos, dificultad,duracionEsperada, IDcreador);
		this.tipo = "RevisarRecurso";
		this.linkRecurso = linkRecurso;
	}

	public String getLinkRecurso() {
		return linkRecurso;
	}

	public void setLinkRecurso(String linkRecurso) {
		this.linkRecurso = linkRecurso;
	}
	
	
}
