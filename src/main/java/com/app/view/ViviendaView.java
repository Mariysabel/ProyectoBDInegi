package com.app.view;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import com.app.model.Vivienda;

/**
 *
 * @author Mariysabel
 */
public class ViviendaView extends JPanel {

    public JButton btnAdd;
    public JButton btnActualizar;
    public JButton btnEliminar;
    public JTable tablaVivienda;
    private JScrollPane scrollTabla;
    public buscadorId buscador;

    public ViviendaView() {
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        // buscador
        FlowLayout fl = new FlowLayout(FlowLayout.LEFT, 10, 10);
        JPanel header = new JPanel(fl);
        buscador = new buscadorId("vivienda");
        header.add(buscador);
        add(header, BorderLayout.NORTH);

        // tabla
        tablaVivienda = new JTable();
        setPropiedadesTabla();

        scrollTabla = new JScrollPane(tablaVivienda);
        scrollTabla.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(scrollTabla, BorderLayout.CENTER);

        // menú lateral
        JPanel panelLateral = new JPanel();
        panelLateral.setLayout(new BoxLayout(panelLateral, BoxLayout.Y_AXIS));
        panelLateral.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // opcional

        btnActualizar = new JButton("ACTUALIZAR");
        btnEliminar = new JButton("ELIMINAR");
        btnAdd = new JButton("AÑADIR");

        Dimension d = new Dimension(140, 25);
        btnAdd.setPreferredSize(d);
        btnAdd.setMaximumSize(d);
        btnActualizar.setPreferredSize(d);
        btnActualizar.setMaximumSize(d);
        btnEliminar.setPreferredSize(d);
        btnEliminar.setMaximumSize(d);

        panelLateral.add(btnAdd);
        panelLateral.add(Box.createRigidArea(new Dimension(0, 10)));
        panelLateral.add(btnActualizar);
        panelLateral.add(Box.createRigidArea(new Dimension(0, 10)));
        panelLateral.add(btnEliminar);
        add(panelLateral, BorderLayout.EAST);

    }

    public void cargarTabla(List<Vivienda> lista) {
        if (lista.isEmpty()){
            JOptionPane.showMessageDialog(null,
                "NO EXISTEN REGISTROS CON ESAS CARACTERÍSTICAS", "Sin registros", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
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
        setPropiedadesTabla();
    }

    private void setPropiedadesTabla(){
        tablaVivienda.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tablaVivienda.setDefaultEditor(Object.class, null);
        tablaVivienda.setCellSelectionEnabled(false);
        tablaVivienda.getTableHeader().setReorderingAllowed(false);
        tablaVivienda.setRowSelectionAllowed(true);
    }

}
