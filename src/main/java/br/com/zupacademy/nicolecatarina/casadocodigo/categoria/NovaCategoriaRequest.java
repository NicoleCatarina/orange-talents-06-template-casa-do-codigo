package br.com.zupacademy.nicolecatarina.casadocodigo.categoria;

import br.com.zupacademy.nicolecatarina.casadocodigo.categoria.Categoria;
import br.com.zupacademy.nicolecatarina.casadocodigo.validation.annotation.UniqueValue;

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
