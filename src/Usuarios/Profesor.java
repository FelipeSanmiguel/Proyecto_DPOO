package Usuarios;

import LearningPaths.*;
import java.util.*;

public class Profesor extends Usuario {
	
	private ArrayList<LearningPath> learningPathsCreados;
	
	public Profesor(int ID, String nombreUsuario, String contraseña) {
		super(ID, nombreUsuario, contraseña);
		this.learningPathsCreados = new ArrayList<LearningPath>();
		this.tipoUsuario = "Profesor";
		
	}
	
	public void añadirLP(LearningPath lp) {
		this.learningPathsCreados.add(lp);
	}
	
	public void quitarLP(LearningPath lp) {
		this.learningPathsCreados.remove(lp);
	}

}
