package br.com.trajy.delivery.infra.identity.core.context.credential.domain.model.factory;

import br.com.trajy.delivery.infra.identity.core.context.credential.domain.model.aggregate.PasswordCredentialAggregate;
import br.com.trajy.delivery.infra.identity.core.context.user.domain.model.aggregate.UserAggregate;
import br.com.trajy.delivery.infra.identity.core.feature.password.model.wrapper.input.CreateWithPasswordCredentialWrapperInput;
import br.com.trajy.delivery.infra.identity.core.feature.password.model.wrapper.input.LoginWithPasswordCredentialWrapperInput;

import static br.com.trajy.delivery.infra.identity.core.common.exception.type.UnsupportedInstantiationException.utilityClassUnsupportedInstantiationException;
import static br.com.trajy.delivery.infra.identity.core.context.credential.domain.model.enums.CredentialStatus.ACTIVE;

public final class PasswordCredentialFactory {

    private PasswordCredentialFactory() {
        utilityClassUnsupportedInstantiationException();
    }

    public static void populatePasswordCredential(PasswordCredentialAggregate aggregate, UserAggregate userAggregate, CreateWithPasswordCredentialWrapperInput input) {
        aggregate.setUser(userAggregate);
        aggregate.setHashAlgorithmType(input.hashAlgorithmType());
        aggregate.setStatus(ACTIVE);
    }

    public static void populatePasswordCredential(PasswordCredentialAggregate aggregate, UserAggregate userAggregate, LoginWithPasswordCredentialWrapperInput input) {
        aggregate.setUser(userAggregate);
        aggregate.setHashAlgorithmType(input.hashAlgorithmType());
        aggregate.setStatus(ACTIVE);
    }

}
