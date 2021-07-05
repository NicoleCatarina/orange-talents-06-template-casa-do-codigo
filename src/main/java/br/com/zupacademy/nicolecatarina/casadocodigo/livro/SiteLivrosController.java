package br.com.zupacademy.nicolecatarina.casadocodigo.livro;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RestController
public class SiteLivrosController {

    @PersistenceContext
    private EntityManager manager;

    @GetMapping(value = "/produtos/{id}")
    public ResponseEntity<?> siteLivro(@PathVariable("id") Long id) {

        Livro livroBuscado = manager.find(Livro.class, id);
        //regra criada pois o find retorna nulo.
        if (livroBuscado == null){
            return ResponseEntity.notFound().build();
        }

        SiteLivroResponse siteLivroResponse = new SiteLivroResponse(livroBuscado);
        return ResponseEntity.ok(siteLivroResponse);
    }
}
