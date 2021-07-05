package br.com.zupacademy.nicolecatarina.casadocodigo.cliente;

import br.com.zupacademy.nicolecatarina.casadocodigo.paisestado.Estado;
import br.com.zupacademy.nicolecatarina.casadocodigo.paisestado.Pais;
import br.com.zupacademy.nicolecatarina.casadocodigo.validation.annotation.Documento;
import br.com.zupacademy.nicolecatarina.casadocodigo.validation.annotation.ExistsId;
import br.com.zupacademy.nicolecatarina.casadocodigo.validation.annotation.UniqueValue;

import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;


public class NovoClienteRequest {

    @NotBlank
    @Email
    @UniqueValue(domainClass = Cliente.class, fieldName = "email")
    public String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotBlank
    @Documento
    @UniqueValue(domainClass = Cliente.class, fieldName = "documento")
    private String documento;
    @NotBlank
    private String endereco;
    @NotBlank
    private String complemento;
    @NotBlank
    private String cidade;
    @NotBlank
    private String telefone;
    @NotBlank
    private String cep;
    @NotNull
    @ExistsId(domainClass = Estado.class, fieldName = "id")
    private Long idEstado;
    @NotNull
    @ExistsId(domainClass = Pais.class, fieldName = "id")
    private Long idPais;

    public NovoClienteRequest(String email, String nome, String sobrenome, String documento, String endereco,
                              String complemento, String cidade, String telefone, String cep, Long idEstado, Long idPais) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.telefone = telefone;
        this.cep = cep;
        this.idEstado = idEstado;
        this.idPais = idPais;
    }


    public String getDocumento() {
        return documento;
    }

    public Long getIdPais() {
        return idPais;
    }

    public Long getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Long idEstado) {
        this.idEstado = idEstado;
    }

    @Override
    public String toString() {
        return "NovoClienteRequest{" +
                "email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", documento='" + documento + '\'' +
                ", endereco='" + endereco + '\'' +
                ", complemento='" + complemento + '\'' +
                ", cidade='" + cidade + '\'' +
                ", telefone='" + telefone + '\'' +
                ", cep='" + cep + '\'' +
                ", idEstado=" + idEstado +
                ", idPais=" + idPais +
                '}';
    }

    public boolean documentoValido() {
        Assert.hasLength(documento, "Você não deveria validar o documento se ele não tiver sido preenchido");

        CPFValidator cpfValidator = new CPFValidator();
        cpfValidator.initialize(null);

        CNPJValidator cnpjValidator = new CNPJValidator();
        cnpjValidator.initialize(null);

        return cpfValidator.isValid(documento, null) || cnpjValidator.isValid(documento, null);

    }

    public boolean temEstado() {
        return Optional.ofNullable(idEstado).isPresent();
    }

    public Cliente toModel(EntityManager manager) {
        @NotNull
        Pais pais = manager.find(Pais.class, idPais);

        Cliente cliente = new Cliente(email, nome, sobrenome, documento, endereco, complemento,
                 telefone, cep, pais);

        if (idEstado != null) {
            cliente.setEstado(manager.find(Estado.class, idEstado));
        }

        return cliente;
    }
}
