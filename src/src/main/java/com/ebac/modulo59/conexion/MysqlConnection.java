package com.ebac.modulo59.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/modulo59_pruebas";
    private static final String USER = "root";
    private static final String PASSWORD = "TU_PASSWORD";

    public Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
