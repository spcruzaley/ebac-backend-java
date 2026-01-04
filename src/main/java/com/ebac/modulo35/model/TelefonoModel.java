package com.ebac.modulo35.model;

import com.ebac.modulo35.dto.Telefono;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class TelefonoModel {

    private final EntityManager entityManager;

    public TelefonoModel(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void guardar(Telefono telefono){
        EntityTransaction transaction = entityManager.getTransaction();

        try{
            transaction.begin();
            entityManager.persist(telefono);
            transaction.commit();

        } catch (Exception e) {
            transaction.rollback();
        }
    }

    public void actualizar(Telefono telefono){
        EntityTransaction transaction = entityManager.getTransaction();

        try{
            transaction.begin();
            entityManager.merge(telefono);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }

    public Telefono obtenerPorId(int id){return entityManager.find(Telefono.class, id);}

    public void eliminar(Telefono telefono){
        EntityTransaction transaction = entityManager.getTransaction();

        try{
            transaction.begin();
            entityManager.remove(telefono);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }

    public List<Telefono> obtenerTelefonos(){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Telefono> cq = cb.createQuery(Telefono.class);

        Root<Telefono> rootEntry = cq.from(Telefono.class);
        CriteriaQuery<Telefono> select = cq.select(rootEntry);

        TypedQuery<Telefono> query = entityManager.createQuery(select);
        return query.getResultList();
    }
}
