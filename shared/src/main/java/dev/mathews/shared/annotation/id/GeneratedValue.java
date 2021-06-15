package dev.mathews.shared.annotation.id;

import dev.mathews.shared.enumeration.GenerationType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD})
public @interface GeneratedValue {
    /**
     * meu enorme ta gigante
     * @return
     */
    GenerationType generationType();
}