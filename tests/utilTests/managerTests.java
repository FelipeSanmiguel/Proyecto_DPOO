package utilTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.*;

import Actividades.*;
import Usuarios.*;
import Utilidad.*;

public class managerTests {
	
	private ManagerID manager1;
	
	private Estudiante estudiante1;
	private Estudiante estudiante2;
	
	@BeforeEach
    void setUp( ) throws Exception{
		this.manager1 = new ManagerID();
		
		int nuevoID = manager1.crearIDUsuario();
		
		String nombreUsuario = "Juan";
		String contraseña = "123";
		ArrayList<String> intereses = new ArrayList<String>();
		intereses.add("Arte");
		
		this.estudiante1 = new Estudiante(nuevoID, nombreUsuario, contraseña, intereses);
		
		int nuevoID2 = manager1.crearIDUsuario();
		String nombreUsuario2 = "Camilo";
		String contraseña2 = "456";
		ArrayList<String> intereses2 = new ArrayList<String>();
		intereses.add("Matematicas");
		
		this.estudiante2 = new Estudiante(nuevoID2, nombreUsuario2, contraseña2, intereses2);
		
		
	}
	
	@AfterEach
    void tearDown( ) throws Exception
    {
    }
	
	@Test
	void crearNuevoIDUsuario() {
		assertEquals( 0, estudiante1.getID( ), "El ID no es el esperado." );
	}
	
	@Test
	void crear2NuevosIDUsuario() {
		
		assertEquals( 1, estudiante2.getID( ), "El ID no es el esperado." );
	}

}
