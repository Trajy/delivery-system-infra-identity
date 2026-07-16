package br.com.trajy.delivery.infra.identity.core.context.credential.domain.model.factory;

import br.com.trajy.delivery.infra.identity.core.context.credential.domain.model.enums.HashAlgorithmType;
import br.com.trajy.delivery.infra.identity.core.context.credential.domain.model.aggregate.PasswordCredential;
import br.com.trajy.delivery.infra.identity.core.context.user.domain.model.aggregate.User;

import static br.com.trajy.delivery.infra.identity.core.common.exception.UnsupportedInstantiationException.utilityClassUnsupportedInstantiationException;
import static br.com.trajy.delivery.infra.identity.core.context.credential.domain.model.enums.CredentialStatus.ACTIVE;

public final class PasswordCredentialFactory {

    private PasswordCredentialFactory() {
        utilityClassUnsupportedInstantiationException();
    }

    public static PasswordCredential create(User user, String passwordHash, HashAlgorithmType hashAlgorithmType) {
        final PasswordCredential model = new PasswordCredential();
        model.setUser(user);
        model.setPasswordHash(passwordHash);
        model.setHashAlgorithmType(hashAlgorithmType);
        model.setStatus(ACTIVE);
        return model;
    }

}
