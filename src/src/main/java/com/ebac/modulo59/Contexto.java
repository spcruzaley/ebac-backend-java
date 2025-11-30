package com.ebac.modulo59;

import com.ebac.modulo59.entidades.Direccion;
import com.ebac.modulo59.modelos.DireccionModel;

public class Contexto {

    public void operacionConDirecciones() throws Exception {

        DireccionModel model = new DireccionModel();

        System.out.println("=== INSERTANDO DIRECCIÓN ===");
        Direccion direccion = new Direccion();
        direccion.setCalle("Av. México");
        direccion.setNumero("123");
        direccion.setCiudad("Guadalajara");
        direccion.setUsuarioId(1);

        model.guardar(direccion);
        System.out.println("Dirección guardada.");

        System.out.println("=== OBTENIENDO DIRECCIÓN CON ID 1 ===");
        Direccion obtenida = model.obtener(1);
        System.out.println("Dirección: " + obtenida.getCalle() + ", " + obtenida.getNumero());

        System.out.println("=== ACTUALIZANDO DIRECCIÓN ID 1 ===");
        obtenida.setCalle("Av. Vallarta");
        model.actualizar(obtenida);
        System.out.println("Dirección actualizada.");

        System.out.println("=== ELIMINANDO DIRECCIÓN ID 1 ===");
        model.eliminar(1);
        System.out.println("Dirección eliminada.");

        System.out.println("=== LISTANDO TODAS LAS DIRECCIONES ===");
        model.obtenerTodos().forEach(d -> {
            System.out.println(d.getId() + " - " + d.getCalle());
        });
    }
}
