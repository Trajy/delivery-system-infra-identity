package br.com.trajy.delivery.infra.identity.core.feature.credential.domain.modelfactory;

import br.com.trajy.delivery.infra.identity.core.feature.credential.domain.enums.HashAlgorithmType;
import br.com.trajy.delivery.infra.identity.core.feature.credential.domain.model.PasswordCredential;
import br.com.trajy.delivery.infra.identity.core.feature.user.domain.model.User;

import static br.com.trajy.delivery.infra.identity.core.common.exception.UnsupportedInstantiationException.utilityClassUnsupportedInstantiationException;
import static br.com.trajy.delivery.infra.identity.core.feature.credential.domain.enums.CredentialStatus.ACTIVE;

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
