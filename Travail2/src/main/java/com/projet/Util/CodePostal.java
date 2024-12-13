//Ludovic Hébert et Enrik Bernier
package com.projet.Util;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Documented
@Constraint(validatedBy = ValidateurCodePostal.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CodePostal {
    String message() default "Code Postal ne respecte pas les formats suivants: XAX AXA, XAX-AXA ou XAXAXA";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
