package Complementarios;

public class Reseña {
	
	private String textoReseña;
	
	/*
	 * El rating es de 1 a 5
	 */
	private int rating;
	
	private int IDcreador;
	
	public Reseña(String texto, int rating, int IDcreador) {
		this.textoReseña = texto;
		this.rating = rating;
	}

	public String getTextoReseña() {
		return textoReseña;
	}

	public void setTextoReseña(String textoReseña) {
		this.textoReseña = textoReseña;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getIDcreador() {
		return IDcreador;
	}

	public void setIDcreador(int iDcreador) {
		IDcreador = iDcreador;
	}
	
	

}
