package br.com.contatos.dao;

import br.com.contatos.model.Contato;
import jakarta.persistence.EntityManager;

import java.util.List;

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

    public void consultarContatoPorId(Long id){
        Contato contactQuery = em.find(Contato.class, id);
        if (contactQuery == null){
            System.out.println("Contato não foi encontrado");
        }else {
            System.out.println("-----------------------");
            System.out.println(contactQuery.toString());
            System.out.println("-----------------------");
        }
    }

    public List<Contato> listarTodosContatos(){
        //JPQL
        String consulta = "SELECT c FROM Contato c ORDER BY nome ASC";
        return em.createQuery(consulta).getResultList();
    }

    public List<Contato> listarContatoPorEmail(String email){
        String consulta = "SELECT c FROM Contato c WHERE email = :email";
        return em.createQuery(consulta, Contato.class).setParameter("email", email).getResultList();
    }

    public List<Contato> listarContatoPorNome(String nome){
        String consulta = "SELECT c FROM Contato c WHERE nome = :nome";
        return em.createQuery(consulta, Contato.class).setParameter("nome", nome).getResultList();
    }

}
