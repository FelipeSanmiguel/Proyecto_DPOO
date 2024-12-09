package Actividades;

public class Opcion {

	private String textoOpcion;
	
	private Boolean correcta;
	
	public Opcion(String textoOpcion, Boolean correcta) {
		this.textoOpcion = textoOpcion;
		this.correcta =  correcta;
	}

	public String getTextoOpcion() {
		return textoOpcion;
	}

	public void setTextoOpcion(String textoOpcion) {
		this.textoOpcion = textoOpcion;
	}

	public Boolean getCorrecta() {
		return correcta;
	}

	public void setCorrecta(Boolean correcta) {
		this.correcta = correcta;
	}
	
}
