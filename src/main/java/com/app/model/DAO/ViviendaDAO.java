/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.model.DAO;

import com.app.model.Conexion;
import com.app.model.Vivienda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Mariysabel
 */
public class ViviendaDAO {

    public boolean guardar(Vivienda vivienda) {

        String sql = "INSERT INTO vivienda ("
                + "ENTIDAD, MUN, LOC, VIVTOT, TVIVHAB, TVIVPAR, "
                + "VIVPAR_HAB, VIVPARH_CV, TVIVPARHAB, VIVPAR_DES, "
                + "VIVPAR_UT, OCUPVIVPAR"
                + ") VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

        try (Connection conn = Conexion.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            // PRIMARY KEY
            ps.setInt(1, vivienda.getENTIDAD());
            ps.setInt(2, vivienda.getMUN());
            ps.setInt(3, vivienda.getLOC());

            // INT
            ps.setInt(4, vivienda.getVIVTOT());
            ps.setInt(5, vivienda.getTVIVHAB());
            ps.setInt(6, vivienda.getTVIVPAR());

            // TEXT
            ps.setString(7, vivienda.getVIVPAR_HAB());
            ps.setString(8, vivienda.getVIVPARH_CV());
            ps.setString(9, vivienda.getTVIVPARHAB());
            ps.setString(10, vivienda.getVIVPAR_DES());
            ps.setString(11, vivienda.getVIVPAR_UT());
            ps.setString(12, vivienda.getOCUPVIVPAR());

            int filas = ps.executeUpdate();
            return filas > 0;

        } catch (SQLException e) {

            // Error de clave primaria duplicada (ENTIDAD, MUN, LOC)
            if ("23505".equals(e.getSQLState())) {
                JOptionPane.showMessageDialog(null,
                        "Este registro ya existe (ENTIDAD, MUN y LOC duplicados).");
                return false;
            }

            JOptionPane.showMessageDialog(null,
                    "Error al guardar la vivienda:\n" + e.getMessage());

            e.printStackTrace();
            return false;
        }
    }
    
    
    
    public List<Vivienda> getAll() {
        List<Vivienda> lista = new ArrayList<>();
        String sql = "SELECT * FROM vivienda";

        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Vivienda v = new Vivienda();

                v.setENTIDAD(rs.getShort("ENTIDAD")); // tinyint -> short
                v.setMUN(rs.getInt("MUN"));
                v.setLOC(rs.getInt("LOC"));
                v.setVIVTOT(rs.getInt("VIVTOT"));
                v.setTVIVHAB(rs.getInt("TVIVHAB"));
                v.setTVIVPAR(rs.getInt("TVIVPAR"));
                v.setVIVPAR_HAB(rs.getString("VIVPAR_HAB"));
                v.setVIVPARH_CV(rs.getString("VIVPARH_CV"));
                v.setTVIVPARHAB(rs.getString("TVIVPARHAB"));
                v.setVIVPAR_DES(rs.getString("VIVPAR_DES"));
                v.setVIVPAR_UT(rs.getString("VIVPAR_UT"));
                v.setOCUPVIVPAR(rs.getString("OCUPVIVPAR"));

                lista.add(v);
            }

        } catch (Exception e) {
            System.out.println("❌ Error al obtener viviendas: " + e.getMessage());
        }

        return lista;
    }

}
