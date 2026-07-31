package br.com.trajy.delivery.infra.identity.core.context.credential.domain.model.factory;

import br.com.trajy.delivery.infra.identity.core.context.credential.domain.model.aggregate.PasswordCredentialAggregate;
import br.com.trajy.delivery.infra.identity.core.context.user.domain.model.aggregate.UserAggregate;

import static br.com.trajy.delivery.infra.identity.core.common.exception.type.UnsupportedInstantiationException.utilityClassUnsupportedInstantiationException;
import static br.com.trajy.delivery.infra.identity.core.context.credential.domain.model.enums.CredentialStatus.ACTIVE;

public final class PasswordCredentialFactory {

    private PasswordCredentialFactory() {
        utilityClassUnsupportedInstantiationException();
    }

    public static PasswordCredentialAggregate createPasswordCredential(UserAggregate user) {
        final PasswordCredentialAggregate model = new PasswordCredentialAggregate();
        model.setUser(user);
        model.setStatus(ACTIVE);
        return model;
    }

}
