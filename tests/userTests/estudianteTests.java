package userTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Actividades.*;
import Utilidad.*;
import Usuarios.*;

public class estudianteTests {

	private Estudiante estudiante1;
	
	
	private ManagerID manager1;
	
	
	@BeforeEach
    void setUp( ) throws Exception{
		
		this.manager1 = new ManagerID();
		
		int nuevoID = manager1.crearIDUsuario();
		
		String nombreUsuario = "Roberto";
		String contraseña = "000";
		ArrayList<String> intereses = new ArrayList<String>();
		intereses.add("Medicina");
		
		this.estudiante1 = new Estudiante(nuevoID, nombreUsuario, contraseña, intereses);
		
		
	}
	
	@AfterEach
    void tearDown( ) throws Exception
    {
    }
	
	@Test
	void probarTipo() {
		assertEquals( "Estudiante", estudiante1.getTipoUsuario(), "El tipo no es el esperado." );
		
	}
	
	@Test
	void probarContraseña() {
		assertEquals( "000", estudiante1.getContraseña(), "El tipo no es el esperado." );
		
	}
	
	
	
	
}
