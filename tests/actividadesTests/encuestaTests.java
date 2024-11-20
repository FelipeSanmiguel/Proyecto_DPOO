package actividadesTests;

import java.util.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.*;

import Actividades.*;
import Utilidad.ManagerID;

public class encuestaTests {
	
	private Encuesta encuesta1;
	
	private ManagerID manager1;
	
	@BeforeEach
    void setUp( ) throws Exception{
		
		this.manager1 = new ManagerID();
		
		int ID = this.manager1.crearIDUsuario();
		
		String titulo = "Que opina de la U";
		
		String descripcion = "Responda mis preguntas";
		
		String objetivos = "Incrementar el conocimiento del profe";
		
		String dificultad = "Baja";
		
		Duration duracionEsperada = Duration.ofHours(1);
		
		int IDcreador = 1;
		
		ArrayList<String> preguntasAbiertas = new ArrayList<String>();
		
		preguntasAbiertas.add("Considera necesario entrenamiento de balance para sistemas? Porque?");
		preguntasAbiertas.add("Que opina del programa de subsidio de notas?");
		
		this.encuesta1 = new Encuesta(ID,titulo,descripcion,objetivos,dificultad,duracionEsperada,IDcreador,preguntasAbiertas);
		
	}
	
	@AfterEach
    void tearDown( ) throws Exception
    {
    }
	
	@Test
	void probarTipo() {
		assertEquals( "Encuesta", encuesta1.getTipo(), "El tipo no es el esperado." );
		
	}
	
	@Test
	void probarTitulo() {
		assertEquals( "Que opina de la U", encuesta1.getTitulo(), "El titulo no es el esperado." );
		
	}
	
	@Test
	void probarPreguntas() {
		String pregunta;
		
		pregunta = this.encuesta1.getPreguntasAbiertas().get(0);
		
		assertEquals( "Considera necesario entrenamiento de balance para sistemas? Porque?", pregunta, "La pregunta no es la esperada." );
		
		
		pregunta = this.encuesta1.getPreguntasAbiertas().get(1);
		assertEquals( "Que opina del programa de subsidio de notas?", pregunta, "La pregunta no es la esperada." );
		
		
	}
	
	

}







