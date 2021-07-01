package br.com.zupacademy.nicolecatarina.casadocodigo.controller;

import br.com.zupacademy.nicolecatarina.casadocodigo.request.Livro;
import br.com.zupacademy.nicolecatarina.casadocodigo.request.NovoLivroRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class LivrosController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping(value = "/livros")
    @Transactional
    public String cria(@RequestBody @Valid NovoLivroRequest novoLivroRequest) {
        Livro novoLivro = novoLivroRequest.toModel(manager);
        manager.persist(novoLivro);
        return novoLivro.toString();
    }
}
