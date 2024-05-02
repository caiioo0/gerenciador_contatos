package br.com.contatos.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="tb_contatos")
public class Contato {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "TB_CONTATOS_SEQ")
    @SequenceGenerator(
            name = "TB_CONTATOS_SEQ",
            sequenceName = "TB_CONTATOS_SEQ",
            allocationSize = 1)
    private Long id;
    private String nome;
    private String email;
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;
    @ManyToOne
    private TipoContato tipoContato;

    public TipoContato getTipoContato() {
        return tipoContato;
    }

    public void setTipoContato(TipoContato tipoContato) {
        this.tipoContato = tipoContato;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return "Contato{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", tipoContato=" + tipoContato +
                '}';
    }
}
