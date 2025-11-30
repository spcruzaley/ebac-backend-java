package com.ebac.modulo59.modelos;

import com.ebac.modulo59.entidades.Telefono;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TelefonoModel {
    private Connection connection;

    public TelefonoModel(Connection connection) {
        this.connection = connection;
    }

    public void guardar(Telefono t) throws SQLException {
        String sql = "INSERT INTO telefonos(numero, tipo, usuario_id) VALUES(?, ?, ?)";

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, t.getNumero());
        ps.setString(2, t.getTipo());
        ps.setInt(3, t.getUsuarioId());
        ps.executeUpdate();
    }

    public List<Telefono> obtenerTodos() throws SQLException {
        List<Telefono> lista = new ArrayList<>();
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM telefonos");

        while (rs.next()) {
            Telefono t = new Telefono();
            t.setId(rs.getInt("id"));
            t.setNumero(rs.getString("numero"));
            t.setTipo(rs.getString("tipo"));
            t.setUsuarioId(rs.getInt("usuario_id"));
            lista.add(t);
        }
        return lista;
    }
}
