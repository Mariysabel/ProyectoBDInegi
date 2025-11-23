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

            //Error de clave primaria duplicada
            if ("23505".equals(e.getSQLState())) {
                JOptionPane.showMessageDialog(null,
                        "Este registro ya existe (ENTIDAD, MUN y LOC duplicados).");
                return false;
            }
            
            //Error de clave que no exixte
            if (e.getErrorCode() == 1452) {
                JOptionPane.showMessageDialog(null,
                        "No puedes guardar la vivienda porque la ENTIDAD, MUN o LOC no existen.\n"
                        + "Primero debes registrar esa localidad.");
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

        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Vivienda v = new Vivienda();

                v.setENTIDAD(rs.getShort("ENTIDAD"));
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
            System.out.println("Error al obtener viviendas: " + e.getMessage());
        }

        return lista;
    }

    public boolean update(Vivienda nueva, int antENTIDAD, int antMUN, int antLOC) {
        Connection con = null;
        PreparedStatement ps = null;

        String sql = "UPDATE vivienda SET "
                + "ENTIDAD = ?, MUN = ?, LOC = ?, "
                + "VIVTOT = ?, TVIVHAB = ?, TVIVPAR = ?, "
                + "VIVPAR_HAB = ?, VIVPARH_CV = ?, TVIVPARHAB = ?, "
                + "VIVPAR_DES = ?, VIVPAR_UT = ?, OCUPVIVPAR = ? "
                + "WHERE ENTIDAD = ? AND MUN = ? AND LOC = ?";

        try {
            con = Conexion.getConnection();
            ps = con.prepareStatement(sql);

            // NUEVOS valores
            ps.setInt(1, nueva.getENTIDAD());
            ps.setInt(2, nueva.getMUN());
            ps.setInt(3, nueva.getLOC());
            ps.setInt(4, nueva.getVIVTOT());
            ps.setInt(5, nueva.getTVIVHAB());
            ps.setInt(6, nueva.getTVIVPAR());
            ps.setString(7, nueva.getVIVPAR_HAB());
            ps.setString(8, nueva.getVIVPARH_CV());
            ps.setString(9, nueva.getTVIVPARHAB());
            ps.setString(10, nueva.getVIVPAR_DES());
            ps.setString(11, nueva.getVIVPAR_UT());
            ps.setString(12, nueva.getOCUPVIVPAR());

            // PK ANTIGUA 
            ps.setInt(13, antENTIDAD);
            ps.setInt(14, antMUN);
            ps.setInt(15, antLOC);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            if ("23505".equals(e.getSQLState())) {
                JOptionPane.showMessageDialog(null, "No se puede actualizar. La nueva clave primaria ya existe.");
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar vivienda: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            return false;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
            }
        }
    }

    public boolean delete(int entidad, int mun, int loc) {
        String sql = "DELETE FROM vivienda WHERE ENTIDAD = ? AND MUN = ? AND LOC = ?";

        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, entidad);
            ps.setInt(2, mun);
            ps.setInt(3, loc);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar: " + e.getMessage());
            return false;
        }
    }

    public List<Vivienda> buscar(int entidad, int mun, int loc) {
        System.out.println("entra a buscar");
        List<Vivienda> lista = new ArrayList<>();

        String sql = "SELECT * FROM vivienda WHERE 1=1";

        if (entidad > -1) {
            sql += " AND ENTIDAD = ?";
        }
        if (mun > -1) {
            sql += " AND MUN = ?";
        }
        if (loc > -1) {
            sql += " AND LOC = ?";
        }

        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            int index = 1;

            if (entidad > -1) {
                ps.setInt(index++, entidad);
            }
            if (mun > -1) {
                ps.setInt(index++, mun);
            }
            if (loc > -1) {
                ps.setInt(index++, loc);
            }

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Vivienda v = new Vivienda();

                v.setENTIDAD(rs.getShort("ENTIDAD"));
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

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar viviendas:\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return lista;
    }

}
