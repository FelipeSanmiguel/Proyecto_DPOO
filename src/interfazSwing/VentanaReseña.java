package interfazSwing;

import javax.swing.*;

import AplicacionPaquete.Aplicacion;
import Controllers.ControllerEstudiante;
import Controllers.ControllerProfesor;
import Utilidad.ManagerID;

import java.awt.*;
import java.awt.event.ActionEvent;

public class VentanaReseña {
	
		private ManagerID manager;
	    private Aplicacion sistema;
	    private ControllerEstudiante controladorEstudiante;
	    private ControllerProfesor controladorProfesor;
	    private int ver;
	    
	    
	
    public VentanaReseña(ManagerID manager, Aplicacion sistema, ControllerEstudiante controladorEstudiante, ControllerProfesor controladorProfesor,int ver) {
    	this.manager = manager;
        this.sistema = sistema;
        this.controladorEstudiante = controladorEstudiante;
        this.controladorProfesor = controladorProfesor;
        this.ver = ver;
    	
    	
        JFrame frame = new JFrame("Agregar Reseña");
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        
        JLabel tituloLabel = new JLabel("Agregar tu Reseña", SwingConstants.CENTER);
        tituloLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        frame.add(tituloLabel, BorderLayout.NORTH);

        
        JPanel centralPanel = new JPanel();
        centralPanel.setLayout(new BorderLayout());
        centralPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        
        JTextArea textoReseña = new JTextArea(5, 30);
        textoReseña.setLineWrap(true);
        textoReseña.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(textoReseña);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Escribe tu reseña:"));
        centralPanel.add(scrollPane, BorderLayout.CENTER);

        
        JPanel calificacionPanel = new JPanel();
        calificacionPanel.setLayout(new GridLayout(2, 1, 10, 10)); 
        calificacionPanel.setBorder(BorderFactory.createTitledBorder("Información adicional:"));

        
        JPanel estrellasPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel estrellasLabel = new JLabel("Calificacón:");
        JComboBox<Integer> calificacionCombo = new JComboBox<>(new Integer[]{1, 2, 3, 4, 5});
        estrellasPanel.add(estrellasLabel);
        estrellasPanel.add(calificacionCombo);

        
        JPanel idPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel idLabel = new JLabel("ID de la Actividad:");
        JTextField idField = new JTextField(10); 
        idPanel.add(idLabel);
        idPanel.add(idField);

        
        calificacionPanel.add(estrellasPanel);
        calificacionPanel.add(idPanel);

        centralPanel.add(calificacionPanel, BorderLayout.SOUTH);
        frame.add(centralPanel, BorderLayout.CENTER);

        
        JPanel botonesPanel = new JPanel();
        botonesPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        botonesPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton guardarButton = new JButton("Guardar");
        

        JButton cancelarButton = new JButton("Cancelar");
        

        botonesPanel.add(guardarButton);
        botonesPanel.add(cancelarButton);
        frame.add(botonesPanel, BorderLayout.SOUTH);

        /*
         * Codigo
         */
        guardarButton.addActionListener((ActionEvent e) -> {
            String reseña = textoReseña.getText().trim();
            int calificacion = (int) calificacionCombo.getSelectedItem();
            String idActividad = idField.getText().trim();

            if (idActividad.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "El ID de la actividad no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            } 
            else {
                if(ver == 1) {
                	int IDparaActividad = Integer.parseInt(idActividad);
                	controladorEstudiante.crearReseñaActividad(IDparaActividad,reseña,calificacion, sistema);
                }
                else {
                	
                }
                frame.dispose();
            }
        });

        
        cancelarButton.addActionListener((ActionEvent e) -> frame.dispose());

        
        frame.setVisible(true);
    }
}