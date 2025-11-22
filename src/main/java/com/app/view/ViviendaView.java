package com.app.view;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import com.app.model.Vivienda;

public class ViviendaView extends JPanel {

    public static JButton btnAdd;
    private JTable tablaVivienda;            
    private JScrollPane scrollTabla;         

    public ViviendaView() {
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        // ----------- HEADER -----------
        FlowLayout fl = new FlowLayout(FlowLayout.RIGHT, 10, 10);
        JPanel header = new JPanel(fl);

        btnAdd = new JButton("AÑADIR");
        header.add(btnAdd);

        add(header, BorderLayout.NORTH);

        // ----------- TABLA -----------
        tablaVivienda = new JTable();
        scrollTabla = new JScrollPane(tablaVivienda);
        
   
        add(scrollTabla, BorderLayout.CENTER);
    }

    // ----------- MÉTODO PARA CARGAR TABLA -----------
    public void cargarTabla(List<Vivienda> lista) {

        String[] columnas = {
            "ENTIDAD", "MUN", "LOC", "VIVTOT", "TVIVHAB", "TVIVPAR",
            "VIVPAR_HAB", "VIVPARH_CV", "TVIVPARHAB", "VIVPAR_DES",
            "VIVPAR_UT", "OCUPVIVPAR"
        };

        javax.swing.table.DefaultTableModel modelo = new javax.swing.table.DefaultTableModel(null, columnas);

        for (Vivienda v : lista) {
            modelo.addRow(new Object[]{
                v.getENTIDAD(),
                v.getMUN(),
                v.getLOC(),
                v.getVIVTOT(),
                v.getTVIVHAB(),
                v.getTVIVPAR(),
                v.getVIVPAR_HAB(),
                v.getVIVPARH_CV(),
                v.getTVIVPARHAB(),
                v.getVIVPAR_DES(),
                v.getVIVPAR_UT(),
                v.getOCUPVIVPAR()
            });
        }

        tablaVivienda.setModel(modelo);
    }
}