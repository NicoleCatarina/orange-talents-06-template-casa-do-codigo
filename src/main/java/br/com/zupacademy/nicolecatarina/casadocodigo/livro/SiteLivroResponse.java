package br.com.zupacademy.nicolecatarina.casadocodigo.livro;

import br.com.zupacademy.nicolecatarina.casadocodigo.autores.Autor;
import br.com.zupacademy.nicolecatarina.casadocodigo.autores.SiteAutorResponse;
import br.com.zupacademy.nicolecatarina.casadocodigo.categoria.Categoria;

import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SiteLivroResponse {

    private String titulo;
    private String resumo;
    private String sumario;
    private BigDecimal preco;
    private int numeroPaginas;
    private String isbn;
    private SiteAutorResponse autor;
    private String dataPublicacao;

    public SiteLivroResponse(Livro livro) {
        titulo = livro.getTitulo();
        resumo = livro.getResumo();
        sumario = livro.getSumario();
        preco = livro.getPreco();
        numeroPaginas = livro.getNumeroPaginas();
        isbn = livro.getIsbn();
        autor = new SiteAutorResponse(livro.getAutor());
        dataPublicacao = livro.getDataPublicacao()
                .format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public String getDataPublicacao() {
        return dataPublicacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public SiteAutorResponse getAutor() {
        return autor;
    }
}
