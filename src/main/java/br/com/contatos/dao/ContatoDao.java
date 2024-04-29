package br.com.contatos.dao;

import br.com.contatos.model.Contato;
import jakarta.persistence.EntityManager;

public class ContatoDao {

    private EntityManager em;

    public ContatoDao(EntityManager em){
        this.em = em;
    }

    public void save(Contato contato){
        em.persist(contato);
    }

    public void update(Contato contato){
        em.merge(contato);
    }

    public void delete(Contato contato){
        Contato contactDelete = em.find(Contato.class,contato.getId());
        em.remove(contactDelete);
    }

    public void query(Long id){
        Contato contactQuery = em.find(Contato.class, id);
        if (contactQuery == null){
            System.out.println("Contato não foi encontrado");
        }else {
            System.out.println(contactQuery.toString());
        }
    }

}
