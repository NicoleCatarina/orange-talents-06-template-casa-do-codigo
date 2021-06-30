package br.com.zupacademy.nicolecatarina.casadocodigo.controller;

import br.com.zupacademy.nicolecatarina.casadocodigo.exception.ProibeEmailDuplicadoAutorValidator;
import br.com.zupacademy.nicolecatarina.casadocodigo.request.Autor;
import br.com.zupacademy.nicolecatarina.casadocodigo.request.NovoAutorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class AutoresController {

    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private ProibeEmailDuplicadoAutorValidator proibeEmailDuplicadoAutorValidator;

    @InitBinder
    public void init(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(proibeEmailDuplicadoAutorValidator);
    }

    @PostMapping(value = "/autores")
    @Transactional
    public String cadastrarAutor(@RequestBody @Valid NovoAutorRequest novoAutorRequest) {
        Autor autor = novoAutorRequest.toModel();
        entityManager.persist(autor);
        return autor.toString();

    }

}
