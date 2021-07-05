package br.com.zupacademy.nicolecatarina.casadocodigo.paisestado;

import br.com.zupacademy.nicolecatarina.casadocodigo.validation.annotation.UniqueValue;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class NovoEstadoRequest {

    @NotBlank
    @UniqueValue(domainClass = Estado.class, fieldName = "nome")
    private String nome;
    @NotNull
    @UniqueValue(domainClass = Pais.class, fieldName = "id")
    private Long idPais;

    public NovoEstadoRequest(String nome, Long idPais) {
        super();
        this.nome = nome;
        this.idPais = idPais;
    }

    @Override
    public String toString() {
        return "NovoEstadoRequest [nome=" + nome + ", idPais=" + idPais + "]";
    }

    public Estado toModel(EntityManager manager) {
        return new Estado(nome, manager.find(Pais.class, idPais));
    }
}
