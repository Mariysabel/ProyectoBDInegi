/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.controller;

import com.app.view.*;
import com.app.view.insert.*;
import com.app.model.*;
import com.app.model.DAO.*;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

/**
 *
 * @author Mariysabel
 */
public class ViviendaController {

    private ViviendaView view;
    private ViviendaInsert viviendaInsert;
    private Vivienda model;
    private ViviendaDAO dao;
    private JTabbedPane tabs;

    public ViviendaController(ViviendaView view, JTabbedPane tabs, ViviendaDAO dao) {
        this.view = view;
        this.tabs = tabs;
        this.dao=dao;
        this.viviendaInsert = new ViviendaInsert();
        this.view.btnAdd.addActionListener(e -> abrirFromRegistro());
        this.viviendaInsert.btnGuardar.addActionListener(e -> registroVivienda());
    }

    private void abrirFromRegistro() {
        tabs.add("REGISTRO VIVIENDA", viviendaInsert);
        tabs.setSelectedIndex(tabs.indexOfTab("REGISTRO VIVIENDA"));
    }

    private void registroVivienda() {
        Vivienda vivi = new Vivienda(Integer.parseInt(viviendaInsert.getTxtEntidad().getText()),
                Integer.parseInt(viviendaInsert.getTxtMun().getText()),
                Integer.parseInt(viviendaInsert.getTxtLoc().getText()),
                Integer.parseInt(viviendaInsert.getTxtVivTot().getText()),
                Integer.parseInt(viviendaInsert.getTxtTvivHab().getText()),
                Integer.parseInt(viviendaInsert.getTxtTvivPar().getText()),
                viviendaInsert.getTxtVivparHab().getText(),
                viviendaInsert.getTxtVivparhCv().getText(),
                viviendaInsert.getTxtTvivparHab().getText(),
                viviendaInsert.getTxtVivparDes().getText(),
                viviendaInsert.getTxtVivparUt().getText(),
                viviendaInsert.getTxtOcupVivPar().getText());
        boolean flag = dao.guardar(vivi);
        if (flag) {
            JOptionPane.showMessageDialog(null,
                    "SI SE PUDO");
                    view.cargarTabla(listar());
                    tabs.setSelectedIndex(tabs.indexOfTab("Vivienda"));
                    tabs.remove(viviendaInsert);
        } else {
            JOptionPane.showMessageDialog(null,
                    "NO SE PUDO :c");
                    viviendaInsert.limpiar();
        }
    }
    
    public List<Vivienda> listar() {
        return dao.getAll();
    }

}
