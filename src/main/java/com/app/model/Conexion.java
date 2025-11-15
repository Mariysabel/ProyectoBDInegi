package com.app.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    // Cambiar estos valores por los de tu configuración
    private static final String URL = "jdbc:mysql://localhost:3306/bdinegi2020";
    private static final String USER = "root"; 
    private static final String PASS = "agregar_contraseña";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}