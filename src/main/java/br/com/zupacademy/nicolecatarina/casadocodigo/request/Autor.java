package br.com.zupacademy.nicolecatarina.casadocodigo.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.util.Assert;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private @NotBlank String nome;
    private @NotBlank @Email String email;
    private @NotBlank @Size(max = 400) String descricao;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime instanteCriacao = LocalDateTime.now();

    public Autor(@NotBlank String nome, @NotBlank @Email String email,
                 @NotBlank @Size(max = 400) String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Autor [nome=" + nome + ". email=" + email + ", descricao=" + descricao + ", " +
                "instanteCriacao=" + instanteCriacao + "]";
    }
}
