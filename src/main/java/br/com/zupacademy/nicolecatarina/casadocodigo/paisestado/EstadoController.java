package br.com.zupacademy.nicolecatarina.casadocodigo.paisestado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class EstadoController {

    @Autowired
    private EntityManager manager;

    @PostMapping(value = "/estados")
    @Transactional
    public String criaEstado(@RequestBody @Valid NovoEstadoRequest novoEstadoRequest) {
        Estado novoEstado = novoEstadoRequest.toModel(manager);
        manager.persist(novoEstado);
        return novoEstado.toString();
    }
}