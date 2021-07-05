package br.com.zupacademy.nicolecatarina.casadocodigo.validation.validator;

import br.com.zupacademy.nicolecatarina.casadocodigo.cliente.NovoClienteRequest;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Objects;

public class VerificaDocumentoCpfCnpjValidator implements Validator {

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
        if (!novoClienteRequest.documentoValido()) {
            errors.rejectValue("documento", null, "Documento precisa ser CPF ou CNPJ");
        }
    }
}
