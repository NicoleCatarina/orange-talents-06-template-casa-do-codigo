package br.com.zupacademy.nicolecatarina.casadocodigo.paisestado;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;
    @ManyToOne
    @NotNull
    @Valid
    private Pais pais;

    public Estado(String nome, Pais pais) {
        this.nome = nome;
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Estado [id=" + id + ", nome=" + nome + ", pais=" + pais + "]";
    }

    @Deprecated
    public Estado() {
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public boolean pertenceAPais(Pais pais) {
        return this.pais.equals(pais);
    }
}
