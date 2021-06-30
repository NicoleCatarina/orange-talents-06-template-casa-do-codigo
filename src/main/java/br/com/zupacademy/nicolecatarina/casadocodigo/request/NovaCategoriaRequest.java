package br.com.zupacademy.nicolecatarina.casadocodigo.request;

import javax.validation.constraints.NotBlank;

public class NovaCategoriaRequest {

    @NotBlank
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
