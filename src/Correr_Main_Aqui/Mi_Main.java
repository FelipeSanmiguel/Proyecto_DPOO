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

public class Mi_Main {
	
	public static void main(String args[]) {
		
		
		
        try {
            // Define the file path relative to the project root
            File file = new File("archivosPersistencia/example.txt");

            // Attempt to create the file
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getPath());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
		
	}
}
