package com.ebac.modulo59.modelos;

import com.ebac.modulo59.conexion.MysqlConnection;
import com.ebac.modulo59.entidades.Direccion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DireccionModel {

    public void guardar(Direccion direccion) throws Exception {
        Connection conexion = MysqlConnection.getConnection();

        String sql = "INSERT INTO direcciones (calle, numero, ciudad, usuario_id) VALUES (?, ?, ?, ?)";

        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setString(1, direccion.getCalle());
        stmt.setString(2, direccion.getNumero());
        stmt.setString(3, direccion.getCiudad());
        stmt.setInt(4, direccion.getUsuarioId());

        stmt.executeUpdate();
        stmt.close();
        conexion.close();
    }

    public void actualizar(Direccion direccion) throws Exception {
        Connection conexion = MysqlConnection.getConnection();

        String sql = "UPDATE direcciones SET calle = ?, numero = ?, ciudad = ?, usuario_id = ? WHERE id = ?";

        PreparedStatement stmt = conexion.prepareStatement(sql);

        stmt.setString(1, direccion.getCalle());
        stmt.setString(2, direccion.getNumero());
        stmt.setString(3, direccion.getCiudad());
        stmt.setInt(4, direccion.getUsuarioId());
        stmt.setInt(5, direccion.getId());

        stmt.executeUpdate();
        stmt.close();
        conexion.close();
    }

    public void eliminar(int id) throws Exception {
        Connection conexion = MysqlConnection.getConnection();

        String sql = "DELETE FROM direcciones WHERE id = ?";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setInt(1, id);

        stmt.executeUpdate();
        stmt.close();
        conexion.close();
    }

    public Direccion obtener(int id) throws Exception {
        Connection conexion = MysqlConnection.getConnection();

        String sql = "SELECT * FROM direcciones WHERE id = ?";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();

        Direccion direccion = null;
        if (rs.next()) {
            direccion = new Direccion(
                    rs.getInt("id"),
                    rs.getString("calle"),
                    rs.getString("numero"),
                    rs.getString("ciudad"),
                    rs.getInt("usuario_id")
            );
        }

        rs.close();
        stmt.close();
        conexion.close();

        return direccion;
    }

    public List<Direccion> obtenerTodos() throws Exception {
        Connection conexion = MysqlConnection.getConnection();

        String sql = "SELECT * FROM direcciones";
        Statement stmt = conexion.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        List<Direccion> lista = new ArrayList<>();

        while (rs.next()) {
            Direccion direccion = new Direccion(
                    rs.getInt("id"),
                    rs.getString("calle"),
                    rs.getString("numero"),
                    rs.getString("ciudad"),
                    rs.getInt("usuario_id")
            );
            lista.add(direccion);
        }

        rs.close();
        stmt.close();
        conexion.close();

        return lista;
    }
}
