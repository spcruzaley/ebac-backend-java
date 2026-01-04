package com.ebac.modulo35;

import com.ebac.modulo35.dto.Telefono;
import com.ebac.modulo35.dto.Usuario;
import com.ebac.modulo35.model.TelefonoModel;
import com.ebac.modulo35.model.UsuarioModel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class Contexto {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("coneccionLocalMySQL");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

//        UsuarioModel usuarioModel = new UsuarioModel(entityManager);
//
//        // Crear usuario
//        Usuario usuarioJuan = new Usuario();
//        usuarioJuan.setNombre("Juan");
//        usuarioJuan.setEdad(20);
//        usuarioModel.guardar(usuarioJuan);

        // Obtener usuario
//        Usuario usuario = usuarioModel.obtenerPorId(2);
//        System.out.println("Usuario Juan: " + usuario);

        // Actualizar usuario
//      usuarioModel.actualizar(usuario);

//      Usuario usuarioJuanActualizado = usuarioModel.obtenerPorId(2);
//       System.out.println("Usuario Juan actualizado: " + usuarioJuanActualizado);
//
//        /*Usuario usuario = usuarioModel.obtenerPorId(1);

        //eliminar usuario
//        usuarioModel.eliminar(usuario);
//        usuario = usuarioModel.obtenerPorId(1);
//        System.out.println("Usuario Juan: " + usuario);

        //crearUsuarios(15, usuarioModel);

//        usuarioModel.obtenerUsuarios()
//                .forEach(System.out::println);

        //Telefono
        TelefonoModel telefonoModel = new TelefonoModel(entityManager);

        //Crear Telefono
        Telefono tel1 = new Telefono();
        tel1.setIdUsuario(2);
        tel1.setNumero("+52 111 223 45 46");
        tel1.setTipo("celular");
        telefonoModel.guardar(tel1);

        //obtener todos los telefonos
        List<Telefono> telefonos = telefonoModel.obtenerTelefonos();
        telefonos.forEach(telefono -> System.out.println(telefono));

        //obtener por id
        System.out.println("telefono con el id 2 -> " + telefonoModel.obtenerPorId(2));

        //actualizar
        Telefono telefonoConId3 = telefonoModel.obtenerPorId(3);
        telefonoConId3.setNumero("+52 333 999 63 36");
        telefonoModel.actualizar(telefonoConId3);

        //obtener el telefono actualizado
        System.out.println("telefono actualizado -> " + telefonoModel.obtenerPorId(3));

        //eliminar
        Telefono telefonoParaEliminar = telefonoModel.obtenerPorId(5);
        telefonoModel.eliminar(telefonoParaEliminar);
        System.out.println(telefonoModel.obtenerTelefonos());


        // Cerrar la conexion
        entityManager.close();
        entityManagerFactory.close();
    }

    private static void crearUsuarios(int num, UsuarioModel usuarioModel) {
        Usuario usuario;
        for (int i = 0; i < num; i++) {
            usuario = new Usuario();
            usuario.setNombre("Usuario-"+i);
            usuario.setEdad(20+i);

            usuarioModel.guardar(usuario);
        }
    }
}
