package Actividades;

import java.util.*;

public class PreguntaOpciones {
	
	String textoPregunta;
	
	String explicacionRespuesta;
	
	ArrayList<Opcion> opciones;
	
	public PreguntaOpciones(String texto,String explicacion, ArrayList<Opcion> opciones) {
		this.textoPregunta = texto;
		this.explicacionRespuesta = explicacion;
		this.opciones = opciones;
	}

	public String getTextoPregunta() {
		return textoPregunta;
	}

	public void setTextoPregunta(String textoPregunta) {
		this.textoPregunta = textoPregunta;
	}

	public String getExplicacionRespuesta() {
		return explicacionRespuesta;
	}

	public void setExplicacionRespuesta(String explicacionRespuesta) {
		this.explicacionRespuesta = explicacionRespuesta;
	}

	public ArrayList<Opcion> getOpciones() {
		return opciones;
	}

	public void setOpciones(ArrayList<Opcion> opciones) {
		this.opciones = opciones;
	}

}
