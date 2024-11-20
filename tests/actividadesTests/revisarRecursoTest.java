package actividadesTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.*;

import Actividades.*;
import Utilidad.ManagerID;

public class revisarRecursoTest {

	private ManagerID manager1;
	private RevisarRecurso verVideo;
	
	@BeforeEach
    void setUp( ) throws Exception{
		
		this.manager1 = new ManagerID();
		
		int ID = this.manager1.crearIDUsuario();
		
		String titulo = "Aprendiendo programacion OO";
		
		String descripcion = "Leer los mil y un principios del programador uniandino";
		
		String objetivos = "Homologar la carrera";
		
		String dificultad = "Baja";
		
		Duration duracionEsperada = Duration.ofHours(1);
		
		String elLink = "youtube";
		
		int IDcreador = 1;
		
		verVideo = new RevisarRecurso(ID, titulo,descripcion,objetivos,dificultad,duracionEsperada,IDcreador,elLink);
	}
	
	@AfterEach
    void tearDown( ) throws Exception
    {
    }
	
	@Test
	void probarTipo() {
		assertEquals( "RevisarRecurso", verVideo.getTipo(), "El tipo no es el esperado." );
		
	}
	
	
}
