package interfazSwing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;

import interfazSwing.*;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JOptionPane;

import Utilidad.*;
import AplicacionPaquete.*;
import Controllers.*;

import java.util.*;

public class ventanaLogIn extends JFrame implements ActionListener {
	
	private ManagerID manager;
	
	private Aplicacion sistema;
	
	private ControllerEstudiante controladorEstudiante;
	
	private ControllerProfesor controladorProfesor;
	

	
	/*
	 * 
	 */
	
	private JRadioButton radioProfesor;
	
	private JRadioButton radioEstudiante;
	
	private JTextField txtUsuario;
	
	private JTextField txtPassword;
	
	private JButton botonCrear;
	
	private JButton bottonLogin;
	
	 private static final String CREAR = "crear";

	    
	private static final String LOGIN = "login";
	
	
	public ventanaLogIn ( ManagerID manager, Aplicacion sistema,ControllerEstudiante controladorEstudiante,ControllerProfesor controladorProfesor) {
		this.manager = manager;
		this.sistema = sistema;
		this.controladorEstudiante = controladorEstudiante;
		this.controladorProfesor = controladorProfesor;
		
		
		setTitle( "Inicio Sesion" );
	    setDefaultCloseOperation( EXIT_ON_CLOSE );
	    setSize( 700, 700 );
	    setLocationRelativeTo( null );
	    setLayout(null);
	    
	    
	    // Crea el campo para el nombre con una etiqueta al frente
    	JLabel labelTextoUsuario = new JLabel("Usuario: ");
    	txtUsuario = new JTextField();
    	labelTextoUsuario.setBounds(50,200,75,25);
    	txtUsuario.setBounds(200,200,250,25);
    	
    	 // Crea el campo para el nombre con una etiqueta al frente
    	JLabel labelTextoPassword = new JLabel("Contraseña: ");
    	txtPassword = new JTextField();
    	labelTextoPassword.setBounds(50,300,100,25);
    	txtPassword.setBounds(200,300,250,25);
    	
    	JPanel panelRadios = new JPanel();
    	panelRadios.setLayout(new FlowLayout());
    	panelRadios.setBounds(250,350,200,50);
    	
    	ButtonGroup grupo = new ButtonGroup();
    	radioProfesor = new JRadioButton("Profesor");
    	radioEstudiante = new JRadioButton("Estudiante");
    	radioProfesor.setSelected(true);
    	panelRadios.add(radioProfesor);
    	panelRadios.add(radioEstudiante);
    	
    	
    	grupo.add(radioEstudiante);
    	grupo.add(radioProfesor);
    	panelRadios.add(radioProfesor);
    	panelRadios.add(radioEstudiante);
    	
    	
    	JPanel panelBotones = new JPanel();
    	panelBotones.setLayout(new FlowLayout());
    	bottonLogin = new JButton("Login");
    	bottonLogin.setActionCommand(LOGIN);
    	bottonLogin.addActionListener(this);
    	/*
    	 * 
    	 */
    	botonCrear = new JButton("Crear");
    	botonCrear.setActionCommand(CREAR);
    	botonCrear.addActionListener(this);
    	panelBotones.add(bottonLogin);
    	panelBotones.add(botonCrear);
    	panelBotones.setBounds(200,450,300,300);
    	
    	
    	add(labelTextoUsuario);
    	add(labelTextoPassword);
    	add(txtUsuario);
    	add(txtPassword);
    	add(panelRadios);
    	add(panelBotones);
	    
	   
	    
	    
	    setVisible( true );
	}
	
	@Override
    public void actionPerformed( ActionEvent e )
    {
		String comando = e.getActionCommand( );
        if( comando.equals( CREAR ) )
        {
        	String usuario = txtUsuario.getText().trim();
            String contraseña = txtPassword.getText().trim();

            if (usuario.isEmpty() || contraseña.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Usuario y Contraseña no pueden estar vacíos.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        	
        	if (radioEstudiante.isSelected()) {
        		
        		ArrayList<String> intereses = new ArrayList<String>();
        		
        		boolean creado = controladorEstudiante.crearUsuario(txtUsuario.getText(), txtPassword.getText(),intereses, manager, sistema);
        		if(creado) {
        			JOptionPane.showMessageDialog(null, "Usuario Creado", "Exitos", JOptionPane.PLAIN_MESSAGE);
        		}
        		else {
        			JOptionPane.showMessageDialog(null, "El usuario ya existe", "Error", JOptionPane.PLAIN_MESSAGE);
        			
        		}
        		
        	}
        	else if(radioProfesor.isSelected()){
        		
        		boolean creado = controladorProfesor.crearUsuario(txtUsuario.getText(), txtPassword.getText(),manager, sistema);
        		if(creado) {
        			JOptionPane.showMessageDialog(null, "Usuario Creado", "Exitos", JOptionPane.PLAIN_MESSAGE);
        		}
        		else {
        			JOptionPane.showMessageDialog(null, "El usuario ya existe", "Error", JOptionPane.PLAIN_MESSAGE);
        		}
        		
        	}
        	
        	
        	System.out.println("Crear");
        }
        else if( comando.equals( LOGIN ) )
        {
        	if (radioEstudiante.isSelected()) {
        		boolean encontroEstudiante = controladorEstudiante.seleccionarUsuario(txtUsuario.getText(), txtPassword.getText(), sistema);
        		if(encontroEstudiante) {
        			openDashBoardEstudiante();
        			System.out.println("EntroE");
        		}
        		else {
        			JOptionPane.showMessageDialog(null, "El usuario o Contraseña son incorrectos!", "Error", JOptionPane.PLAIN_MESSAGE);
        			
        		}
        		
        	}
        	else if(radioProfesor.isSelected()){
        		boolean encontroProfesor = controladorProfesor.seleccionarUsuario(txtUsuario.getText(), txtPassword.getText(), sistema);
        		if(encontroProfesor) {
        			System.out.println("EntroP");
        		}
        		else {
        			JOptionPane.showMessageDialog(null, "El usuario o Contraseña son incorrectos!", "Error", JOptionPane.PLAIN_MESSAGE);
        		}
        		
        	}
        	
        	
        }
        
    }
	
	private void openDashBoardEstudiante() {
        this.dispose();

        DashBoardEstudiante dashboard = new DashBoardEstudiante(manager, sistema, controladorEstudiante, controladorProfesor);
        dashboard.setVisible(true);
    }
	
}
