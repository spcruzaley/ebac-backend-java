package com.ebac.modulo59.modelos;

import com.ebac.modulo59.entidades.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioModel {
    private Connection connection;

    public UsuarioModel(Connection connection) {
        this.connection = connection;
    }

    public void guardar(Usuario u) throws SQLException {
        String sql = "INSERT INTO usuarios(nombre, email) VALUES(?, ?)";

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, u.getNombre());
        ps.setString(2, u.getEmail());
        ps.executeUpdate();
    }

    public List<Usuario> obtenerTodos() throws SQLException {
        List<Usuario> lista = new ArrayList<>();
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM usuarios");

        while (rs.next()) {
            Usuario u = new Usuario();
            u.setId(rs.getInt("id"));
            u.setNombre(rs.getString("nombre"));
            u.setEmail(rs.getString("email"));
            lista.add(u);
        }
        return lista;
    }
}
