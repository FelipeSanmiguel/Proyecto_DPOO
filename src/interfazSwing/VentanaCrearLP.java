package interfazSwing;

import javax.swing.*;

import AplicacionPaquete.Aplicacion;
import Controllers.ControllerEstudiante;
import Controllers.ControllerProfesor;
import Utilidad.ManagerID;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaCrearLP extends JFrame {
	
	private ManagerID manager;
	
	private Aplicacion sistema;
	
	private ControllerEstudiante controladorEstudiante;
	
	private ControllerProfesor controladorProfesor;

    public VentanaCrearLP(ManagerID manager, Aplicacion sistema,ControllerEstudiante controladorEstudiante,ControllerProfesor controladorProfesor) {
		this.manager = manager;
		this.sistema = sistema;
		this.controladorEstudiante = controladorEstudiante;
		this.controladorProfesor = controladorProfesor;
    	
        
        setTitle("Crear Learning Path");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(5, 2, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        
        JLabel tituloLabel = new JLabel("Titulo:");
        JTextField tituloField = new JTextField();
        mainPanel.add(tituloLabel);
        mainPanel.add(tituloField);

        
        JLabel descripcionLabel = new JLabel("Descripcion:");
        JTextField descripcionField = new JTextField();
        mainPanel.add(descripcionLabel);
        mainPanel.add(descripcionField);

        
        JLabel objetivosLabel = new JLabel("Objetivos:");
        JTextField objetivosField = new JTextField();
        mainPanel.add(objetivosLabel);
        mainPanel.add(objetivosField);

        
        JLabel dificultadLabel = new JLabel("Dificultad:");
        String[] dificultades = {"Baja", "Media", "Alta"};
        JComboBox<String> dificultadCombo = new JComboBox<>(dificultades);
        mainPanel.add(dificultadLabel);
        mainPanel.add(dificultadCombo);

        
        add(mainPanel, BorderLayout.CENTER);

        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        
        JButton confirmarButton = new JButton("Confirmar");
        buttonPanel.add(confirmarButton);

        
        JButton cancelarButton = new JButton("Cancelar");
        buttonPanel.add(cancelarButton);

        
        add(buttonPanel, BorderLayout.SOUTH);

        
        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String titulo = tituloField.getText().trim();
                String descripcion = descripcionField.getText().trim();
                String objetivos = objetivosField.getText().trim();
                String dificultad = (String) dificultadCombo.getSelectedItem();

                if (titulo.isEmpty() || descripcion.isEmpty() || objetivos.isEmpty()) {
                    JOptionPane.showMessageDialog(
                        VentanaCrearLP.this,
                        "Todos los campos deben estar llenos.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                    );
                } else {
                    
                    JOptionPane.showMessageDialog(
                        VentanaCrearLP.this,
                        "Learning Path creado con éxito:\n" +
                        "Titulo: " + titulo + "\n" +
                        "Descripcion: " + descripcion + "\n" +
                        "Objetivos: " + objetivos + "\n" +
                        "Dificultad: " + dificultad,
                        "Confirmación",
                        JOptionPane.INFORMATION_MESSAGE
                    );
                    dispose(); 
                }
            }
        });

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); 
            }
        });

        
        setVisible(true);
    }
}