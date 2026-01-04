package com.ebac.modulo36;

import com.ebac.modulo36.model.TelefonoModel;
import com.ebac.modulo36.model.UsuarioModel;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.Optional;

public class Contexto {

    public static void main(String[] args) {
        String connectionString =
                "mongodb://root:root@localhost:27017/modulo60?authSource=admin";

        MongoClient mongoClient = MongoClients.create(connectionString);
        MongoDatabase database = mongoClient.getDatabase("modulo60");

//        UsuarioModel usuarioModel = new UsuarioModel(database);
//
//
//        // Crear un usuario
//        Document document = new Document("nombre", "Isaac")
//                .append("edad", 31)
//                .append("profesion", "Programador Java");
//        usuarioModel.guardar(document);

        // Listar usuarios
//         usuarioModel.obtener();

        // Listar usuairo por id
//        ObjectId objectId = new ObjectId("64b9d18405148c2056cf6f2b");
//        Document documentoABuscar = new Document("_id", objectId);
//        Optional<Document> usuarioEncontrado = usuarioModel.obtenerPorId(documentoABuscar);

        // Actualizar usuario
        /*usuarioEncontrado.ifPresent(usuarioActual -> {
            Document document = new Document("nombre", "PedroActualizado").append("edad", 20);
            Document usuarioActualizado = new Document("$set", document);

            usuarioModel.actualizar(usuarioActual, usuarioActualizado);
        });
        usuarioModel.obtener();*/

        // Eliminar usuario
//        usuarioModel.obtener();
//        usuarioEncontrado.ifPresent(usuarioModel::eliminar);
//        usuarioModel.obtener();

        TelefonoModel telModel = new TelefonoModel(database);

        //Crear un telefono
//        Document document2 = new Document("idUsuario", "6959df916cca6d46afb42f96")
//                .append("numero", "+52 333 147 12 78")
//                .append("tipo", "celular");
//        telModel.guardar(document2);

        // Listar telefonos
         telModel.obtener();

        // Listar telefono por id
        ObjectId objectId = new ObjectId("6959e0f7e8e66c74428dcd50");
      Document documentoABuscar = new Document("_id", objectId);
       Optional<Document> telefonoEncontrado = telModel.obtenerPorId(documentoABuscar);

        // Actualizar usuario
        telefonoEncontrado.ifPresent(usuarioActual -> {
            Document document = new Document("numero", "+52 222 333 44 55").append("tipo", "casa");
            Document usuarioActualizado = new Document("$set", document);

            telModel.actualizar(usuarioActual, usuarioActualizado);
        });
        telModel.obtener();

        // Eliminar usuario
//        telModel.obtener();
//        telefonoEncontrado.ifPresent(telModel::eliminar);
//        telModel.obtener();
    }
}
