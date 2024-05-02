package br.com.contatos.dao;

import br.com.contatos.model.Contato;
import br.com.contatos.model.TipoContato;
import jakarta.persistence.EntityManager;

import java.util.List;

public class TipoContatoDao {

    private EntityManager em;

    public TipoContatoDao(EntityManager em) {
        this.em = em;
    }

    public void save(TipoContato tipoContato) {
        em.persist(tipoContato);
    }

    public void update(TipoContato tipoContato) {
        em.merge(tipoContato);
    }

    public void delete(TipoContato tipoContato) {
        TipoContato contatoDeletado = em.find(TipoContato.class, tipoContato.getId());
        em.remove(contatoDeletado);
    }

    public TipoContato consultarTipoContatoPorId(TipoContato tipoContato) {
        return em.find(TipoContato.class, tipoContato.getId());
    }
}