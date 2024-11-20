package actividadesTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.*;

import Actividades.*;
import Utilidad.ManagerID;

public class tareaTests {
	private ManagerID manager1;
	private Tarea tarea1;
	
	@BeforeEach
    void setUp( ) throws Exception{
		
		this.manager1 = new ManagerID();
		
		int ID = this.manager1.crearIDUsuario();
		
		String titulo = "Aprendiendo programacion OO";
		
		String descripcion = "Leer los mil y un principios del programador uniandino";
		
		String objetivos = "Homologar la carrera";
		
		String dificultad = "Baja";
		
		Duration duracionEsperada = Duration.ofHours(1);
		
		int IDcreador = 1;
		
		tarea1 = new Tarea(ID, titulo,descripcion,objetivos,dificultad,duracionEsperada,IDcreador);
	}
	
	@AfterEach
    void tearDown( ) throws Exception
    {
    }
	
	@Test
	void probarTitulo() {
		assertEquals( "Aprendiendo programacion OO", tarea1.getTitulo( ), "El titulo no es el esperado." );
	}
	
	@Test
	void probarDescripcion() {
		assertEquals( "Leer los mil y un principios del programador uniandino", tarea1.getDescripcion( ), "La descripcion no es la esperada." );
	}
	
	@Test
	void probarObjetivos() {
		assertEquals( "Homologar la carrera", tarea1.getObjetivos( ), "El objetivo no es el esperado." );
	}
	
	@Test
	void probarDificultad() {
		assertEquals( "Baja", tarea1.getDificultad( ), "La dificultad no es la esperada." );
	}
	
	@Test
	void probarDuracionEsperada() {
		Duration duracionPrueba = Duration.ofHours(1);
		assertEquals( duracionPrueba, tarea1.getDuracionEsperada( ), "La duracion no es la esperada." );
	}
	
	@Test
	void probarResultado() {
		assertEquals( 0, tarea1.getResultado( ), "El resultado por defecto (N.A) es incorrecto." );
	}
	
	@Test
	void probarCompletada() {
		assertEquals( 0, tarea1.getResultado( ), "El resultado por defecto (N.A) es incorrecto." );
		assertEquals( false, tarea1.getCompletada( ), "El resultado por defecto (N.A) es incorrecto." );
		
		tarea1.setCompletada(true);
		tarea1.setResultado(5);
		
		assertEquals( 5, tarea1.getResultado( ), "El resultado por defecto (N.A) es incorrecto." );
		assertEquals( true, tarea1.getCompletada( ), "El resultado por defecto (N.A) es incorrecto." );
	}
	
	@Test
	void probarTipo() {
		assertEquals( "Tarea", tarea1.getTipo(), "El tipo no es el esperado." );
		
	}
	
	@Test
	void probarIDCreador() {
		assertEquals( 1, tarea1.getIDCreador(), "El tipo no es el esperado." );
		
	}
	
	
}
