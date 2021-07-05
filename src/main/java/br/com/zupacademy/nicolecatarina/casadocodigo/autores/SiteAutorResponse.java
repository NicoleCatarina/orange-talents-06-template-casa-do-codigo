package br.com.zupacademy.nicolecatarina.casadocodigo.autores;

public class SiteAutorResponse {

    private String nome;
    private String descricao;

    public SiteAutorResponse(Autor autor) {
        nome = autor.getNome();
        descricao = autor.getDescricao();
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}
