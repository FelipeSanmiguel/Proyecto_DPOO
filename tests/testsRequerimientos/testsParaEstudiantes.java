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

public class testsParaEstudiantes {
	
	private ManagerID manager1;
	private Aplicacion sistema;
	private ControllerEstudiante controlador;
	
	

	@BeforeEach
    void setUp( ) throws Exception{
		
		this.manager1 = new ManagerID();
		this.sistema = new Aplicacion();
		this.controlador = new ControllerEstudiante();
		

		String nombreUsuario = "Roberto";
		String contraseña = "000";
		ArrayList<String> intereses = new ArrayList<String>();
		intereses.add("Medicina");
		
		
		String nombreUsuario2 = "Camilo";
		String contraseña2 = "456";
		ArrayList<String> intereses2 = new ArrayList<String>();
		intereses.add("Matematicas");
		
		
		this.controlador.crearUsuario(nombreUsuario, contraseña, intereses, manager1, sistema);
		this.controlador.crearUsuario(nombreUsuario2, contraseña2, intereses2, manager1, sistema);
		
		int ID = this.manager1.crearIDLP();
		String titulo = "Como imitar al profe";
		String descripcion = "Aqui aprenderan como parecerse al todo poderoso profesor";
		String objetivos = "Convertirse en un ser perfecto, fallar en el intento del primer objetivo";
		String dificultad = "Baja";
		
		LearningPath nuevoLP = new LearningPath(ID,titulo,descripcion,objetivos,dificultad);
		
		this.sistema.addLP(nuevoLP);
		
	}
	
	@AfterEach
    void tearDown( ) throws Exception
    {
    }
	
	@Test
	void probarCreacionEstudiante() {
		
		String nombre = this.sistema.getListaUsuarios().get(0).getNombreUsuario();
		assertEquals( "Roberto", nombre, "El titulo no es el esperado." );
	}
	
	@Test
	void probarCreacionEstudiante2IDs() {
		
		int ID2 = this.sistema.getListaUsuarios().get(1).getID();
		assertEquals( 1, ID2, "El titulo no es el esperado." );
	}
	
	@Test
	void loginUsiario() {
		
		this.controlador.seleccionarUsuario("Roberto", "000", this.sistema);
		String nombre = this.sistema.getListaUsuarios().get(0).getNombreUsuario();
		Usuario estudiante = this.controlador.getUsuarioActual();
		assertEquals("Roberto" , estudiante.getNombreUsuario(), "El titulo no es el esperado." );
	}
	
	@Test
	void probarRetornoIntereses() {
		
		this.controlador.seleccionarUsuario("Roberto", "000", this.sistema);
		String interes = this.controlador.verInteresesUsuario().get(0);
		assertEquals( "Medicina", interes, "El titulo no es el esperado." );
	}
	
	@Test
	void probarCreacionReseña() {
		
		this.controlador.seleccionarUsuario("Roberto", "000", this.sistema);
		String textoReseña = "Este LP arreglo mi vida y me permitio volver el mejor ingeniero del mundo";
		int rating = 5;
		int IDcreador = this.controlador.getUsuarioActual().getID();
		
		
		this.controlador.crearReseñaLP(0, textoReseña, rating, this.sistema);
		
		String textoComparar = this.sistema.getListaLearningPaths().get(0).getListaReseñas().get(0).getTextoReseña();
		
		assertEquals( "Este LP arreglo mi vida y me permitio volver el mejor ingeniero del mundo",textoComparar , "El titulo no es el esperado." );
	}
	
	@Test
	void probarInscripcionLP() {
		
		this.controlador.seleccionarUsuario("Roberto", "000", this.sistema);
		this.controlador.registrarseEnLP(0, sistema);
		
		
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
		
		assertEquals( "Roberto", nombreComp, "El titulo no es el esperado." );
	}
	
	
	
	
	
	
	
	
}
