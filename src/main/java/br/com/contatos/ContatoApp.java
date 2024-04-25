package br.com.contatos;

import br.com.contatos.model.Contato;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class ContatoApp {

    public static void main(String[] args) {
        Contato contato = new Contato();
        contato.setNome("Caio Arruda");
        contato.setEmail("caio.rruda2019@gmail.com");
        contato.setDataNascimento(LocalDate.of(2003,5,21));

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contatos");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(contato);
        em.getTransaction().commit();
    }

}
