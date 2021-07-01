package br.com.zupacademy.nicolecatarina.casadocodigo.request;

import br.com.zupacademy.nicolecatarina.casadocodigo.exception.ExistsId;
import br.com.zupacademy.nicolecatarina.casadocodigo.exception.UniqueValue;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class NovoLivroRequest {

    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "titulo")
    private String titulo;
    @NotBlank
    @Size(max = 500)
    private String resumo;
    @NotBlank
    private String sumario;
    @NotNull
    @Min(20)
    private BigDecimal preco;
    @Min(100)
    private int numeroPaginas;
    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "isbn")
    private String isbn;
    @NotNull
    @Future
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataPublicacao;
    @NotNull
    @ExistsId(domainClass = Categoria.class,fieldName = "id")
    private Long idCategoria;
    @NotNull
    @ExistsId(domainClass = Autor.class,fieldName = "id")
    private Long idAutor;

    public NovoLivroRequest(String titulo, String resumo, String sumario, BigDecimal preco,
                            int numeroPaginas, String isbn, Long idCategoria,
                            Long idAutor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.idCategoria = idCategoria;
        this.idAutor = idAutor;
    }

    /*
     *Criei esse setter pq o Jackson não estava sendo capaz de desserializar o json com
     *  a data no parâmentro pelo construtor
     */
    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public Livro toModel(EntityManager manager) {
        Autor autor = manager.find(Autor.class, idAutor);
        Categoria categoria = manager.find(Categoria.class, idCategoria);

        Assert.state(autor!=null, "Você esta querendo cadastrar um livro" +
                " para um autor que não existe no banco "+idAutor);
        Assert.state(categoria!=null, "Você esta querendo cadastrar um livro" +
                " em uma categoria que não existe no banco "+idAutor);

        return new Livro(titulo, resumo, sumario, preco, numeroPaginas, isbn, dataPublicacao,
                autor, categoria);
    }
}
