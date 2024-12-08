package interfazSwing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Controllers.*;
import AplicacionPaquete.*;
import Utilidad.*;

public class DashBoardEstudiante extends JFrame {

    private ManagerID manager;
    private Aplicacion sistema;
    private ControllerEstudiante controladorEstudiante;
    private ControllerProfesor controladorProfesor;

    private JList<String> listItems;
    private JButton btnIntereses;
    private JButton btnInscribirLp;
    private JButton btnQuitarLp;
    private JButton btnCrearReseña;
    private JButton btnAbrirLp;

    public DashBoardEstudiante(ManagerID manager, Aplicacion sistema, ControllerEstudiante controladorEstudiante, ControllerProfesor controladorProfesor) {
        this.manager = manager;
        this.sistema = sistema;
        this.controladorEstudiante = controladorEstudiante;
        this.controladorProfesor = controladorProfesor;

        
        setTitle("Dashboard Estudiante");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10)); 

       
        JPanel centerPanel = new JPanel(new BorderLayout());
        JLabel listTitle = new JLabel("Mis Learning Paths", JLabel.CENTER);
        listTitle.setFont(new Font("Arial", Font.BOLD, 16));
        listItems = new JList<>(new DefaultListModel<>());
        JScrollPane scrollPane = new JScrollPane(listItems);
        centerPanel.add(listTitle, BorderLayout.NORTH);
        centerPanel.add(scrollPane, BorderLayout.CENTER);
        add(centerPanel, BorderLayout.CENTER);

        
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new GridLayout(5, 1, 10, 10)); 

        
        btnIntereses = new JButton("Intereses");
        btnIntereses.setPreferredSize(new Dimension(150, 30)); 
        btnInscribirLp = new JButton("Inscribir LP");
        btnInscribirLp.setPreferredSize(new Dimension(150, 30)); 
        btnQuitarLp = new JButton("Quitar LP");
        btnQuitarLp.setPreferredSize(new Dimension(150, 30)); 
        btnCrearReseña = new JButton("Crear Reseña");
        btnCrearReseña.setPreferredSize(new Dimension(150, 30)); 
        btnAbrirLp = new JButton("Abrir LP");
        btnAbrirLp.setPreferredSize(new Dimension(150, 30)); 

        
        rightPanel.add(btnIntereses);
        rightPanel.add(btnInscribirLp);
        rightPanel.add(btnQuitarLp);
        rightPanel.add(btnCrearReseña);
        rightPanel.add(btnAbrirLp);

        
        add(rightPanel, BorderLayout.EAST);

        
        btnIntereses.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showInterests();
            }
        });

        btnInscribirLp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inscribirLP();
            }
        });

        btnQuitarLp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quitarLP();
            }
        });

        btnCrearReseña.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crearReseña();
            }
        });

        btnAbrirLp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirLP();
            }
        });
    }

    
    private void showInterests() {
        JOptionPane.showMessageDialog(this, "Intereses del usuario.", "Intereses", JOptionPane.INFORMATION_MESSAGE);
    }

    
    private void inscribirLP() {
        JOptionPane.showMessageDialog(this, "Inscribir al Learning Path.", "Inscribir LP", JOptionPane.INFORMATION_MESSAGE);
    }

    
    private void quitarLP() {
        JOptionPane.showMessageDialog(this, "Quitar el Learning Path.", "Quitar LP", JOptionPane.INFORMATION_MESSAGE);
    }

    
    private void crearReseña() {
        JOptionPane.showMessageDialog(this, "Crear una reseña para el Learning Path.", "Crear Reseña", JOptionPane.INFORMATION_MESSAGE);
    }

    
    private void abrirLP() {
        JOptionPane.showMessageDialog(this, "Abrir el Learning Path.", "Abrir LP", JOptionPane.INFORMATION_MESSAGE);
    }
}