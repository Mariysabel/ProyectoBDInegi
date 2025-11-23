package com.app.view;

import javax.swing.*;
import java.awt.*;
/**
 *
 * @author Mariysabel
 */
public class MainFrame extends JFrame {

    private JTabbedPane tabbedPane;
    private JPanel panelHeader;
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

        //todo: agregar el resto de paneles
        tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Inicio", new JLabel("Bienvenido"));
        tabbedPane.addTab("Vivienda", viviendaView);
        
        
        
        setLayout(new BorderLayout());
        add(panelHeader, BorderLayout.NORTH);
        add(tabbedPane, BorderLayout.CENTER);

        setTitle("BDInegi2020");
        setSize(1200, 600);
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
