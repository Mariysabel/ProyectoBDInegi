package com.app.view;

import javax.swing.*;
import java.awt.*;

public class ViviendaView extends JPanel {
    public static JButton btnAdd;

    public ViviendaView() {
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        FlowLayout fl = new FlowLayout(FlowLayout.RIGHT, 10, 10);
        JPanel header = new JPanel(fl);

        btnAdd = new JButton("AÑADIR");
        header.add(btnAdd);

        add(header, BorderLayout.NORTH);
        
    }
}
