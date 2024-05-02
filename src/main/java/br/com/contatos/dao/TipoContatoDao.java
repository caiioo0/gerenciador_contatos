package br.com.contatos.dao;

import br.com.contatos.model.Contato;
import br.com.contatos.model.TipoContato;
import jakarta.persistence.EntityManager;

public class TipoContatoDao {

    private EntityManager em;

    public TipoContatoDao(EntityManager em){
        this.em = em;
    }

    public void save(TipoContato tipoContato){
        em.persist(tipoContato);
    }

    public void update(TipoContato tipoContato){
        em.merge(tipoContato);
    }

    public void delete(TipoContato tipoContato){
        TipoContato contatoDeletado = em.find(TipoContato.class,tipoContato.getId());
        em.remove(contatoDeletado);
    }

}
