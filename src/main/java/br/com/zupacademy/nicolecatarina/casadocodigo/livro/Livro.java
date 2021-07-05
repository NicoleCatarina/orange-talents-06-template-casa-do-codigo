package br.com.zupacademy.nicolecatarina.casadocodigo.livro;

import br.com.zupacademy.nicolecatarina.casadocodigo.autores.Autor;
import br.com.zupacademy.nicolecatarina.casadocodigo.categoria.Categoria;
import com.sun.xml.bind.marshaller.Messages;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private @NotBlank String titulo;
    private @NotBlank @Size(max = 500) String resumo;
    private @NotBlank String sumario;
    private @NotNull @Min(20) BigDecimal preco;
    private @Min(100) int numeroPaginas;
    private @NotBlank String isbn;
    @NotNull
    private @Future LocalDate dataPublicacao;
    @ManyToOne
    private @NotNull @Valid Autor autor;
    @ManyToOne
    private @NotNull @Valid Categoria categoria;

    public Livro(String titulo, String resumo, String sumario, BigDecimal preco,
                 int numeroPaginas, String isbn, LocalDate dataPublicacao, Autor autor,
                 Categoria categoria) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.autor = autor;
        this.categoria = categoria;
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

    public Autor getAutor() {
        return autor;
    }

    @Override
    public String toString() {
        return "Livro [id=" + id + ", titulo=" + titulo + ", resumo='" + resumo
                + ", sumario=" + sumario + ", preco=" + preco
                + ", numeroPaginas=" + numeroPaginas + ", isbn=" + isbn
                + ", dataPublicacao=" + dataPublicacao + ", autor=" + autor
                + ", categoria=" + categoria + "]";
    }


    public String detailsToString() {
        return "Livro [id=" + id + ", titulo=" + titulo + "]";
    }

    @Deprecated
    public Livro() {
    }

    public LocalDate getDataPublicacao() {
        return this.dataPublicacao;
    }
}
