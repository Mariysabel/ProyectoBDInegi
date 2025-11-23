/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.controller;

import com.app.view.forms.ViviendaInsert;
import com.app.view.*;
import com.app.model.*;
import com.app.model.DAO.*;
import com.app.view.forms.ViviendaActualizar;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author Mariysabel
 */
public class ViviendaController {

    private ViviendaView view;
    private ViviendaInsert viviendaInsert;
    private ViviendaActualizar viviendaActualizar;
    private ViviendaDAO dao;
    private JTabbedPane tabs;

    static int enti;
    static int muni;
    static int loc;

    public ViviendaController(ViviendaView view, JTabbedPane tabs, ViviendaDAO dao) {
        this.view = view;
        this.tabs = tabs;
        this.dao = dao;
        this.viviendaInsert = new ViviendaInsert();
        this.viviendaActualizar = new ViviendaActualizar();

        this.view.btnActualizar.addActionListener(e -> abrirFormActualizar());
        this.view.btnAdd.addActionListener(e -> abrirFormRegistro());
        this.view.btnEliminar.addActionListener(e -> eliminar());

        this.viviendaInsert.btnGuardar.addActionListener(e -> registroVivienda());
        this.viviendaActualizar.btnGuardar.addActionListener(e -> actualizar());

        this.viviendaActualizar.btnCerrar.addActionListener(e -> {
            viviendaActualizar.limpiar();
            cerrarTab(viviendaActualizar);
        });
        this.viviendaInsert.btnCerrar.addActionListener(e -> {
            viviendaInsert.limpiar();
            cerrarTab(viviendaInsert);
        });

        this.view.buscador.btnBuscarPorId.addActionListener(e -> buscar());
    }

    private void abrirFormRegistro() {
        tabs.add("REGISTRO VIVIENDA", viviendaInsert);
        tabs.setSelectedIndex(tabs.indexOfTab("REGISTRO VIVIENDA"));
    }

    private void abrirFormActualizar() {
        int row = view.tablaVivienda.getSelectedRow();
        if (row==-1){
            JOptionPane.showMessageDialog(null,
                "SELECCIONA UN REGISTRO PARA ACTUALIZAR","Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        enti = (int) view.tablaVivienda.getValueAt(row, 0);
        muni = (int) view.tablaVivienda.getValueAt(row, 1);
        loc = (int) view.tablaVivienda.getValueAt(row, 2);

        viviendaActualizar.txtEntidad.setText(enti + "");
        viviendaActualizar.txtMun.setText(muni + "");
        viviendaActualizar.txtLoc.setText(loc + "");

        tabs.add("ACTUALIZAR VIVIENDA", viviendaActualizar);
        tabs.setSelectedIndex(tabs.indexOfTab("ACTUALIZAR VIVIENDA"));
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
            viviendaInsert.limpiar();
            view.cargarTabla(listar());
            cerrarTab(viviendaInsert);
        } else {
            JOptionPane.showMessageDialog(null,
                    "NO SE PUDO :c");
            viviendaInsert.limpiar();
        }
    }

    private void actualizar() {
        Vivienda vivi = new Vivienda(
                Integer.parseInt(viviendaActualizar.getTxtEntidad().getText()),
                Integer.parseInt(viviendaActualizar.getTxtMun().getText()),
                Integer.parseInt(viviendaActualizar.getTxtLoc().getText()),
                Integer.parseInt(viviendaActualizar.getTxtVivTot().getText()),
                Integer.parseInt(viviendaActualizar.getTxtTvivHab().getText()),
                Integer.parseInt(viviendaActualizar.getTxtTvivPar().getText()),
                viviendaActualizar.getTxtVivparHab().getText(),
                viviendaActualizar.getTxtVivparhCv().getText(),
                viviendaActualizar.getTxtTvivparHab().getText(),
                viviendaActualizar.getTxtVivparDes().getText(),
                viviendaActualizar.getTxtVivparUt().getText(),
                viviendaActualizar.getTxtOcupVivPar().getText());
        boolean flag = dao.update(vivi, enti, muni, loc);
        if (flag) {
            JOptionPane.showMessageDialog(null,
                    "SI SE PUDO", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            viviendaActualizar.limpiar();
            view.cargarTabla(listar());
            cerrarTab(viviendaActualizar);
        } else {
            JOptionPane.showMessageDialog(null,
                    "NO SE PUDO :c", "Error", JOptionPane.ERROR_MESSAGE);
            viviendaInsert.limpiar();
        }
    }

    public void eliminar() {
        int row = view.tablaVivienda.getSelectedRow();
        if (row==-1){
            JOptionPane.showMessageDialog(null,
                "SELECCIONA UN REGISTRO A ELIMINAR","Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int opt = JOptionPane.showConfirmDialog(null, "¿Realmente desea eliminar el registro?" + mostrarRegistro(),
                "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

        if (opt == JOptionPane.YES_OPTION) {
            enti = (int) view.tablaVivienda.getValueAt(row, 0);
            muni = (int) view.tablaVivienda.getValueAt(row, 1);
            loc = (int) view.tablaVivienda.getValueAt(row, 2);

            boolean flag = dao.delete(enti, muni, loc);

            if (flag) {
                JOptionPane.showMessageDialog(null,
                        "SI SE PUDO", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                view.cargarTabla(listar());
            } else {
                JOptionPane.showMessageDialog(null,
                        "NO SE PUDO :c", "Error", JOptionPane.ERROR_MESSAGE);
                view.cargarTabla(listar());
            }
        }
    }

    public List<Vivienda> listar() {
        return dao.getAll();
    }

    private void buscar() {
        String senti = view.buscador.txtEntidad.getText();
        String smuni = view.buscador.txtMunicipio.getText();
        String sloc = view.buscador.txtLocalidad.getText();
        enti = (senti.isEmpty()) ? -1 : Integer.parseInt(senti);
        muni = (smuni.isEmpty()) ? -1 : Integer.parseInt(smuni);
        loc = (sloc.isEmpty()) ? -1 : Integer.parseInt(sloc);
        view.cargarTabla(dao.buscar(enti, muni, loc));
    }

    private String mostrarRegistro() {
        int row = view.tablaVivienda.getSelectedRow();
        String line = "\n";
        for (int x = 0; x < 12; x++) {
            line += view.tablaVivienda.getColumnName(x) + ": " + view.tablaVivienda.getValueAt(row, x) + "\n";
        }
        return line;
    }

    private void cerrarTab(JPanel panel) {
        tabs.setSelectedIndex(tabs.indexOfTab("Vivienda"));
        tabs.remove(panel);
    }

}
