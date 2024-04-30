package br.com.contatos;

import br.com.contatos.dao.Connection;
import br.com.contatos.dao.ContatoDao;
import br.com.contatos.model.Contato;
import jakarta.persistence.EntityManager;

import java.time.LocalDate;
import java.util.List;

public class ContatoApp {

    public static void main(String[] args) {
        EntityManager em = Connection.getEntityManger();
        //register(em);
        //update(em);
        //delete(em);
        consultaPorId(em);
        //consultarTodosOsContatos(em);
        //consultarContatosPorEmail(em);
        //consultarContatosPorNome(em);
    }

    public static void register(EntityManager em){

        Contato contato = new Contato();
        contato.setNome("Melissa Chaves");
        contato.setEmail("melissa@gmail.com");
        contato.setDataNascimento(LocalDate.of(2000,2,21));

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

    public static void consultaPorId(EntityManager em){

        ContatoDao contatoDao = new ContatoDao(em);

        contatoDao.consultarContatoPorId(22L);

    }

    public static void consultarTodosOsContatos(EntityManager em){
        ContatoDao contatoDao = new ContatoDao(em);

        List<Contato> contatos = contatoDao.listarTodosContatos();

        for (Contato contato : contatos){
            System.out.println("-----------------------------------------");
            System.out.println(contato.toString());
            System.out.println("-----------------------------------------");
        }
        System.out.println("Registros finalizados !");
    }

    public static void consultarContatosPorNome(EntityManager em){
        ContatoDao contatoDao = new ContatoDao(em);

        List<Contato> contatos = contatoDao.listarContatoPorNome("Caio Arruda");

        for (Contato contato : contatos){
            System.out.println("-----------------------------------------");
            System.out.println(contato.toString());
            System.out.println("-----------------------------------------");
        }
        System.out.println("Registros finalizados !");
    }

}
