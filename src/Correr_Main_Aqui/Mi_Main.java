package Correr_Main_Aqui;

import java.time.Duration;

import Actividades.*;
import Usuarios.Estudiante;

import java.math.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import Utilidad.*;
import interfazSwing.*;
import AplicacionPaquete.*;
import Controllers.*;

public class Mi_Main {
	
	public static void main(String args[]) {
		
		Aplicacion sistema = new Aplicacion();
		ManagerID manager = new ManagerID();
		sistema.cargarPersistencia(manager);

		
		ControllerEstudiante controladorEstudiante = new ControllerEstudiante();
		ControllerProfesor controladorProfesor =  new ControllerProfesor();
		
		
		new ventanaLogIn( manager, sistema,controladorEstudiante,controladorProfesor );
		
	}
}
