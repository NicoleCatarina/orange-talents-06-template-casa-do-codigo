package br.com.zupacademy.nicolecatarina.casadocodigo.paisestado;

import br.com.zupacademy.nicolecatarina.casadocodigo.validation.annotation.UniqueValue;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class NovoPaisRequest {

    @NotBlank
    @UniqueValue(domainClass = Pais.class, fieldName = "nome")
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
