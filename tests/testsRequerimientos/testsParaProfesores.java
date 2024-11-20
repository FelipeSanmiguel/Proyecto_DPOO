package testsRequerimientos;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Actividades.Tarea;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.*;
import java.util.ArrayList;

import Usuarios.*;
import LearningPaths.*;
import AplicacionPaquete.*;
import Utilidad.*;
import Controllers.*;
import Complementarios.*;



public class testsParaProfesores {
	
	private ManagerID manager1;
	private Aplicacion sistema;
	private ControllerEstudiante controladorEstudiantes;
	private ControllerProfesor controlador;
	
	@BeforeEach
    void setUp( ) throws Exception{
		
		this.manager1 = new ManagerID();
		this.sistema = new Aplicacion();
		this.controladorEstudiantes = new ControllerEstudiante();
		this.controlador = new ControllerProfesor();
		

		String nombreUsuario = "Roberto";
		String contraseña = "000";
		ArrayList<String> intereses = new ArrayList<String>();
		intereses.add("Medicina");
		
		
		String nombreUsuario2 = "Camilo";
		String contraseña2 = "456";
		ArrayList<String> intereses2 = new ArrayList<String>();
		intereses.add("Matematicas");
		
		String nombreProfe1 = "Juan";
		String contraseñaProfe1 = "789";
		
		this.controladorEstudiantes.crearUsuario(nombreUsuario, contraseña, intereses, manager1, sistema);
		this.controladorEstudiantes.crearUsuario(nombreUsuario2, contraseña2, intereses2, manager1, sistema);
		
		this.controlador.crearUsuario(nombreProfe1, contraseñaProfe1, manager1, sistema);
		
		String titulo = "Como imitar al profe";
		String descripcion = "Aqui aprenderan como parecerse al todo poderoso profesor";
		String objetivos = "Convertirse en un ser perfecto, fallar en el intento del primer objetivo";
		String dificultad = "Baja";
		
		this.controlador.seleccionarUsuario("Juan", "789", this.sistema);
		this.controlador.crearLP(titulo, descripcion, objetivos, dificultad, this.manager1, this.sistema);

		
	}
	
	@AfterEach
    void tearDown( ) throws Exception
    {
    }
	
	@Test
	void probarCreacionLP() {
		
		this.controladorEstudiantes.seleccionarUsuario("Roberto", "000", this.sistema);
		this.controladorEstudiantes.registrarseEnLP(0, sistema);
		
		
		LearningPath pruebaLP = null;
		for(LearningPath iter:sistema.getListaLearningPaths()) {
			if(iter.getID() == 0) {
				pruebaLP = iter;
			}
		}
		
		int ID = pruebaLP.getListaEstudiantes().get(0).getElEstudianteID();
		String nombreComp = null;
		
		for(Usuario iter: this.sistema.getListaUsuarios()) {
			if(iter.getID()==ID && iter.getClass() == Estudiante.class) {
				nombreComp = iter.getNombreUsuario();
			}
			
		}
		
		assertEquals( "Roberto", nombreComp, "El LP fue creado Con exito" );
	}
	
	
	
	
	
	
	

}
