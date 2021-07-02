package br.com.zupacademy.nicolecatarina.casadocodigo.livro;

import br.com.zupacademy.nicolecatarina.casadocodigo.livro.Livro;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ListaLivrosController {

    @PersistenceContext
    private EntityManager manager;

//    @GetMapping(value = "/lista-tudo")
//    public HashMap<String, Object> List() {
//        List autores = manager.createQuery("select a from Autor a").getResultList();
//
//        HashMap<String, Object> resultado = new HashMap<>();
//        resultado.put("autores", autores.toString());
//
//        List categorias = manager.createQuery("select c from Categoria c").getResultList();
//        resultado.put("categorias", categorias.toString());
//
//        return resultado;
//    }

    @GetMapping(value = "/lista-livros")
    public List<String> List() {
        List<Livro> livros = manager.createQuery("select a from Livro a").getResultList();

        List<String> list = new ArrayList<> ();
        livros.forEach(livro -> list.add(livro.detailsToString()));

        return list;
    }
}
