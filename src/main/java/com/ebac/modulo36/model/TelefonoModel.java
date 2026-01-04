package com.ebac.modulo36.model;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;

import java.util.Objects;
import java.util.Optional;

public class TelefonoModel {
    private final MongoCollection<Document> collection;

    public TelefonoModel(MongoDatabase database){
        collection = database.getCollection("telefonos");
    }

    public void guardar(Document document){
        collection.insertOne(document);
    }

    public void obtener() {
        // Obtener todos los documentos (usuarios) de la colección
        FindIterable<Document> telefonos = collection.find();

        // Mostrar los resultados
        for (Document telefono : telefonos) {
            /*ObjectId id = telefono.getObjectId("_id");
            String idUsuario = telefono.getString("idUsuario");
            String numero = telefono.getString("numero");
            String tipo = telefono.getString("tipo");
            System.out.println("Id: " + id + ", Nombre: " + nombre + ", edad: " + edad);*/

            System.out.println(telefono);
        }
    }

    public Optional<Document> obtenerPorId(Document document) {
        // Obtener todos los documentos (usuarios) que hagan match con el documento enviado
        Document telefono = collection.find(document).first();

        if (!Objects.isNull(telefono)) {
            // Mostrar los resultados
            /*ObjectId id = telefono.getObjectId("_id");
            String idUsuario = telefono.getString("idUsuario");
            String numero = telefono.getString("numero");
            String tipo = telefono.getString("tipo");
            System.out.println("Id: " + id + ",
             idUsuario: " + idUsuario + ",
              numero: " + numero,
              ", tipo: " + tipo);*/

            System.out.println(telefono);
            return Optional.of(telefono);
        }

        return Optional.empty();
    }

    public void actualizar(Document documentoActual, Document documentoNuevo) {
        // Actualizar el libro que cumple con el filtro
        UpdateResult updateResult = collection.updateOne(documentoActual, documentoNuevo);

        if (updateResult.getModifiedCount() > 0) {
            System.out.println("Telefono actualizado con éxito.");
        } else {
            System.out.println("El telefono no fue encontrado.");
        }
    }

    public void eliminar(Document document) {
        // Eliminar el usuario que cumple con el filtro
        DeleteResult deleteResult = collection.deleteOne(document);

        if (deleteResult.getDeletedCount() > 0) {
            System.out.println("Telefono eliminado con éxito.");
        } else {
            System.out.println("El telefono no fue encontrado.");
        }
    }
}
