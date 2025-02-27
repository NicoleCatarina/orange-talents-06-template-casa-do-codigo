package br.com.zupacademy.nicolecatarina.casadocodigo.categoria;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class CategoriasController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping(value = "/categorias")
    @Transactional
    public String cria(@RequestBody @Valid NovaCategoriaRequest novaCategoriaRequest) {

        Categoria novaCategoria = new Categoria(novaCategoriaRequest.getNome());
        manager.persist(novaCategoria);

        return novaCategoria.toString();
    }
}
