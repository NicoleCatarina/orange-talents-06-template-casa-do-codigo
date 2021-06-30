package br.com.zupacademy.nicolecatarina.casadocodigo.exception;

import br.com.zupacademy.nicolecatarina.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.nicolecatarina.casadocodigo.request.Autor;
import br.com.zupacademy.nicolecatarina.casadocodigo.request.NovoAutorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


import java.util.Optional;

@Component
public class ProibeEmailDuplicadoAutorValidator implements Validator {

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return NovoAutorRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }
        NovoAutorRequest novoAutorRequest = (NovoAutorRequest) target;

        Optional<Autor> possivelAutor = autorRepository.findByEmail(novoAutorRequest.getEmail());

        if(possivelAutor.isPresent()) {
            errors.rejectValue("email", null,
                    "Ja existe um(a) outro(a) autor(a) com o mesmo email "+novoAutorRequest.getEmail());
        }
    }
}
