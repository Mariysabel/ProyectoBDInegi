/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.view.forms;

import java.awt.*;
import javax.swing.*;

/*

 *
 * @author Mariysabel
 */
public class ViviendaActualizar extends JPanel {

    public JTextField txtEntidad;
    public JTextField txtMun;
    public JTextField txtLoc;

    private JTextField txtVivTot;
    private JTextField txtTvivHab;
    private JTextField txtTvivPar;

    private JTextField txtVivparHab;
    private JTextField txtVivparhCv;
    private JTextField txtTvivparHab;
    private JTextField txtVivparDes;
    private JTextField txtVivparUt;
    private JTextField txtOcupVivPar;

    public JButton btnGuardar;
    public JButton btnCerrar;

    public ViviendaActualizar() {
        initComponents();
    }

    private void initComponents() {

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        int fila = 0;

        // MÉTODO PARA AGREGAR ETIQUETA + TEXTO
        addField("ENTIDAD:", txtEntidad = new JTextField(), gbc, fila++);
        addField("MUN:", txtMun = new JTextField(), gbc, fila++);
        addField("LOC:", txtLoc = new JTextField(), gbc, fila++);
        addField("VIVTOT:", txtVivTot = new JTextField(), gbc, fila++);
        addField("TVIVHAB:", txtTvivHab = new JTextField(), gbc, fila++);
        addField("TVIVPAR:", txtTvivPar = new JTextField(), gbc, fila++);
        addField("VIVPAR_HAB:", txtVivparHab = new JTextField(), gbc, fila++);
        addField("VIVPARH_CV:", txtVivparhCv = new JTextField(), gbc, fila++);
        addField("TVIVPARHAB:", txtTvivparHab = new JTextField(), gbc, fila++);
        addField("VIVPAR_DES:", txtVivparDes = new JTextField(), gbc, fila++);
        addField("VIVPAR_UT:", txtVivparUt = new JTextField(), gbc, fila++);
        addField("OCUPVIVPAR:", txtOcupVivPar = new JTextField(), gbc, fila++);

        // BOTONES
        btnGuardar = new JButton("Actualizar");
        btnCerrar = new JButton ("Cerrar");

        gbc.gridx = 1;
        gbc.gridy = fila;
        gbc.anchor = GridBagConstraints.CENTER;

        add(btnGuardar, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = fila;
        gbc.anchor = GridBagConstraints.CENTER;

        add(btnCerrar, gbc);
    }

    // MÉTODO REUTILIZABLE PARA CAMPOS
    private void addField(String label, JTextField field, GridBagConstraints gbc, int row) {
        gbc.gridx = 0;
        gbc.gridy = row;
        add(new JLabel(label), gbc);

        gbc.gridx = 1;
        gbc.gridy = row;
        field.setPreferredSize(new Dimension(300, 25));
        add(field, gbc);
    }

    public void limpiar() {
        getTxtEntidad().setText("");
        getTxtMun().setText("");
        getTxtLoc().setText("");

        getTxtVivTot().setText("");
        getTxtTvivHab().setText("");
        getTxtTvivPar().setText("");

        getTxtVivparHab().setText("");
        getTxtVivparhCv().setText("");
        getTxtTvivparHab().setText("");
        getTxtVivparDes().setText("");
        getTxtVivparUt().setText("");
        getTxtOcupVivPar().setText("");
    }

    public JTextField getTxtEntidad() {
        return txtEntidad;
    }

    public JTextField getTxtMun() {
        return txtMun;
    }

    public JTextField getTxtLoc() {
        return txtLoc;
    }

    public JTextField getTxtVivTot() {
        return txtVivTot;
    }

    public JTextField getTxtTvivHab() {
        return txtTvivHab;
    }

    public JTextField getTxtTvivPar() {
        return txtTvivPar;
    }

    public JTextField getTxtVivparHab() {
        return txtVivparHab;
    }

    public JTextField getTxtVivparhCv() {
        return txtVivparhCv;
    }

    public JTextField getTxtTvivparHab() {
        return txtTvivparHab;
    }

    public JTextField getTxtVivparDes() {
        return txtVivparDes;
    }

    public JTextField getTxtVivparUt() {
        return txtVivparUt;
    }

    public JTextField getTxtOcupVivPar() {
        return txtOcupVivPar;
    }

    public JButton getBtnGuardar() {
        return btnGuardar;
    }
}