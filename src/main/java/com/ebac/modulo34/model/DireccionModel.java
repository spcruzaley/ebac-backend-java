package com.ebac.modulo34.model;

import com.ebac.modulo34.dto.Direccion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DireccionModel implements OperacionesCRUD<Direccion> {

    private Connection connection;

    public DireccionModel(Connection connection){
        this.connection = connection;
    }

    @Override
    public Direccion guardar(Direccion direccion) throws SQLException {
        String query = "INSERT INTO direcciones (calle, numero, estado, CP) VALUES(?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, direccion.getCalle());
        statement.setInt(2, direccion.getNumero());
        statement.setString(3, direccion.getEstado());
        statement.setInt(4, direccion.getCP());

        int elementosinsertados = statement.executeUpdate();
        if(elementosinsertados == 1){
            return direccion;
        }else{
            throw new SQLException("Hubo un error en la inserción");
        }


    }

    @Override
    public Direccion actualizarPorId(Direccion direccion) throws SQLException {

        String query = "UPDATE direcciones SET calle = ?, numero = ?, estado = ?, CP = ? WHERE idDirecciones = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, direccion.getCalle());
        statement.setInt(2, direccion.getNumero());
        statement.setString(3, direccion.getEstado());
        statement.setInt(4, direccion.getCP());
        statement.setInt(5, direccion.getIdDireccion());

        int elementosinsertados = statement.executeUpdate();
        if(elementosinsertados == 1){
            return direccion;
        }else{
            throw new SQLException("Hubo un error en el update");
        }
    }

    @Override
    public int eliminarPorId(int id) throws SQLException {

        String query = "DELETE FROM direcciones WHERE idDirecciones = ?";

        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);

        return statement.executeUpdate();
    }

    @Override
    public Direccion obtenerPorId(int id) throws SQLException {
        String query = "SELECT * FROM direcciones WHERE idDirecciones = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();
        Direccion direccion = new Direccion();
        while(resultSet.next()){
            direccion.setIdDireccion(resultSet.getInt("idDirecciones"));
            direccion.setCalle(resultSet.getString("calle"));
            direccion.setNumero(resultSet.getInt("numero"));
            direccion.setEstado(resultSet.getString("estado"));
            direccion.setCP(resultSet.getInt("CP"));
        }

        return direccion;
    }
}