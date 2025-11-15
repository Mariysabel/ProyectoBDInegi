package com.app;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import com.app.controller.ViviendaController;
import com.app.view.MainFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author Factor
 */
public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                MainFrame mainFrame = new MainFrame();
                ViviendaController controlVivienda= new ViviendaController(
                        mainFrame.getViviendaView(),
                        mainFrame.getTabbedPane());

                mainFrame.setVisible(true);
            }
        });
    }
}
