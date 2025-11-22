package com.app.view;

import com.app.controller.ViviendaController;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author Mariysabel
 */
public class MainFrame extends JFrame {

    private JTabbedPane tabbedPane;
    private JPanel panelHeader;
    private JPanel panelDerecha;
    private ViviendaView viviendaView;

    public MainFrame() {
        initComponents();
    }

    private void initComponents() {
        panelHeader = new JPanel();
        JLabel titulo = new JLabel("BDInegi2020");
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 26));
        
        this.viviendaView=new ViviendaView();
        panelHeader.add(titulo);

        panelDerecha = new JPanel();
        panelDerecha.setLayout(new BoxLayout(panelDerecha, BoxLayout.Y_AXIS));

        JButton btn1 = new JButton("Actualizar");
        JButton btn2 = new JButton("Eliminar");

        // Alineación centrada
        btn1.setAlignmentX(Component.CENTER_ALIGNMENT);
        btn2.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelDerecha.add(Box.createVerticalStrut(20));
        panelDerecha.add(btn1);
        panelDerecha.add(Box.createVerticalStrut(10));
        panelDerecha.add(btn2);
        panelDerecha.add(Box.createVerticalGlue());
        
        // todo: agregar el resto de paneles
        tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Inicio", new JLabel("Bienvenido"));
        tabbedPane.addTab("Vivienda", viviendaView);
        
        
        
        setLayout(new BorderLayout());
        add(panelHeader, BorderLayout.NORTH);
        add(panelDerecha, BorderLayout.EAST);
        add(tabbedPane, BorderLayout.CENTER);

        setTitle("BDInegi2020");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public ViviendaView getViviendaView(){
        return viviendaView;
    }
     
    public JTabbedPane getTabbedPane(){
        return this.tabbedPane;
    }
}
