package br.com.zupacademy.nicolecatarina.casadocodigo.request;

import br.com.zupacademy.nicolecatarina.casadocodigo.exception.UniqueValue;

import javax.validation.constraints.NotBlank;

public class NovaCategoriaRequest {

    @NotBlank
    @UniqueValue(domainClass = Categoria.class, fieldName = "nome")
    private String nome;

    //public NovaCategoriaRequest(String nome) {
    //    super();
    //    this.nome = nome;
    //}

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
