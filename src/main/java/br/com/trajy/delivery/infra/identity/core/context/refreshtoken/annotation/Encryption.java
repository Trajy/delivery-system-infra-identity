package br.com.trajy.delivery.infra.identity.core.context.refreshtoken.annotation;

import br.com.trajy.delivery.infra.identity.core.context.refreshtoken.domain.model.enums.EncryptionType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Encryption {

    EncryptionType value();

}
