package br.com.contatos.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_tipo_contato")
public class TipoContato {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "TB_TIPO_CONTATO_SEQ")
    @SequenceGenerator(
            name = "TB_TIPO_CONTATO_SEQ",
            sequenceName = "TB_TIPO_CONTATO_SEQ",
            allocationSize = 1)
    private Long id;
    private String tipo;
    @OneToMany(mappedBy = "tipoContato")
    private List<Contato> contatos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }

    //    @Override
//    public String toString() {
//        return "TipoContato{" +
//                "id=" + id +
//                ", tipo='" + tipo + '\'' +
//                '}';
//    }
}
