package br.com.trajy.delivery.infra.identity.core.context.credential.annotation;

import br.com.trajy.delivery.infra.identity.core.context.credential.domain.model.enums.HashAlgorithmType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface HashAlgorithm {

    HashAlgorithmType value();

}
