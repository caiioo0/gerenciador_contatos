package br.com.contatos;

import br.com.contatos.dao.Connection;
import br.com.contatos.dao.ContatoDao;
import br.com.contatos.model.Contato;
import jakarta.persistence.EntityManager;

import java.time.LocalDate;

public class ContatoApp {

    public static void main(String[] args) {
        EntityManager em = Connection.getEntityManger();
        //register(em);
        //update(em);
        //delete(em);
        queryContactPerId(em);

    }
    public static void register(EntityManager em){

        Contato contato = new Contato();
        contato.setNome("Caio Arruda");
        contato.setEmail("caio.rruda2019@gmail.com");
        contato.setDataNascimento(LocalDate.of(2002,4,10));

        ContatoDao contatoDao = new ContatoDao(em);

        em.getTransaction().begin();
        contatoDao.save(contato);
        em.getTransaction().commit();
    }

    public static void update(EntityManager em){

        Contato contato = new Contato();
        contato.setId(10L);
        contato.setNome("Caio Arruda");
        contato.setEmail("caio@gmail.com");
        contato.setDataNascimento(LocalDate.of(2002,4,10));

        ContatoDao contatoDao = new ContatoDao(em);

        em.getTransaction().begin();
        contatoDao.update(contato);
        em.getTransaction().commit();

    }
    public static void delete(EntityManager em){

        Contato contato = new Contato();
        contato.setId(10L);

        ContatoDao contatoDao = new ContatoDao(em);

        em.getTransaction().begin();
        contatoDao.delete(contato);
        em.getTransaction().commit();

    }

    public static void queryContactPerId(EntityManager em){

        ContatoDao contatoDao = new ContatoDao(em);

        em.getTransaction().begin();
        contatoDao.query(21L);
        em.getTransaction().commit();

    }

}
