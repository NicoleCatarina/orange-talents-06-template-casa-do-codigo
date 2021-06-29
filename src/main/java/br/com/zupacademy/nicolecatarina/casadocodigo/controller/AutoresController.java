package br.com.zupacademy.nicolecatarina.casadocodigo.controller;

import br.com.zupacademy.nicolecatarina.casadocodigo.request.Autor;
import br.com.zupacademy.nicolecatarina.casadocodigo.request.NovoAutorRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RequestMapping(value = "/autores")
@RestController
public class AutoresController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public String cadastrarAutor(@RequestBody @Valid NovoAutorRequest novoAutorRequest) {
        Autor autor = novoAutorRequest.toModel();
        entityManager.persist(autor);
        return autor.toString();
    }

}
