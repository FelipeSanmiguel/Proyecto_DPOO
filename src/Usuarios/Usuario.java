package Usuarios;

public abstract class Usuario {
	
	int ID;
	
	String nombreUsuario;
	
	String contraseña;
	
	String tipoUsuario;
	
	public Usuario (int ID, String nombreUsuario, String contraseña) {
		this.ID = ID;
		this.nombreUsuario = nombreUsuario;
		this.contraseña = contraseña;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
	

}
