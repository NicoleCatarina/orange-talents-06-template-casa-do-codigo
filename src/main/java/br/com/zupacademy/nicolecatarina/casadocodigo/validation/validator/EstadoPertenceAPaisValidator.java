package br.com.zupacademy.nicolecatarina.casadocodigo.validation.validator;

import br.com.zupacademy.nicolecatarina.casadocodigo.cliente.NovoClienteRequest;
import br.com.zupacademy.nicolecatarina.casadocodigo.paisestado.Estado;
import br.com.zupacademy.nicolecatarina.casadocodigo.paisestado.Pais;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class EstadoPertenceAPaisValidator implements Validator {

    @PersistenceContext
    private EntityManager manager;

    public EstadoPertenceAPaisValidator(EntityManager manager) {
        super();
        this.manager = manager;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return NovoClienteRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }

        NovoClienteRequest novoClienteRequest = (NovoClienteRequest) target;

        if (novoClienteRequest.temEstado()) {
            Pais pais = manager.find(Pais.class, novoClienteRequest.getIdPais());
            Estado estado = manager.find(Estado.class, novoClienteRequest.getIdEstado());
            if (!estado.pertenceAPais(pais)) {
                    errors.rejectValue("idEstado", null, "Este estado não é do país selecionado.");
            }
        }

    }
}
