package com.app;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import com.app.controller.ViviendaController;
import com.app.view.MainFrame;
import com.app.model.DAO.ViviendaDAO;
import com.app.model.Vivienda;
import java.util.List;
import javax.swing.SwingUtilities;

/**
 *
 * @author MariySabel
 */
public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
               ViviendaDAO DAO= new ViviendaDAO();
            @Override
            public void run() {
                MainFrame mainFrame = new MainFrame();
                ViviendaController controlVivienda= new ViviendaController(
                        mainFrame.getViviendaView(),
                        mainFrame.getTabbedPane(),
                        DAO);
                
                mainFrame.getViviendaView().cargarTabla((List<Vivienda>) controlVivienda.listar());
                
                mainFrame.setVisible(true);
            }
        });
    }
}
