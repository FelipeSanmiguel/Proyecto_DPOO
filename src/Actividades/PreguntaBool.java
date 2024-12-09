package Actividades;

public class PreguntaBool {
	
	private String textoPregunta;
	
	private String explicacionRespuesta;
	
	private Boolean verdadero;
	
	public PreguntaBool(String textoPregunta, String explicacionRespuesta, Boolean verdadero) {
		
		this.textoPregunta = textoPregunta;
		this.explicacionRespuesta = explicacionRespuesta;
		this.verdadero = verdadero;
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

	public Boolean getVerdadero() {
		return verdadero;
	}

	public void setVerdadero(Boolean verdadero) {
		this.verdadero = verdadero;
	}

}
