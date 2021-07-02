package br.com.zupacademy.nicolecatarina.casadocodigo.validation.annotation;

import br.com.zupacademy.nicolecatarina.casadocodigo.validation.validator.ExistsIdValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {ExistsIdValidator.class})
@Target({ ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistsId {

    String message() default "{com.deveficiente.beanvalidation.existsId}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    String fieldName();

    Class<?> domainClass();
}
