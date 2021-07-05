package br.com.zupacademy.nicolecatarina.casadocodigo.cliente;

import br.com.zupacademy.nicolecatarina.casadocodigo.validation.validator.EstadoPertenceAPaisValidator;
import br.com.zupacademy.nicolecatarina.casadocodigo.validation.validator.VerificaDocumentoCpfCnpjValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class ClienteController {

    @PersistenceContext
    private EntityManager manager;

    @Autowired
    private EstadoPertenceAPaisValidator estadoPertenceAPaisValidator;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(new VerificaDocumentoCpfCnpjValidator(),estadoPertenceAPaisValidator);
    }

    @PostMapping(value = "/clientes")
    @Transactional
    public String criaClientes(@RequestBody @Valid NovoClienteRequest novoClienteRequest) {

        Cliente novoCliente = novoClienteRequest.toModel(manager);
        manager.persist(novoCliente);

        return novoCliente.toString();
    }
}
