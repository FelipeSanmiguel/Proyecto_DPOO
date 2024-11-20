package actividadesTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.*;

import Actividades.*;
import Utilidad.ManagerID;
import java.util.*;

public class quizTests {
	
	private ManagerID manager1;
	
	QuizOpciones quiz4Opciones;
	QuizBool quizSiNo;
	ArrayList<Opcion> opcionesLista = new ArrayList<Opcion>();
	ArrayList<PreguntaOpciones> preguntasOpLista = new ArrayList<PreguntaOpciones>();
	ArrayList<PreguntaBool> preguntasBoolLista = new ArrayList<PreguntaBool>();
	
	@BeforeEach
    void setUp( ) throws Exception{
		
		/*
		 * Opcion
		 */
		
		String textoOpcion1 = "Seneca es una vaca";
		
		String textoOpcion2 = "Seneca es una cabra";
		
		String textoOpcion3 = "Seneca es una aguila";
		
		String textoOpcion4 = "Seneca es un estudiante de sistemas";
		
		
		
		Opcion Op1 = new Opcion(textoOpcion1,false);
		opcionesLista.add(Op1);
		
		Opcion Op2 = new Opcion(textoOpcion2,true);
		opcionesLista.add(Op2);
		
		Opcion Op3 = new Opcion(textoOpcion3,false);
		opcionesLista.add(Op3);
		
		Opcion Op4 = new Opcion(textoOpcion4,false);
		opcionesLista.add(Op4);
		
		PreguntaOpciones pregunta1Opciones = new PreguntaOpciones("Que es seneca","Seneca es una cabra de la universidad",opcionesLista);
		
		/*
		 * PreguntaOpciones
		 */
		preguntasOpLista.add(pregunta1Opciones);
		
		/*
		 * 
		 */
		
		this.manager1 = new ManagerID();
		
		int ID = this.manager1.crearIDUsuario();
		
		String titulo = "Quiz sobre Uniandes";
		
		String descripcion = "Responda todas las preguntas";
		
		String objetivos = "Aprender";
		
		String dificultad = "Alta";
		
		Duration duracionEsperada = Duration.ofHours(1);
		
		int puntajeMin = 5;
		
		int IDcreador = 1;
		
		
		
		quiz4Opciones = new QuizOpciones(ID,titulo,descripcion,objetivos,dificultad,duracionEsperada,IDcreador,puntajeMin,preguntasOpLista);
		
		/*
		 * QuizBool
		 */
		
		String preguntaBool = "Hay un gato en mi sobrero?";
		String explicacionBool = "No tengo un sombrero, asi que no";
		PreguntaBool preguntaSiNo = new PreguntaBool(preguntaBool,explicacionBool,false);
		
		int ID2 = this.manager1.crearIDUsuario();
		
		String titulo2 = "Quiz sobre Gaots";
		
		String descripcion2 = "Responda todas las preguntas";
		
		String objetivos2 = "Obtener sabiduria infinita";
		
		String dificultad2 = "Alta";
		
		Duration duracionEsperada2 = Duration.ofHours(1);
		
		int puntajeMin2 = 5;
		
		int IDcreador2 = 1;
		
		ArrayList<PreguntaBool> preguntas2 = new ArrayList<PreguntaBool>();
		
		preguntas2.add(preguntaSiNo);
		
		
		this.quizSiNo = new QuizBool(ID2,titulo2,descripcion2,objetivos2,dificultad2,duracionEsperada2,IDcreador2,puntajeMin2,preguntas2);
		
	}
	
	
	@AfterEach
    void tearDown( ) throws Exception
    {
    }
	
	
	@Test
	void mostrarOpciones() {
		ArrayList<PreguntaOpciones> preguntasPrueba = quiz4Opciones.getPreguntas();
		ArrayList<Opcion> opcionesDeRespuesta = preguntasPrueba.get(0).getOpciones();
		for(Opcion opcionPregunta: opcionesDeRespuesta) {
			System.out.println(opcionPregunta.getTextoOpcion());
		}
	}
	
	@Test
	void probarTipo4Opciones() {
		assertEquals( "QuizOpcion", quiz4Opciones.getTipo(), "El tipo no es el esperado." );
		
	}
	
	@Test
	void probarTipoBooleano() {
		assertEquals( "QuizBool", quizSiNo.getTipo(), "El tipo no es el esperado." );
		
	}
	
	
	
	
	
	
	

}
