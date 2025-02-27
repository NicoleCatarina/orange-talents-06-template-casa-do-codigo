package br.com.zupacademy.nicolecatarina.casadocodigo.paisestado;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class PaisController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping(value = "/paises")
    @Transactional
    public String criaPais(@RequestBody @Valid NovoPaisRequest novoPaisRequest) {
        Pais novoPais = new Pais (novoPaisRequest.getNome());
        manager.persist(novoPais);
        return novoPais.toString();
    }
}
