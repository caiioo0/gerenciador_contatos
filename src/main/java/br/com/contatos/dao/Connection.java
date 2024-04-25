package br.com.contatos.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Connection {
    public static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("contatos");

    public static EntityManager getEntityManger(){
        return EMF.createEntityManager();
    }

}
