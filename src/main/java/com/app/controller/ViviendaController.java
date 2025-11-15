/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.controller;

import com.app.view.*;
import com.app.view.insert.*;
import com.app.model.*;
import com.app.model.DAO.*;
import javax.swing.JTabbedPane;

/**
 *
 * @author Factor
 */
public class ViviendaController {

    private ViviendaView view;
    private ViviendaInsert viviendaInsert;
    private Vivienda model;
    private ViviendaDAO dao;
    private JTabbedPane tabs;

    public ViviendaController(ViviendaView view, JTabbedPane tabs) {
        this.view = view;
        this.tabs=tabs;
        this.viviendaInsert = new ViviendaInsert();
        this.view.btnAdd.addActionListener(e -> abrirFromRegistro());
        this.viviendaInsert.btnGuardar.addActionListener(e -> registroVivienda());
    }

    private void abrirFromRegistro() {
        tabs.add("REGISTRO VIVIENDA", viviendaInsert);
        tabs.setSelectedIndex(tabs.indexOfTab("REGISTRO VIVIENDA"));
    }
    
    private void registroVivienda(){
        System.out.println("SE REGISTRA UNA VIVIENDA");
    }

}
