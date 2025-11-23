/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.view;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author MarySabel
 */
public class buscadorId extends JPanel{
    public JTextField txtEntidad;
    public JTextField txtLocalidad;    
    public JTextField txtMunicipio;
    public JButton btnBuscarPorId;
    public String table;
    
    public buscadorId (String table){
        this.table = table;
        initComponents();
    }
    
    private void initComponents() {
        setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));
        
        //fields de buscador
        txtEntidad = new JTextField(20);
        txtLocalidad = new JTextField(20);
        txtMunicipio = new JTextField(20);
 
        add(new JLabel("Entidad"));
        add(txtEntidad);
        add(new JLabel("Municipio"));
        add(txtMunicipio);
        add(new JLabel("Localidad"));
        add(txtLocalidad);
        
        btnBuscarPorId = new JButton("BUSCAR");
        add(btnBuscarPorId);
        
        
    }
}
