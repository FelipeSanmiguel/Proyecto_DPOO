package interfazSwing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import AplicacionPaquete.Aplicacion;
import Controllers.ControllerEstudiante;
import Controllers.ControllerProfesor;
import Utilidad.ManagerID;

public class DashBoardProfesor extends JFrame {

    private ManagerID manager;
    private Aplicacion sistema;
    private ControllerProfesor controladorProfesor;

    private JList<String> listaLearningPaths;
    private JList<String> listaActividades;

    private JButton botonAbrirActividad;
    private JButton botonCrearActividad;
    private JButton botonAbrirLP;
    private JButton botonCrearLP;
    private JButton botonBuscar;
    private JButton botonCrearReseña;

    public DashBoardProfesor(ManagerID manager, Aplicacion sistema, ControllerProfesor controladorProfesor,ControllerEstudiante controladorEstudiante) {
        this.manager = manager;
        this.sistema = sistema;
        this.controladorProfesor = controladorProfesor;

        setTitle("Dashboard Profesor");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());

        
        JPanel panelListas = new JPanel();
        panelListas.setLayout(new GridLayout(1, 2));

        
        DefaultListModel<String> modeloLPs = new DefaultListModel<>();
        listaLearningPaths = new JList<>(modeloLPs);
        JScrollPane scrollLPs = new JScrollPane(listaLearningPaths);
        scrollLPs.setBorder(BorderFactory.createTitledBorder("Mis Learning Paths"));

        
        DefaultListModel<String> modeloActividades = new DefaultListModel<>();
        listaActividades = new JList<>(modeloActividades);
        JScrollPane scrollActividades = new JScrollPane(listaActividades);
        scrollActividades.setBorder(BorderFactory.createTitledBorder("Mis Actividades"));

        panelListas.add(scrollLPs);
        panelListas.add(scrollActividades);

        
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(6, 1, 10, 10)); 

        botonAbrirActividad = new JButton("Abrir Actividad");
        botonCrearActividad = new JButton("Crear Actividad");
        botonAbrirLP = new JButton("Abrir LP");
        botonCrearLP = new JButton("Crear LP");
        botonBuscar = new JButton("Buscar");
        botonCrearReseña = new JButton("Crear Reseña"); 

        panelBotones.add(botonAbrirActividad);
        panelBotones.add(botonCrearActividad);
        panelBotones.add(botonAbrirLP);
        panelBotones.add(botonCrearLP);
        panelBotones.add(botonBuscar);
        panelBotones.add(botonCrearReseña); 

        
        add(panelListas, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.EAST);

        setVisible(true);

        
        botonCrearReseña.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	VentanaReseña ventanaParaReseña = new VentanaReseña(manager, sistema, controladorEstudiante, controladorProfesor,0);
            }
        });

        botonAbrirActividad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Abrir Actividad no implementado.");
            }
        });

        botonCrearActividad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Crear Actividad no implementado.");
            }
        });

        botonAbrirLP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Abrir LP no implementado.");
            }
        });

        botonCrearLP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	VentanaCrearLP ventanaParaLP = new VentanaCrearLP(manager, sistema, controladorEstudiante, controladorProfesor);
            }
        });

        botonBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Buscar no implementado.");
            }
        });
    }
}