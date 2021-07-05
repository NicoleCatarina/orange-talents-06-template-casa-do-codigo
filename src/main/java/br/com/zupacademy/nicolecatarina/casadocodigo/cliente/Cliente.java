package br.com.zupacademy.nicolecatarina.casadocodigo.cliente;

import br.com.zupacademy.nicolecatarina.casadocodigo.paisestado.Estado;
import br.com.zupacademy.nicolecatarina.casadocodigo.paisestado.Pais;
import org.springframework.util.Assert;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Email
    private String email;
    private @NotBlank String nome;
    private @NotBlank String sobrenome;
    private @NotBlank String documento;
    private @NotBlank String endereco;
    private @NotBlank String complemento;
    private @NotBlank String cidade;
    private @NotBlank String telefone;
    private @NotBlank String cep;
    @ManyToOne
    private Pais pais;
    @ManyToOne
    private Estado estado;

    public Cliente(@NotBlank @Email String email, @NotBlank String nome, @NotBlank String sobrenome,
                   @NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento,
                   @NotBlank String cidade, @NotBlank String telefone, Pais pais) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.telefone = telefone;
        this.cep = cep;
        this.pais = pais;
        this.estado = estado;
    }

    public void setEstado(Estado estado) {
        Assert.notNull(pais,"Não rola associar um estado enquanto o pais for nulo");
        Assert.isTrue(estado.pertenceAPais(pais),"Este estado não é do país associado a compra");
        this.estado = estado;
    }

}
